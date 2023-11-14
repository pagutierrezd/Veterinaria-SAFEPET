FROM openjdk:17
LABEL maintainer="Paula"
COPY target/ClinicaVeterinaria-0.0.1-SNAPSHOT.jar clinicaVeterinaria-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/clinicaVeterinaria-app.jar"]