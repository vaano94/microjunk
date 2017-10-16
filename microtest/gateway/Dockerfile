FROM java:8-jre
MAINTAINER Kravchenko Ivan

ADD ./target/gateway.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/gateway.jar"]

EXPOSE 10000