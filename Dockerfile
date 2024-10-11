# First stage: Build the JAR

FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /usr/src/app

COPY . .

RUN mvn clean package -DskipTests 

# Second stage: Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /usr/app

COPY --from=builder /usr/src/app/target/spring_boot_todo_app-3.3.3.jar /usr/app/spring_boot_todo_app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "spring_boot_todo_app.jar" ]