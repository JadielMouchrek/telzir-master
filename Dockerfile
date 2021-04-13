FROM openjdk:8

ADD target/telzir_teste.jar telzir_teste.jar

ENTRYPOINT ["java", "-jar", "telzir_teste.jar"]

EXPOSE 8080