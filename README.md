# Spring Boot Multiple DBs
 Spring Boot Application to demonstrate the implementation of more than one database within single application with Spring Data JPA.
 
# Setup Environment
Setup MySQL on port 3306 (default one or override **application.properties** file according to project requirement).<br/>(If changing **application.properties**, don't forget to change related config files)

# Project Structure
- **c.a.m.config** package contains Java based configuration for all databases (DataSource, EntityManager, TransactionManager).
- **c.a.m.dbone** and **c.a.m.dbtwo** packages contains the repositories and entities for databases. 

# API Testing
- Run Spring Boot Application on port 8080....
- Import **SpringBootMultipleDb.postman_collection.json** into Postman (basic CR<strike>U</strike>D examples added in collection!!)

###### Cheers 🥂😀
