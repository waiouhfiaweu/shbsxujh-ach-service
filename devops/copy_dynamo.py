import boto3
from boto3.dynamodb.conditions import Key, Attr
import sys
import os
import time

print("Inicia " + time.strftime("%H:%M:%S"))
# Get the service resource.
dynamodb = boto3.resource('dynamodb')

table = dynamodb.Table(sys.argv[1])
table_dst = dynamodb.Table(sys.argv[2])

print ("INITIAL TABLE " + str(table))
print ("FINAL TABLE " + str(table_dst))
results = []
last_evaluated_key = None
hash_key = ''
range_key = ''
while True:
        if last_evaluated_key is None:
            response = table.scan()
        else:
            response = table.scan(
                ExclusiveStartKey=last_evaluated_key
            )
            print ("ADDITIONAL PAGES")
        
        for item in response['Items']:
            new_item = {}
            if range_key != '':
                new_item[range_key] = item[range_key]
            for f in item.keys():
                if f in [hash_key, range_key]:
                    continue
                new_item[f] = item[f]
            try:
                table_dst.put_item(Item=new_item)
            except:
                print(str (table_dst))
        
        last_evaluated_key = response.get('LastEvaluatedKey')
        print ("last_evaluated_key: " + str(last_evaluated_key))
        
        if last_evaluated_key is None:
            break
   
print("FINISHED " + time.strftime("%H:%M:%S"))
# Fin del archivo