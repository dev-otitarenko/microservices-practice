#!/usr/bin/env bash

# remove all old unused images
docker rmi $(docker images -a -q)

mvn clean package -Dmaven.test.skip=true

# run services
docker-compose -f docker-compose-dev.yml -p ms-practice stop
docker-compose -f docker-compose-dev.yml -p ms-practice rm
docker-compose -f docker-compose-dev.yml -p ms-practice up -d --build