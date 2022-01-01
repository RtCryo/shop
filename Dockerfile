FROM openjdk:11
WORKDIR /usr/local/app
ADD target/shop-0.0.1-SNAPSHOT.jar /usr/local/app/app.jar
ENTRYPOINT ["java", "-jar","app.jar"]
EXPOSE 8080