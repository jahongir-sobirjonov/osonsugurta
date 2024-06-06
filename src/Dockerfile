FROM gradle:7.2.0-jdk17 AS build
COPY . .
RUN gdl clean packace -DskipTests

FROM openjdk:17.0.2-jdk-slim
COPY --from=build /target/osonsugurta-0.0.1-SNAPSHOT.jar osonsugurta.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","osonsugurta.jar"]