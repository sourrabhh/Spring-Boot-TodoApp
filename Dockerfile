FROM openjdk:17

COPY target/spring_boot_app_todo_app.jar /usr/app/spring_boot_app_todo_app.jar

WORKDIR /usr/app

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "spring_boot_app_todo_app.jar" ]