> [README](../README.md)

# KSreamAggregate 

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
kafka-console-producer --topic stock-tick-topic --broker-list localhost:9092 --property parse.key=true --property key.separator=":"

# Start the Spring Boot application
mvn spring-boot:run

# put the following messages, one after 

HDFCBANK:2120
HDFCBANK:2150
HDFCBANK:2180

TCS:2920


```

## Using the Control Center

Go to [Control Center](http://localhost:9021/) and create a topic called `stock-tick-topic`

Go to the the topic and click on `Produce Message`

Put the following messages, one after the other

In the key put "HDFCBANK" and in the value put "2120"

In the key put "HDFCBANK" and in the value put "2150"

In the key put "HDFCBANK" and in the value put "2180"

In the key put "TCS" and in the value put "2920"


