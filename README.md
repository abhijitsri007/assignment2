# Assignment-backend-api

Read assignment instructions provided in pdf file for Assignment.

Maven:
  1. Clean: mvn clean package
  2. Build: mvn clean build

Docker:
  docker build --tag=assignment2:latest .
  docker run -p8080:8080 assignment:latest
Docker-Compose:
  docker-compose up --build

Swagger: http://localhost:8080/swagger-ui.html

Postman Collection attached in resource folder

Mapping: MapStruct 
Contract(DAO/RequestMapping): OpenAPI/Swagger: questionnaire.yaml
Random Number: RandomNumberGenerator used

Business Logic: 
1. So as to Safeguard against cheating response object Base64 encode/decode used
2. Same has been attached in here

{
  "code": "Y2xhc3MgUUFSZXNwb25zZSB7CiAgICBjb2RlOiBudWxsCiAgICBxdWVzdGlvbjogUGxlYXNlIHN1bSB0aGUgbnVtYmVycyA6IAogICAgaXRlbXM6IFsyLCA2LCAyXQogICAgYW5zd2VyOiBudWxsCn0=",
  "question": "Please sum the numbers : ",
  "items": [
    2,
    6,
    2
  ],
  "answer": 1
}

