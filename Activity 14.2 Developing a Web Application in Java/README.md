To complete this activity, follow these steps:

Create a Java Docker container named javamaven using the following command. This container will host web applications on port 8080:

docker run --name javamaven -dti --rm -p 8080:8080 maven:3.8.1-openjdk-17-slim bash

Provide a screenshot to show that the Java Docker container named javamaven has been created on port 8080.

Open the javamaven container CLI and execute the following command to install the latest container updates:
apt-get update
apt-get install nano

Provide a screenshot to show that the javamaven container CLI has been updated.

Go to the following link: Spring Initializr Links to an external site.. Once opened, keep the default settings (i.e., Maven Project, Language Java, and Spring Boot Version 2.5.7) and, from the dependencies section, add Spring Web to create a web server. This will add dependent Spring web-specific libraries. Once complete, select “Generate” to download the demo.zip file to your local machine.

Provide a screenshot to show the Spring Initializr webpage with the correct settings selected.

Unzip the demo.zip folder and confirm that files exist under the demo folder. Provide a screenshot of the unzipped demo.zip folder.

Open your local machine command prompt and navigate to the parents folder containing the folder you just unzipped. Provide a screenshot of your Terminal window showing that you have navigated to the correct folder.

Run docker cp command to upload files into the javamaven container home folder using the following command:

docker cp demo/. javamaven:home/

Provide a screenshot to show that you ran the docker cp command to upload files into the javamaven container home folder.

Return to the javamaven container CLI and change the folder to home to validate that the files from your local machine demo folder uploaded successfully.

cd home
ls

Provide a screenshot to show that the files from your local machine demo folder successfully uploaded to the javamaven container.

To update the web application code, navigate to the following folder in the container command line interface.

cd src/main/java/com/example/demo

Here, you will find the DemoApplication.java file.

Provide a screenshot to show the DemoApplication.java file.

Using the nano text editor, open the DemoApplication.java file to make a code update. Replace the code in the file with the following code:

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) 
    {
    SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue="World") String name)
    {
        return String. format("Hello %s!", name);
    }
}

Confirm that the code update was successful using the following command:

cat DemoApplication.java

Provide a screenshot to show that the code in the DemoApplication.java file was updated successfully.

Change your folder to home, and then execute the following commands to run the Java web application:

cd /home
mvn spring-boot:run

Provide a screenshot to show the Java web application that you have created running.

In your browser, navigate to localhost:8080/hello to confirm that the web application is working successfully. In another browser window, navigate to localhost:8080/hello?name=John to confirm that your application is running when you pass a parameter to the URL.

Provide two screenshots. One screenshot should show that you were successfully able to navigate to localhost:8080/hello. The second screenshot should show that you were successfully able to navigate to localhost:8080/hello?name=John.

Now that you have executed all of the steps, you have successfully created a simple Java Spring Boot web application.