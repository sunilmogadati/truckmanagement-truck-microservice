FROM openjdk:8
EXPOSE 9000
ADD target/truck-aws.jar truck-aws.jar
ENTRYPOINT ["java","-jar","truck-aws.jar"]