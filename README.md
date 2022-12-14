# Service Motor API

### Description
Make Simple Service Motor API

### Technology
- Framework : Spring Boot 2.7.2 
- Programming Language : Java 18
- Packaging : jar
- Dependencies : 
    - Spring Boot Dev Tools
    - Lombok
    - Spring Web
    - Sping Data JPA
    - MySQL Driver 


### DDL Script

Link -> *[query Create Database](https://github.com/Yakagi17/service-motor-api/blob/main/database/service-motor-api-ddl.sql)

###  Request
A. Path (/api/service)

1. Method : POST
Operation : Create order(Service Motor)

2. Method : GET
Operation : Get all order(Service Motor)


B. Path (/api/service/{id}/update-status)

3. Method : GET
Operation : Update Status order from spesific id Order(Service Motor)





### Result Testing on Postman

#### 1. (/api/service) -> Method POST
**200 OK (Respone Code)**
- Description : Succesful to create new order (Service Motor) to database
<img src="https://github.com/Yakagi17/service-motor-api/blob/main/API%20Result/create%20200.JPG"></img>

**400 Bad Request (Respone Code)**
- Description : Failed to create new order (Service Motor) to database
- Caused : Theres no type "PERIODICss SERVICE" sevice on database
<img src="https://github.com/Yakagi17/service-motor-api/blob/main/API%20Result/create%20400.JPG"></img>


#### 2. (/api/service) -> Method GET
**200 OK (Respone Code)**
- Description : Succesful to get all order(Service Motor)  by Status parameter from database
<img src="https://github.com/Yakagi17/service-motor-api/blob/main/API%20Result/getAllByStatus%20200.JPG"></img>

**204 NO_CONTENT  (Respone Code)**
- Description : Failed to get all order(Service Motor)  by Status parameter from database
- Caused : there no record order(Service Motor) that has "DONE" status on database
<img src="https://github.com/Yakagi17/service-motor-api/blob/main/API%20Result/getAllByStatus%20204.JPG"></img>

**400 Bad Request (Respone Code)**
- Description : Failed to get all order(Service Motor)  by Status parameter from database
- Caused : Theres no type "WAITNG"  sevice on database
<img src="https://github.com/Yakagi17/service-motor-api/blob/main/API%20Result/getAllByStatus%20400.JPG"></img>


#### 3. (/api/service/{id}/update-status) -> Method PUT
**200 OK (Respone Code)**
- Description : Succesful to update order(Service Motor)  by Status parameter from database
<img src="https://github.com/Yakagi17/service-motor-api/blob/main/API%20Result/updateStatus%20200.JPG"></img>

**400 Bad Request (Respone Code)**
- Description : Failed to get all order(Service Motor)  by Status parameter from database
- Caused : Theres no type "PROCESSING1"  sevice on database
<img src="https://github.com/Yakagi17/service-motor-api/blob/main/API%20Result/updateStatus%20400.JPG"></img>

* **404 NO_CONTENT  (Respone Code)**
- Description : Failed to get all order(Service Motor)  by Status parameter from database
- Caused : there no record order(Service Motor) that has id 2 on database
<img src="https://github.com/Yakagi17/service-motor-api/blob/main/API%20Result/updateStatus%20404.JPG"></img>
