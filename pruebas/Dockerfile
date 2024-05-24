FROM openjdk:21-jdk
COPY . /app
WORKDIR /app
RUN ./mvnw package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/pruebas-0.0.1-SNAPSHOT.jar"]