FROM gradle:7.2.0-jdk17 AS build
COPY src .
RUN gradle clean build -x test

FROM openjdk:17.0.2-jdk-slim
COPY --from=build /build/libs/osonsugurta-0.0.1-SNAPSHOT.jar osonsugurta.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","osonsugurta.jar"]
