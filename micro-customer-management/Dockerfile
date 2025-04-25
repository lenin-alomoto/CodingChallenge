# Use a base image with Java 17
FROM eclipse-temurin:17-jdk-noble AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the application code
COPY . .

#Build the application
RUN ./mvnw clean package -DskipTests

# Satge2: Run the application
FROM eclipse-temurin:17-jre-noble

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java","-jar","app.jar"]