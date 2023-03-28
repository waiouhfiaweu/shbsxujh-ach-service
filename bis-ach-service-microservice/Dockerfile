FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
EXPOSE 8079
ARG JAR_FILE=target/app.jar
ENV PROFILE onpremise
COPY ${JAR_FILE} app.jar
COPY ./entrypoint.sh /
RUN apk --no-cache --upgrade add curl && chmod +x /entrypoint.sh
HEALTHCHECK --interval=10s --timeout=3s --retries=3 \
  CMD curl -f http://localhost:8079/cobis/ach/actuator/health/ || exit 1
ENTRYPOINT ["sh", "/entrypoint.sh"]
