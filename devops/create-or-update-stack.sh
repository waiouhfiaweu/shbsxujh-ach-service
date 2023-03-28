#!/usr/bin/env bash

usage="Usage: $(basename "$0") region stack-name [aws-cli-opts]

where:
  region       - the AWS region
  stack-name   - the stack name
  aws-cli-opts - extra options passed directly to create-stack/update-stack
"

if [ "$1" == "-h" ] || [ "$1" == "--help" ] || [ "$1" == "help" ] || [ "$1" == "usage" ] ; then
  echo "$usage"
  exit -1
fi

if [ -z "$1" ] || [ -z "$2" ] || [ -z "$3" ] ; then
  echo "$usage"
  exit -1
fi

shopt -s failglob
set -eu -o pipefail

echo "Checking if stack exists ..."

DEPLOY_BUCKET_S3=$(jq -r '.pipeline.deploy."s3-bucket"' config.json)
DEPLOY_CAPABILITIES=$(jq -r '.pipeline.deploy."capabilities"' config.json)

if ! aws cloudformation describe-stacks --region $1 --stack-name $2 ; then

  echo -e "\nStack does not exist, packaging template..."
  aws cloudformation package --template-file template.yml --s3-bucket $DEPLOY_BUCKET_S3 --output-template-file out.yaml

  echo -e "\ncreating ..."
  aws cloudformation create-stack \
    --region $1 \
    --stack-name $2 \
    --capabilities $DEPLOY_CAPABILITIES \
    --template-body file://out.yaml \
    --parameters file://cloud_formation.json

  echo "Waiting for stack to be created ..."
  aws cloudformation wait stack-create-complete \
    --region $1 \
    --stack-name $2 \

else

  echo -e "\nStack exists, attempting update ..."

  echo -e "\nPackaging template ..."
  aws cloudformation package --template-file template.yml --s3-bucket $DEPLOY_BUCKET_S3 --output-template-file out.yaml

  set +e
  update_output=$( aws cloudformation update-stack \
    --region $1 \
    --stack-name $2 \
    --capabilities $DEPLOY_CAPABILITIES \
    --template-body file://out.yaml \
    --parameters file://cloud_formation.json 2>&1)
  status=$?
  set -e

  echo "$update_output"

  if [ $status -ne 0 ] ; then

    # Don't fail for no-op update
    if [[ $update_output == *"ValidationError"* && $update_output == *"No updates"* ]] ; then
      echo -e "\nFinished create/update - no updates to be performed"
      exit 0
    else
      exit $status
    fi

  fi

  echo "Waiting for stack update to complete ..."
  aws cloudformation wait stack-update-complete \
    --region $1 \
    --stack-name $2 \

fi

echo "Finished create/update successfully!"
