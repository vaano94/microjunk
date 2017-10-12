FROM java:8-jre
MAINTAINER Kravchenko Ivan

ADD ./target/notification-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/notification-service.jar"]

EXPOSE 6000