FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace
WORKDIR /usr/share/project

# ADD .jar under the target from host
# into this image

ADD target/AmazonSelenium.jar        AmazonSelenium.jar
ADD target/AmazonSelenium-tests.jar  AmazonSelenium-tests.jar
ADD target/libs                      libs

#ADD test data

# ADD suite files
ADD testngParallel.xml                    testngParallel.xml
ADD healthcheck.sh                        healthcheck.sh
#ADD health check script

# BROWSER
# HUB HOST
# MODULE

ENTRYPOINT sh healthcheck.sh

