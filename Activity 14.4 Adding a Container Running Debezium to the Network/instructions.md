To complete this activity, follow these steps:

Provide a screenshot of your Docker desktop to show that the MySQL Docker container that you created for Activity 14.3 is still running.

You will be using the Docker network that you created in Activity 14.3. Run the following Docker command to show the Docker network:

`docker network ls`

Provide a screenshot of the output from this command to show that the myCDCNetwork Docker network is available.

Unzip the contents from the zip file debeziumActivity14_4.zip to a folder called debeziumActivity14_4. Provide a screenshot to show that you successfully unzipped the debeziumActivity14_4.zip file and created the debeziumActivity14_4 folder.

From the command shell prompt, navigate to the debeziumActivity14_4 folder, and run the command below to create a Debezium Docker image. Provide a screenshot to show that you successfully ran the command:

`docker build -t debeziumactivity14_4 .`

From the command shell prompt, run the following command to create a Debezium container. Provide a screenshot to show that you successfully ran the command:

`docker run -it --rm --name debeziumserver --network myCDCNetwork debeziumactivity14_4 bash`

Provide a screenshot of the Docker desktop to show the two containers running.

From the command prompt, run the following command to start the Spring Boot application that uses Debezium to monitor the MySQL database:

`mvn spring-boot:run`

Provide a screenshot of the console application running to show that Debezium detected the new row that was created for the customer table.

Open MySQL Workbench and connect to the customerdb file that is running inside the Docker container. Run the following INSERT query to insert a new row in the customer table:

INSERT INTO customerdb.customer VALUES (2, "Peter Parker", "pp@example.com");

Provide a screenshot to show that you successfully executed the INSERT query from Workbench.

Provide a screenshot of the console application running Debezium to show that Debezium detected the new row that was created in the customer table from Workbench.