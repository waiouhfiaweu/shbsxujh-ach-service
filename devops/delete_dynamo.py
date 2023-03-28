import boto3
from boto3.dynamodb.conditions import Key, Attr
import sys
import os
import time

print("Inicia " + time.strftime("%H:%M:%S"))
# Get the service resource.
dynamodb = boto3.client('dynamodb')
waiter = dynamodb.get_waiter('table_not_exists')
for table_name in sys.argv[1:]:
    try:
        print("Deleting", table_name, "table")
        dynamodb.delete_table(TableName=table_name)
        waiter.wait(
            TableName=table_name
        )
        print("Deleted", table_name, "table")
    except:
        print("Unable to delete", table_name, "table")
print("FINISHED " + time.strftime("%H:%M:%S"))
# Fin del archivo