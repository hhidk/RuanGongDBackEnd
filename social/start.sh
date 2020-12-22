#!/bin/bash

git pull
./gradlew bootJar
java -jar build/libs/social-0.0.1-SNAPSHOT.jar
