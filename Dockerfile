FROM java:8

ADD target/scala-2.11/akka-http-microservice-assembly-1.0.jar app.jar
ENTRYPOINT java -jar app.jar