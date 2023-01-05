FROM openjdk:8
ADD /target/springboot-demo-0.1.jar cricketapp.jar
EXPOSE 8082
ENTRYPOINT [ "java","-jar","cricketapp.jar" ]