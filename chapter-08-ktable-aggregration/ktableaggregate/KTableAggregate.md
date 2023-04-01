> [README](../README.md)

# KTabelAggregate

IN_PROGRESS

## Summary

The application listens to the topic `employees-topic` and prints the average salary for each department.
This computes the value correctly as KTable stores the state.
Contrast this with the KStreamAggregate example.


## Doing it on the command lie
```sh
# Start the Kafka docker container
docker-compose up -d

# Start the Kafka docker container
docker exec -ti <containerid> sh

# Start the aggregate application
cd chapter-08-ktable-aggregration/ktableaggregate
mvn spring-boot:run

# Start the employee producer
cd pawarv/avroposgen
mvn spring-boot:run
```

## Notes
See that the result shows 2 employees in both the departments which is incorrect.
The average salary in both comes to 2.5 which is correct.

