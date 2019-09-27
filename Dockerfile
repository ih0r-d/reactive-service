FROM adoptopenjdk/maven-openjdk11 AS build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:go-offline -B
COPY src /app/src
RUN mvn clean install

FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /app
COPY --from=build /app/target/reactive_demo-0.0.1-SNAPSHOT.jar /app
RUN chmod +x reactive_demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD java -jar reactive_demo-0.0.1-SNAPSHOT.jar
