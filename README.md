This Microservice use HttpExchange and Zipkin server.



sample objects

Employee:

  Post: localhost:8080/employee/save
  {
  "eId": 33,
  "dId": 1,
  "eName": "aaaa",
  "eAge": 18,
  "ePosition": "Head"
  }
  Get: localhost:8080/employee/all

Departments:
  Post: localhost:8081/department/save
  {
    "did":2,
    "dname": "IT"
 }
  Get:
  localhost:8081/department/all
  localhost:8081/department/with-employees
  
