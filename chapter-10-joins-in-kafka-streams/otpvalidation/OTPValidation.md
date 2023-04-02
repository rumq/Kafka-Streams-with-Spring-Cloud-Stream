> [README](../README.md)

# OTP Validation

The application listens to the two topics `payment-request` a

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

kafka-console-producer --broker-list localhost:9092 --topic payment_request \
--property parse.key=true --property key.separator=":"

kafka-console-producer --broker-list localhost:9092 --topic payment_confirmation \
--property parse.key=true --property key.separator=":"

# Put the following messages one after the other
STR1534:{"InvoiceNumber": 101,"CreatedTime": "1549360860000","StoreID": "STR1534", "TotalAmount": 1920}
STR1535:{"InvoiceNumber": 102,"CreatedTime": "1549360900000","StoreID": "STR1535", "TotalAmount": 1860}
STR1534:{"InvoiceNumber": 103,"CreatedTime": "1549360999000","StoreID": "STR1534", "TotalAmount": 2400}

STR1536:{"InvoiceNumber": 104,"CreatedTime": "1549361160000","StoreID": "STR1536", "TotalAmount": 8936}
STR1534:{"InvoiceNumber": 105,"CreatedTime": "1549361270000","StoreID": "STR1534", "TotalAmount": 6375}
STR1536:{"InvoiceNumber": 106,"CreatedTime": "1549361370000","StoreID": "STR1536", "TotalAmount": 9365}

```

The output will show that count of invoices for 34 is 2 in the first window of 10:01 to 10:05 and that os 36 is 2 in the second window of 10:06 to 10:10.
