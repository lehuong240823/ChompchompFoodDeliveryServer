FROM azul/zulu-openjdk:17-latest
VOLUME /tmp
COPY ./build/libs/ChompchompFoodDeliveryServer-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar","/app.jar"]
