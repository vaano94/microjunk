FROM java:8-jre
MAINTAINER Kravchenko Ivan

ADD ./target/payment-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/payment-service.jar"]

EXPOSE 6000