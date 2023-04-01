> [README](../README.md)

# Rewards



## Summary

The application listens to the topic `avros-pos-topic` , filters PRIME customers and aggregates the loyalty for the current invoice into total loyalty points and writes to another topic `loyalty-topic`. 

## Doing it on the command lie
```sh
# Start the Kafka docker container
docker-compose up -d

# Start the Kafka docker container
docker exec -ti <containerid> sh

# Create the topic
kafka-topics --create --replication-factor 1 --partitions 1 --topic loyalty-topic

# Start the PosInvoice generator
cd chapter-05-producing-data-to-kakfa/avroposgen
mvn spring-boot:run

# Start the Spring Boot application
cd chapter-08-ktable-aggregration/rewards
mvn spring-boot:run
```

The output will show the loyalty points for each customer. Can also check the topic `loyalty-topic` using the Control Center.
