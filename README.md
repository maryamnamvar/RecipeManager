# Getting Started

A simple web application to view and manage recipes by different users.

### Technologies Used
* Java 8
* Spring Boot (2.5.5)
* Spring MVC
* Spring Data JPA + Hibernate
* Spring Security
* PostgreSql
* Thymeleaf
* Maven
* Tomcat

### Features
* User login/sign-up
* 2 roles: ADMIN and USER
* USER role can create/read/update/delete Recipes
* ADMIN can have CRUD on Recipes, and users
* ADMIN can block/unblock users


### Installation
First, create a postgreSql database using this command:
`createdb -h localhost -p 5432 -U postgres recipedb`

in `application.properties` file, search for `spring.jpa.hibernate.ddl-auto` and set it to `create-drop` or `update` for initializing application.
For the production environment, this line should be set to `validate`.
Also, the default user/pass of database is test/test which can be changed in `application.properties` file

### Tests
A few unit tests to show you my ability to write spring unit tests

### How to use
After running the application, you can browse `localhost:8080`

The default ADMIN account for initial use and define other recipes and users is:
`user: admin password: 123`

There are several urls to call:

* GET /recipes/
* GET /recipes/add/
* POST /recipes/add/ (with a `Recipe` object)
* GET /recipes/delete/{id}
* GET /recipes/update/{id}
* GET /users
* POST /users/sign-up (with a `UserRepresentation` object)
* GET /users/delete/{id}
* GET /users/block/{id}
* GET /users/unblock/{id}
* GET /users/search/{id}
* GET /users/searchbyemail/{email}

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
