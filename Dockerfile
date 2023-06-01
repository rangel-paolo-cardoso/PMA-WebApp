FROM ubuntu:latest

LABEL maintainer="Rangel Cardoso paolorangel1996@outlook.com"

RUN apt-get update && apt-get install -y openjdk-17-jdk

WORKDIR /usr/local/bin/

ADD ./target/pma-app.jar .

ENV version=docker

ENTRYPOINT ["java", "-jar", "pma-app.jar"]