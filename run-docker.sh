#!bin/sh

SERVICE_NAME=sample_akka

docker rm -f SERVICE_NAME
docker rm -f mysqld

EX_PORT=9000
IN_PORT=9000

docker run -d -p 3306:3306 mysql --name mysqld
docker run -d -p $IN_PORT:$EX_PORT  -e DB_USER=root -e DB_PASSWORD=password1! --link mysqld:database sample-akka-service -name $SERVICE_NAME
