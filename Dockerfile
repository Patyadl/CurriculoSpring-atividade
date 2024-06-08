FROM openjdk:21-jdk
VOLUME /tmp
ADD target/meuapp.jar meuapp.jar
ENTRYPOINT ["java","-jar","/meuapp.jar"]
