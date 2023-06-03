FROM ubuntu:latest

LABEL maintainer="Rangel Cardoso paolorangel1996@outlook.com"

RUN apt-get update && apt-get install -y openjdk-17-jdk

WORKDIR /usr/local/bin/

ADD ./target/pma-app.jar .

ENV version=aws-db-usage
ENV dbuser=${dbuser}
ENV dbpass=${dbpass}
ENV jdbcurl=${jdbcurl}

ENTRYPOINT ["java", "-jar", "pma-app.jar"]