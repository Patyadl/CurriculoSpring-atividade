FROM openjdk:21-jdk
VOLUME /tmp
ADD target/curriculo.jar curriculo.jar
ENTRYPOINT ["java","-jar","/curriculo.jar"]
