#!bin/sh

SERVICE_NAME=sample_akka

docker rm -f $sample_akk

EX_PORT=9000
IN_PORT=9000

docker run -d -p $IN_PORT:$EX_PORT sample-akka-service -name $SERVICE_NAME