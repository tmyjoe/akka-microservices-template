SERVICE_NAME=akka-sample-service-container

docker rm -f SERVICE_NAME
docker rm -f mysqld

EX_PORT=9000
IN_PORT=9000

docker run -p 3306:3306 -d --name mysqld -e MYSQL_CHARSET=utf8 -e MYSQL_ROOT_PASSWORD=password1! mysql:latest
docker run -d -p $IN_PORT:$EX_PORT  -e DB_USER=root -e DB_PASSWORD=password1! --link mysqld:database akka-sample-service:1.0 -name $SERVICE_NAME
