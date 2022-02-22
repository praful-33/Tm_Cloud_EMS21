FROM openjdk:16-alpine
ADD target/TM_Competo.jar TM_Competo.jar
EXPOSE 8080
CMD ["java", "-jar", "TM_Competo.jar"]