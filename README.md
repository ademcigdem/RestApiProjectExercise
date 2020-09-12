#  REST API PROJECT EXERCISE

##### TOOLS AND EXPLANATIONS
>- The project has been prepared based on Cucumber BDD style.    
>- Maven build management tool is used in this project by Java language.
>- LOG4J and SL4J information is provided as a logging design.
>- In the project that includes two scenarios, the first scenario verifies by receiving information from the live API server(https://petstore.swagger.io), 
>while the second scenario verifies by receiving information over the prepared Wire Mock Server.
>- For the test, a study has been done in the `v2 / pet / findByStatus` end point.
>- A special tag(`@wire_mock`,`@live`) was used in the project. Thus, the desired feature can be run in Runner.

##### HOW TO RUN TESTS
```sh
 -> Under the runner package "Runner" right click and run Runner. "src > test > java > runner > Runner"
 -> mvn test --> in the IDE console or navigate project path in command line and run.
```
##### HOW TO CREATE TEST REPORTS

1-) When you run tests with the **"mvn verify"** command from the console, you can see **Cucumber Html Report** under the target file.       
**-> target -> cucumber-html-reports > overview-steps.html** (open with chrome option)

2-) Second type of report, the project is run from **Runner** class, a **Cucumber Report link** is created in the IDE console automatically.       
 Sample link -> View your Cucumber Report at:   (Works 24 hours later than it will delete automatically)                                         
                 https://reports.cucumber.io/reports/d075d19d-4ccb-4e11-8da8-85e2220de650             
 Sample Screenshot -> **SampleCucumberReportScreeShot.png**

3-) The log documents are located at the project level under the **execution_log.txt** file.
 
 

**Adam Cigdem**    
QA Automation Engineer | SDET     
https://www.linkedin.com/in/adam-cigdem-2932931b4/