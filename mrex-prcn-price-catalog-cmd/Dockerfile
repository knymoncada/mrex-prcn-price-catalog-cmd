FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=/build/libs/mrex-prcn-price-catalog-cmd-0.0.1.jar
COPY ${JAR_FILE} mrex-prcn-price-catalog-cmd-0.0.1.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mrex-prcn-price-catalog-cmd-0.0.1.jar"]