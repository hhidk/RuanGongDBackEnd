#!/bin/sh

git pull
./gradlew bootJar
cp build/libs/social-0.0.1-SNAPSHOT.jar ~/social/
cd ~/social/
nohup java -jar social-0.0.1-SNAPSHOT.jar &
