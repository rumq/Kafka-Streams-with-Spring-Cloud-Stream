> [README](../README.md)

# KTabelAggregate

IN_PROGRESS

## Summary

The application listens to the topic `employees-topic` and prints the average salary for each department.



## Doing it on the command lie
```sh
# Start the Kafka docker container
docker-compose up -d

# Start the Kafka docker container
docker exec -ti <containerid> sh

# Create the topic
kafka-topics --create --replication-factor 1 --partitions 1 --topic stock-tick-topic

# Start the producer
# This has not worked for me.

kafka-avro-console-producer --broker-list localhost:9092 --topic employees-topic \
--property value.schema='{"namespace": "guru.learningjournal.examples.kafka.model","type": "record","name": "Employee","fields": [{"name": "id","type": "string"},{"name": "name","type": "string"},{"name": "department","type": "string"},{"name": "salary","type":"int"}]}'


```

## Notes
I was not able to run this example as the producer was not working.
I tried using the Confluent Control Center to produce messages. 
I created the schema, and then tried to put a JSON message in the value field.
But this did not work. Not sure how to create an AVRO message using the Control Center.

