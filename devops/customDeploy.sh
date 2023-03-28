#!/bin/bash

echo -e '[START]: CUSTOM DEPLOY\n'
environment=$(jq -r '.pipeline.deploy.parameters[] | select(.ParameterKey=="EnvironmentId") | .ParameterValue' config.json)
MigrateDynamoDBTables=$(jq -r '.pipeline.deploy.parameters[] | select(.ParameterKey=="MigrateDynamoDBTables") | .ParameterValue' config.json)
if [ "${MigrateDynamoDBTables}" != "" ] && [ "${MigrateDynamoDBTables}" == true ]
then
    echo -e '\n[START]: INIT\n'
    SuffixGlobalDynamoDbTable=$(jq -r '.pipeline.deploy.parameters[] | select(.parameterKey=="SuffixGlobalDynamoDbTable") | .parameterValue' config.json)
    if [ "${SuffixGlobalDynamoDbTable}" == "" ]
    then
        SuffixGlobalDynamoDbTable="_gt"
    fi
    echo -e '\n[START]: REPLY DYNAMODBTABLES\n'
    python3 ./devops/copy_dynamo.py ${environment}-cobis-channels-sequentials ${environment}-cobis-ach-sequentials${SuffixGlobalDynamoDbTable}
fi
DropDynamoDBTables=$(jq -r '.pipeline.deploy.parameters[] | select(.ParameterKey=="DropDynamoDBTables") | .ParameterValue' config.json)
if [ "${DropDynamoDBTables}" != "" ] && [ "${DropDynamoDBTables}" == true ]
then
    echo -e '\n[START]: INIT DROP Dynamo TABLES\n'
    python3 ./devops/delete_dynamo.py ${environment}-cobis-channels-sequentials
fi

echo -e '\n[END]: CUSTOM DEPLOY\n'