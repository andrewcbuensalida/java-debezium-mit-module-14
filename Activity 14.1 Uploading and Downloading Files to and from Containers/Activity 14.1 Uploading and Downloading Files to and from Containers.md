To complete this activity, follow these steps:

Create a Docker container named ubuntu_container on your machine using the following command:

docker run --name ubuntu_container -dti ubuntu /bin/bash

Docker run command to create Docker container.

Provide a screenshot to show that you successfully created the Docker container named ubuntu_container.

Open your Docker Desktop and find the newly created Docker container, ubuntu_container. Select “CLI” to open the container command line interface. Provide a screenshot to show the ubuntu_container command line interface.

CLI Docker container.

In the ubuntu_container command line interface, change the folder to home and create a folder called container_activity_14.1 with a file in it titled container1.txt. Provide a screenshot to show that the container_activity_14.1 folder has been created with the container1.txt file in it.

Change your folder to the container_activity_14.1 folder and create a sample file under the container_activity_14.1 folder called container1.txt using the echo command. Add the “Hello World” content below to the text file by using the following command:

echo "Hello World" > container_activity_14.1/container1.txt

Provide a screenshot to show that the container_activity_14.1 folder has been created and that it contains the container1.txt file with the “Hello World” content added to it.

Open your local machine command prompt. Create a folder called local_activity_14.1 and navigate to the folder where you will download the container_activity_14.1 folder.

Provide two screenshots. Provide one screenshot to show that you created the local_activity_14.1 folder. Provide a second screenshot of your command line interface to show that you successfully changed your folder to the local_activity_14.1 folder.

Perform a docker copy command from your local machine command prompt to get the container_activity_14.1 folder from the container to your local machine folder, local_activity_14.1. Provide a screenshot to show that the docker cp command was executed successfully and there were no errors after copying the container_activity_14.1 folder.

  docker cp ubuntu_container:home/container_activity_14.1 .

Validate the local machine local_activity_14.1 folder to determine whether it copied the container_activity_14.1 and its files correctly. Provide a screenshot of the folder to show that you successfully copied the container_activity_14.1 and its files folder to the local_activity_14.1 work folder.