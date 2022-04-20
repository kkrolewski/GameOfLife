#!/bin/sh
mvn clean package && docker build -t pl.polsl.lab.kkrolewski/GameOfLife .
docker rm -f GameOfLife || true && docker run -d -p 9080:9080 -p 9443:9443 --name GameOfLife pl.polsl.lab.kkrolewski/GameOfLife