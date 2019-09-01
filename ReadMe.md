# Spring Boot AngularJS, MongoDB, Rest CRUD Example

This sample project shows how to prepare an application using Spring Boot, AngularJS, MongoDB and Rest API

## Installation

Use the github connection [link](https://github.com/bayrambulut/springbootrestunit.git) to install application.

```git
git clone --bare https://github.com/bayrambulut/springbootrestunit.git
```

## Usage

Create table below

```sql
create table book (
	id serial,
	name varchar(50),
	author varchar(50)
)
```

Change the lines below

```java
## PostgreSQL
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```

## Cloud link
You can access application using link below

[https://springbootrestunit.herokuapp.com/books](https://springbootrestunit.herokuapp.com/books).



## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.


