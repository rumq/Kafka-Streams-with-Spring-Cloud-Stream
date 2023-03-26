> [Home](Home.md)

# Chapter 6 Processing Kafka Streams    

## Status : IN_PROGRESS

## Real-Time Stream Processing Requirement

JOSN -> AVRO
AVRO -> JSON
 g
## Processing JSON Message Stream

[AvroPosFanoutApplication](../avroposfanout/src/main/java/guru/learningjournal/examples/kafka/avroposfanout/AvroPosFanoutApplication.java)

Create the project using SB 2.4.0, Java 11 and following dependencies

- Cloud Stream
- Spring for Apache Kafka
- Lombok

We are using Streams API not the Producer API

We need two additional dependencies see [pom](avroppos)

```xml
<dependency>
    <groupId>org.apache.avro</groupId>
    <artifactId>avro</artifactId>
    <version>1.9.2</version>
</dependency>
<dependency>
    <groupId>io.confluent</groupId>
    <artifactId>kafka-streams-avro-serde</artifactId>
    <version>6.0.0</version>
</dependency>
<dependency>
    <groupId>io.confluent</groupId>
    <artifactId>kafka-streams-json-schema-serde</artifactId>
    <version>6.0.0</version>
</dependency>
```

> [Home](HOME.md)
