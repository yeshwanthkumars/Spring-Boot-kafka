# Spring-boot-kafka-partition-methods

## Sample Requests

## Direct Partition:

GET http://localhost:8080/kafka/direct/0/HelloPartition0

GET http://localhost:8080/kafka/direct/1/HelloPartition1


## Key-based Partition:

GET http://localhost:8080/kafka/key/user1/HelloUser1

GET http://localhost:8080/kafka/key/user1/AnotherUser1

GET http://localhost:8080/kafka/key/user2/HelloUser2


## Round Robin:

GET http://localhost:8080/kafka/round/NoKey1

GET http://localhost:8080/kafka/round/NoKey2

GET http://localhost:8080/kafka/round/NoKey3