FROM openjdk:17-oracle
COPY ./target/security-service.jar security-service.jar
CMD ["java","-jar","security-service.jar"]