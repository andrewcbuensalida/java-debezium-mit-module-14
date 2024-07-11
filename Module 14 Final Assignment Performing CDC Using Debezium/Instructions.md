To complete this assignment, follow these steps:

Open your Docker Desktop and ensure that there are no containers running. Provide a screenshot of your Docker desktop to show that there are no containers running.
From the command prompt, run a Docker command to create a Docker network for your CDC system called CDCFinalAssignment. Provide a screenshot to show that you successfully ran the command to create the CDCFinalAssignment Docker network.

`docker network create CDCFinalAssignment`

Create a folder called Module14FinalAssignment. Open the new folder in VS Code and add the following files to it to create a Docker image for a MySQL Docker container and initialize it:
Dockerfile:

FROM mysql:8.0
 
ENV MYSQL_DATABASE=employeedb \
    MYSQL_ROOT_PASSWORD=MyNewPass
 
ADD employee.sql /docker-entrypoint-initdb.d
 
EXPOSE 3306

employee.sql file:

CREATE DATABASE IF NOT EXISTS employeedb;
 
USE employeedb;
 
DROP TABLE IF EXISTS `employee`;
 
CREATE TABLE `employee` (
   `id` int not null,
   `FirstName` varchar(255) default null,
   `LastName` varchar(255) default null,
   `MobileNumber` varchar(255) default null,
   `email` varchar(255) default null,
   PRIMARY KEY (`id`)
);
 
INSERT INTO employeedb.employee VALUES (1, "John", "Doe", "1112223333", "john@doe.com");

Provide a screenshot to show that you successfully created the Module14FinalAssignment folder and the two files (Dockerfile and employee.sql) in VS Code.
From the command prompt, navigate to the Module14FinalAssignment folder and run the Docker command to create the MySQL Docker image. Name the image mysqlmasterimg. Provide a screenshot to show that you successfully ran the Docker command to create the MySQL Docker image mysqlmasterimg.

`docker build -t mysqlmasterimg .`

Create a MySQL Docker container from the Docker image mysqlmasterimg, name it mysqlmasterdb, and associate it with the CDCFinalAssignment network. Provide a screenshot to show that you successfully ran the command to create the mysqlmasterdb MySQL Docker container.

`docker run --rm --name mysqlmasterdb -p 3307:3306 --network CDCFinalAssignment -d mysqlmasterimg`

Provide a screenshot of your Docker Desktop to show the MySQL Docker container named mysqlmasterdb running.
Download code and unzip it from the Debezium folder. Provide a screenshot of the unzipped content from the Debezium folder.
Navigate to the Debezium folder. Create a Docker image using the Debezium Dockerfile. Provide a screenshot to show that you successfully created the debeziumimg image.

`docker build -t debeziumimg .`

Create a Debezium Docker container for this assignment and associate it to the CDCFinalAssignment network. Provide a screenshot to show that you successfully created the debeziumserver Docker container and associated it to the CDCFinalAssignment network.

`docker run -it --rm --name debeziumserver --network CDCFinalAssignment debeziumimg bash`

Open the Debezium server CLI and run the following commands:

`apt-get update`

`apt-get install nano`

Provide a screenshot of the nano installation on the Debezium server CLI.
Now, on the Debezium server, edit the following file to replace the database name from customerdb to employeedb throughout the file:

`nano /tmp/src/main/java/mit/edu/tv/config/DebeziumConnectorConfig.java`

Provide a screenshot to show that you successfully changed the database name in the DebeziumConnectorConfig.java file.
From the /tmp folder, run the code below to allow Debezium to start monitoring changes to the MySQL database:

`mvn spring-boot:run`

Provide a screenshot to show that your application ran correctly. In your Terminal window, you should see FirstName=John as the first entry.

This errors with:
`Unable to initialize and start connector's task class 'io.debezium.connector.mysql.MySqlConnectorTask' with config:... `

Now, to test the CDC, open the mysqlmasterdb CLI and connect to the database using the following command:
mysql -h localhost -u root -pMyNewPass employeedb

Provide a screenshot to show that you successfully started the MySQL connection.
From the Terminal window, perform the following INSERT query:
INSERT INTO employeedb.employee VALUES (2, "Mary", "Doe", "4351234354", "mary@doe.com");

Provide a screenshot of the new INSERT query executed successfully with the First Name Mary.
Provide a screenshot to show that the CDC has been performed correctly. You should now see FirstName=Mary as the first entry.