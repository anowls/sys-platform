FROM nibo/oracle-jdk:jdk-8u112
MAINTAINER Richard <nibocn@gmail.com>

WORKDIR /opt

RUN mkdir /opt/app

EXPOSE 8080

ENV RESERVED_MEGABYTES 64
COPY cloud-operation-platform.jar /opt/app
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

CMD ["/entrypoint.sh"]

HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:8080/platform/health || exit 1