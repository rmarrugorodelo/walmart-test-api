FROM openjdk:8
VOLUME /tmp
EXPOSE 8888
ADD ./build/libs/walmart-test-api-0.0.1-SNAPSHOT.jar walmart-test-api.jar
ENTRYPOINT ["java", "-jar", "/walmart-test-api.jar"]