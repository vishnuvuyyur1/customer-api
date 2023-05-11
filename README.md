# customer-api
  Technology stack
  - Java 17
  - Spring Boot 3+
  - Spring security: Basic Authentication
  - JPA
  - Flyway
  - In Memory DB
  - Maven
  - Environment: Embedded Tomcat container 
  
# API Documentation
  |No| Http | Endpoint | Description
|----|---|---|---|
|1| POST | http://localhost:8080/api/customers| create customer|
|2| GET | http://localhost:8080/api/customers |get all customers|
|3| GET | http://localhost:8080/api/customers/{id} |get customer by identifier| 
|4| GET | http://localhost:8080/api/customers?firstName={value} |get customers by first name|
|5| GET | http://localhost:8080/api/customers?lastName={value} |get customers by last name|
|6| GET | http://localhost:8080/api/customers?firstName={value}&lastName={value} |get customers by both names|
|7| PUT | http://localhost:8080/api/customers/{id}/address |Update customer address|
---
![Capture](https://github.com/vishnuvuyyur1/customer-api/assets/22782834/ae646bb4-c839-4e7b-94f1-b58628ae424c)
## 1. POST http://localhost:8080/api/customers
- Auhentication: Basic 
- username: user 
- password: password  
- Input body
```
{
	"firstName": "hello",
	"lastName": "world",
	"age": 10,
	"address": "address"
}
```
- Response : 201

## 2. GET http://localhost:8080/api/customers
- Auhentication: Basic 
- username: user 
- password: password  
- Input body: None
- Response
```
[
    {
        "id": 1,
        "firstName": "hello",
        "lastName": "world",
        "age": 10,
        "address": "address"
    },
    {
        "id": 2,
        "firstName": "hello2",
        "lastName": "world2",
        "age": 9,
        "address": "address2"
    }
]
```
## 3. GET http://localhost:8080/api/customers/1
- Auhentication: Basic 
- username: user 
- password: password  
- Input body: None
- Response
```
{
	"firstName": "hello",
	"lastName": "world",
	"age": 10,
	"address": "address"
}
```
## 4. GET http://localhost:8080/api/customers?firstName=hello
- Auhentication: Basic 
- username: user 
- password: password  
- Input body: None
- Response
```
[
    {
        "id": 1,
        "firstName": "hello",
        "lastName": "world",
        "age": 10,
        "address": "address"
    }
]
```
## 5. GET http://localhost:8080/api/customers?lastName=world
- Auhentication: Basic 
- username: user 
- password: password  
- Input body: None
- Response
```
[
    {
        "id": 1,
        "firstName": "hello",
        "lastName": "world",
        "age": 10,
        "address": "address"
    }
]
```
## 6. GET http://localhost:8080/api/customers?firstName=hello&lastName=world
- Auhentication: Basic 
- username: user 
- password: password  
- Input body: None
- Response
```
[
    {
        "id": 1,
        "firstName": "hello",
        "lastName": "world",
        "age": 10,
        "address": "address"
    }
]
```
## 7. PUT  http://localhost:8080/api/customers/1/address
- Auhentication: Basic 
- username: user 
- password: password  
- Input body
```
new address
``` 
- Response
```
    {
        "id": 1,
        "firstName": "hello",
        "lastName": "world",
        "age": 10,
        "address": "new address"
    }
```
# Additional info
 Health check: http://localhost:8080/actuator/health <br>
 Metrics: http://localhost:8080/actuator/metrics/http.server.requests <br>
 sonar report: https://sonarcloud.io/project/overview?id=vishnuvuyyur1_customer-api
