# Sử dụng image base là OpenJDK 8
FROM openjdk:8-jdk-alpine

# Khai báo biến môi trường cho file JAR
ARG FILE_JAR=target/*.jar

# Copy file JAR vào trong container với tên api-service.jar
COPY ${FILE_JAR} api-service.jar

# Khởi chạy ứng dụng
ENTRYPOINT ["java", "-jar", "api-service.jar"]

# Mở cổng 8080 cho ứng dụng
EXPOSE 8080
