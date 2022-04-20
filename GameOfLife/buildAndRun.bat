@echo off
call mvn clean package
call docker build -t pl.polsl.lab.kkrolewski/GameOfLife .
call docker rm -f GameOfLife
call docker run -d -p 9080:9080 -p 9443:9443 --name GameOfLife pl.polsl.lab.kkrolewski/GameOfLife