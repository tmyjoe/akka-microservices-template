FROM java:8
MAINTAINER tmyjoe

ARG JAR
ARG PORT

ADD ${JAR} app.jar

EXPOSE ${PORT}

ENTRYPOINT java -jar app.jar

# docker build -t ${NAME} --build-arg JAR=PATH_TO_A_JAR --build-arg PORT=9000 .
