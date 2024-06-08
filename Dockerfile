FROM amazoncorretto:21 AS build

RUN yum install -y tar which gzip \
  && curl -fsSL https://downloads.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.tar.gz \
  | tar -xzC /usr/share/maven --strip-components=1 \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn


WORKDIR /app

COPY curriculo/pom.xml .
COPY curriculo/src ./src


RUN mvn clean package -DskipTests

FROM amazoncorretto:21

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENV PORT 8080

EXPOSE 8080

CMD ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]
