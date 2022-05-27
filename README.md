# Kafka-Producer-Consumer

# Pre-requisites:
1. Java
2. Kafka
3. Spring boot
4. Code Editor(Intellij, Eclipse etc.)
5. Azure Blob Storage(optional,If you have to write consume message to blob storage)

# Kafka Steps
 1. start zookeeper using the command given below:
 .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
 2. Run kafka server using the command:
.\bin\windows\kafka-server-start.bat .\config\server.properties
 3. For creating a topic, open a new command prompt and write the below command:
 .\bin\windows\kafka-topics.bat --create --topic <topicname> --bootstrap-server localhost:9092
 4. List Topics:
.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
 5. produce a message to a topic using the command:
.\bin\windows\kafka-console-producer.bat -broker-list localhost:9092 –topic <topic name>
 6. consume a message to a topic using the command:
.\bin\windows\kafka-console-consumer.bat -bootstrap-server localhost:9092 –topic <topic name>

  
 


