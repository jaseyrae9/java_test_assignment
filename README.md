# Alas d.o.o. Java developer test assignment

## How to run the application

1. Install Java 8: Go to https://adoptopenjdk.net/ and download version 8. If the Operating System is Windows: set the system environments for `JAVA_HOME` (jdk root folder) and `PATH` (jdk root folder\bin)
2. 	- Create PostgreSQL database with name ```alas```
	- Replace the current contents of the application-dev.properties file

	  ```
	  spring.datasource.username = username
	  spring.datasource.password = password
	  ```

3. To build the backend run `mvn -DskipTests clean package -P dev` 
4. To start the backend run `mvn spring-boot:run` command (control + c will kill the application)
5. Build the frontend: `cd core/src/frontend`, `yarn`. (install `yarn` and `node` if needed)
6. To start the frontend go to `cd core/src/frontend` and run `yarn start`. It will run on `localhost:3000`.

## How to run tests
1. Install web drivers for firefox, chrome and edge: Go to https://www.selenium.dev/downloads/
2. In BrowserFactory class set system property `System.setProperty("driver name", "path of the driver exe")`
1. To switch to test enviroment and build the backend run `mvn -DskipTests clean package -P test`
2. To start the backend run `mvn spring-boot:run -P test` command (control + c will kill the application)
3. To start tests open new terminal and run `mvn test` (default browser is firefox and other supported browsers are chrome and edge)
4. If you want to change default browser run tests with `mvn -Dbrowser=browserName test`


