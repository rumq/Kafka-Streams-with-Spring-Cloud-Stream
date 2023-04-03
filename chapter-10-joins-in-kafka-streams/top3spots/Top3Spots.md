> [README](../README.md)

# Top 3 spots

NOT WORKING!!

The application listens to the two topics `active-inventories` and `ad-clicks` and calculates the top 3 news types that have the most number of clicks.

## Doing it on the command lie

```sh
# Start the Kafka docker container
docker-compose up -d

# Start the Kafka docker container
docker exec -ti <containerid> sh

# Create the topic
# there automatically created by the Spring Boot application
kafka-topics --create --replication-factor 1 --partitions 1 --topic `active-inventories` --bootstrap-server localhost:9092
kafka-topics --create --replication-factor 1 --partitions 1 --topic `ac-clicks` --bootstrap-server localhost:9092

# Start the Spring Boot application
cd chapter-10-joins-in-kafka-streams/top3spots
mvn spring-boot:run

# Start the producer

kafka-console-producer --broker-list localhost:9092 --topic active-inventories \
--property parse.key=true --property key.separator=":"

kafka-console-producer --broker-list localhost:9092 --topic ad-clicks \
--property parse.key=true --property key.separator=":"

# Put the following messages one after the other
# active-inventories
1001:{"InventoryID": "1001"}
1002:{"InventoryID": "1002"}
1003:{"InventoryID": "1003"}
1004:{"InventoryID": "1004"}
1004:{"InventoryID": "1004"}
1002:{"InventoryID": "1002"}

# ad-clicks
1001:{"InventoryID": "1001", "NewsType": "Sports"}
1002:{"InventoryID": "1002", "NewsType": "Politics"}
1003:{"InventoryID": "1003", "NewsType": "LocalNews"}
1004:{"InventoryID": "1004", "NewsType": "WorldNews"}
1005:{"InventoryID": "1005", "NewsType": "Health"}
1006:{"InventoryID": "1006", "NewsType": "Lifestyle"}
1007:{"InventoryID": "1007", "NewsType": "Literature"}
1008:{"InventoryID": "1008", "NewsType": "Education"}
1009:{"InventoryID": "1009", "NewsType": "Social"}
1010:{"InventoryID": "1010", "NewsType": "Business"}

```
