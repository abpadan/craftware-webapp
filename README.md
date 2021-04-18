# craftware-webapp

This application provides most of the features of the Microsoft Access database application used for UNO's MIS capstone. The 'startup.sql' file contains mock data and other statements that can be used to populate the database.

****

**Database Configuration**

This application assumes you have mysql installed on the server or computer running craftware-webapp. The username and password is defined in the application.properties file.

    spring.datasource.url=jdbc:mysql://localhost:3306/craftwarewebapp
    spring.datasource.username=root
    spring.datasource.password=root

**Execute**

    mvn clean package spring-boot:run


