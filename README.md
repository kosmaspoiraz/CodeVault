## Instructions

Before starting, you must install `docker` and `docker-compose` on your system.

Additionally you must have `Java 11` installed on your system, an IDE and `maven`.

### Create a database for application

To create a database so that the application can connect to, you can use the following command:

`$ cd db/ && docker-compose up -d`

A PostgreSQL instance will be created with the following credentials:

```
Username: pook
Password: password
Database: codevault
Url: jdbc:postgresql://localhost:5432/codevault
```

And will be accessible from port `5432`.

You can review the database schema inside the file `db/init.sql

### Build and run the application

`$ mvn clean install -DskipTests && mvn spring-boot:run`

### Future goals
- User Register & Login API
- Security enhancement, data encryption
- Frontend
- Ultimate goal: Android implementation
