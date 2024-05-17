#!/bin/sh

mvn clean package

az acr login -n acrcaptesteus2poc
docker build --platform=linux/amd64  -f DockerFile -t javamidtest:$1 . 
docker tag javamidtest:$1 acrcaptesteus2poc.azurecr.io/javamidtest:$1
docker push acrcaptesteus2poc.azurecr.io/javamidtest:$1

kubectl get pods -n ns-java-mid-test
