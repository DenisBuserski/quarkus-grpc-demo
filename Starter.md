# How to run the application

Before starting the application, go to the folder `docker/docker-compose.yaml` and run:
```
docker compose up -d
```
Create the database schema:
```postgresql
CREATE DATABASE quarkus_db
```
Start the application:
```
./mvnw quarkus:dev
```
