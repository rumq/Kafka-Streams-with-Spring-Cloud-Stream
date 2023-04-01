> [README](../README.md)

# AggregationDemo

## Summary

The application listens to the topic `streaming-words-topic`  and prints the count of each word.



## Doing it on the command lie
```sh
# Start the Kafka docker container
docker-compose up -d

# Start the Kafka docker container
docker exec -ti <containerid> sh

# Create the topic
kafka-topics --create --replication-factor 1 --partitions 1 --topic streaming-words-topic


# Start the producer
kafka-console-producer --topic streaming-words-topic --broker-list localhost:9092 

# Start the Spring Boot application
mvn spring-boot:run

# put the following messages, one after 

one two three four five six seven eight nine ten
one two
one

```

## Using the Control Center

Can't use for this example.