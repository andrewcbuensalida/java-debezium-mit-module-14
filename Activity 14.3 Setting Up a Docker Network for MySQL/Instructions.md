To complete this activity, follow these steps: 

To create the network for this module, run the following Docker command from the PowerShell. Provide a screenshot to show that you successfully ran the command.

`docker network create myCDCNetwork`

Create a folder called Activity14_3. Open VS Code, and then open the new Activity14_3 folder. Provide a screenshot to show that you successfully opened the folder in VS Code.

Add a new file called customer.sql and paste the following code:

CREATE DATABASE IF NOT EXISTS customerdb;

USE customerdb;

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
   `id` int not null,
   `fullname` varchar(255) default null,
   `email` varchar(255) default null,
   PRIMARY KEY (`id`)
);

INSERT INTO customerdb.customer VALUES (1, 'John Doe', 'jd@example.com');

Provide a screenshot to show that you successfully added the file.

Add a new file called Dockerfile and paste the code below into it:

FROM mysql:8.0

ENV MYSQL_DATABASE=customerdb \
    MYSQL_ROOT_PASSWORD=MyNewPass

ADD customer.sql /docker-entrypoint-initdb.d

EXPOSE 3306

Provide a screenshot to show that you successfully added the file.

Make sure that you don’t have any containers running in Docker. Provide a screenshot to show that there are no Docker containers running.

Create a MySQL Docker image and instruct Docker to run the customer.sql file to initialize the database. Open a PowerShell, navigate to the Activity14_3 folder, and run the following command to create a MySQL Docker image:

`docker build -t mysqlactivity14_3 .`

Provide a screenshot to show that you successfully executed the command.

Create a MySQL Docker container and associate it to the myCDCNetwork. Run the following command from a PowerShell in the Activity14_3 folder:

`docker run --rm --name mysqlserver -p 3307:3306 --network myCDCNetwork -d mysqlactivity14_3`

Provide a screenshot to show that you successfully executed the command.

Provide a screenshot of your Docker Desktop showing the mysqlserver container running.