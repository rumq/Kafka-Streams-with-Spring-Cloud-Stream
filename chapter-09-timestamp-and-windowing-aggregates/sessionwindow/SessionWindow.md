> [README](../README.md)

# Session count

The application listens to the topic `user-clicks-topic` and prints the count of invoices for each user in the automatically identified session windows.

## Doing it on the command lie
```sh
# Start the Kafka docker container
docker-compose up -d

# Start the Kafka docker container
docker exec -ti <containerid> sh

# Create the topic
kafka-topics --create --replication-factor 1 --partitions 1 --topic user-clicks-topic --bootstrap-server localhost:9092

# Start the Spring Boot application
cd chapter-09-timestamp-and-windowing-aggregates/sessionwindow
mvn spring-boot:run

# Start the producer

kafka-console-producer --broker-list localhost:9092 --topic user-clicks-topic \
--property parse.key=true --property key.separator=":"

# Put the following messages one after the other
USR101:{"UserID": "USR101","CreatedTime": "1549360860000","CurrentLink": "NULL", "NextLink": "Home"}
USR102:{"UserID": "USR102","CreatedTime": "1549360920000","CurrentLink": "NULL", "NextLink": "Home"}
USR101:{"UserID": "USR101","CreatedTime": "1549361040000","CurrentLink": "Home", "NextLink": "Books"}
USR101:{"UserID": "USR101","CreatedTime": "1549361400000","CurrentLink": "Books", "NextLink": "Kafka"}
USR102:{"UserID": "USR102","CreatedTime": "1549360920000","CurrentLink": "NULL", "NextLink": "Home"}
USR102:{"UserID": "USR102","CreatedTime": "1549361400000","CurrentLink": "Home", "NextLink": "Courses"}
USR101:{"UserID": "USR101","CreatedTime": "1549361220000","CurrentLink": "Kafka", "NextLink": "Preview"}
USR101:{"UserID": "USR101","CreatedTime": "1549361940000","CurrentLink": "Preview", "NextLink": "Buy"}

```

The output will show the user counts for the identified session windows.

