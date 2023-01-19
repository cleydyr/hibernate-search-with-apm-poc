# hibernate-search-with-apm-poc
Proof of concept Spring Boot application that uses Hibernate Search version 5.11.1 to index documents to an Elasticsearch 5.x backend

## Requirements
* JDK 11
* Maven

## Configuration
Before running, add the [minimal configuration](https://www.elastic.co/guide/en/apm/agent/java/1.x/configuration.html#configuration-minimal) properties (and a secret token if needed) to the elasticapm.properties located at src/main/resources:

```properties
service_name=${APM_SERVICE_NAME}
server_url=${APM_SERVER_URL}
secret_token=${APM_SECRET_TOKEN}
```

Also, change the application.properties file, replacingn the placeholder values by the actual values of user name, password and host name of your Elasticsearch instance.

## Running

Run `mvn spring-boot:run` from the command line.

After the server is up, it will listen for HTTP POST requests in the deafult port (8080) and the /indexSomething path. So, for example, using `curl`, you can make a request like this

```bash
curl -XPOST http://localhost:8080/indexSomething
```

It's expected that a book with title "De Brevitate Vitae", pageCount = 200 and a random uuid as ISBN will be indexed in your Elasticsearch instance in the `books` index. There's no need to create the index as the application itself will create it on startup. The same book data will be added to the H2 memory database (whose data is deleted when the server is shut down).
