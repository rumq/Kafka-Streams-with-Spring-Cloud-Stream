> [README](../README.md)

# Last Login

The application listens to the two topics `user-master` and `user-login`. The `user-master` topic contains the user details, and the `user-login` topic contains the login details. The application will show the last login time of the user that are in the `user-master` topic.

## Doing it on the command lie
```sh
# Start the Kafka docker container
docker-compose up -d

# Start the Kafka docker container
docker exec -ti <containerid> sh

# Create the topic
kafka-topics --create --replication-factor 1 --partitions 1 --topic simple-invoice-topic --bootstrap-server localhost:9092

# Start the Spring Boot application
cd chapter-09-timestamp-and-windowing-aggregates/windowcount
mvn spring-boot:run

# Start the producer


kafka-console-producer --broker-list localhost:9092 --topic user-master \
--property parse.key=true --property key.separator=":"

kafka-console-producer --broker-list localhost:9092 --topic user-login \
--property parse.key=true --property key.separator=":"

# Put the following messages one after the other

## in user-master
100001:{"UserName": "Prashant", "LoginID": "100001", "LastLogin": 1550150109302}
100009:{"UserName": "Alisha", "LoginID": "100009", "LastLogin": 1550150280409}
100087:{"UserName": "Abdul", "LoginID": "100087", "LastLogin": 1550150290305}

## in user-login
100001:{"LoginID": "100001", "CreatedTime": 1550150291000}
100087:{"LoginID": "100087", "CreatedTime": 1550150580000}


```

The output will show that the user 1 & 87 have logged in, and have their last login time updated.
