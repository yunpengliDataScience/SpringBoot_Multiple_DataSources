FROM openjdk:17-jdk-alpine
ADD ./target/SpringBoot_Multiple_DataSources-0.0.1-SNAPSHOT.jar SpringBoot_Multiple_DataSources.jar
ENTRYPOINT ["java", "-jar", "SpringBoot_Multiple_DataSources.jar"]