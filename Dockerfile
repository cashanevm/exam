FROM openjdk:16-alpine3.13

WORKDIR /exam

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]

RUN echo "Exam work 23 variant: 21-05-2002"