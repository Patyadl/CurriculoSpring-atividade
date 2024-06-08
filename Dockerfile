FROM maven:3.8.5-openjdk-21-slim AS build

WORKDIR /curriculo

COPY curriculo/pom.xml .
COPY curriculo/src ./src

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

WORKDIR /curriculo

COPY --from=build /curriculo/target/*.jar curriculo.jar

ENV PORT 8080

EXPOSE 8080

CMD ["java", "-Dserver.port=${PORT}", "-jar", "curriculo.jar"]
