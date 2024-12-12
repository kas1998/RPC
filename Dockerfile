FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/rpc_project.jar /app/rpc_project.jar

EXPOSE 50051

CMD ["java", "-jar", "rpc_project.jar"]
