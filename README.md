# CivicsQuiz
Rest API containing Civics (History and Government) Questions for the Naturalization Test

## To start the application<br/>
* ### start up MySQL database and log in as civicsQuiz user
    * ```mysql -u civicsQuiz -p```
  * prompted for a password type <br/>
    * ```usa```
  * ```CREATE DATABASE quiz_app```
* ### start project itself 
  * open new terminal (command n) 
  * navigate to project directory containing pom.xml
    * ```mvn spring-boot:run```
  * to open in inteliJ
    * ```idea pom.xml```  
  * to run test
  * ```mvn tests```


