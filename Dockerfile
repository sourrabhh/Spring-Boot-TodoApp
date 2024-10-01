FROM azul/zulu-openjdk:17

WORKDIR /usr/app

COPY target/spring_boot_todo_app-3.3.3.jar /usr/app/spring_boot_todo_app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "spring_boot_app_todo_app.jar" ]