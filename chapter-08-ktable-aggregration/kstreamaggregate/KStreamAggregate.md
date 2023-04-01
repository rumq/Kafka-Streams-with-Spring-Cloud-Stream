> [README](../README.md)

# KSreamAggregate 

IN_PROGRESS

## Summary

The application listens to the topic `employees-topic` and prints the average salary for each department.
This computes incorrect value when employees change department.
This happens because the the state is not stored when using streams.


## Doing it on the command lie
```sh
# Start the Kafka docker container
docker-compose up -d

# Start the Kafka docker container
docker exec -ti <containerid> sh

# Start the aggregate application
cd chapter-08-ktable-aggregration/kstreamaggregate
mvn spring-boot:run

# Start the employee producer
cd pawarv/avroposgen
mvn spring-boot:run
```

## Notes
See that the result shows 3 employees in both the departments which is incorrect.
