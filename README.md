# match-assignment
Match.com Registration and Search Test Automation using JAVA, Selenium, TestNg, maven

Pre-requisities: Eclipse IDE, Chrome and Firefox browser 

Steps to install and run:
  1. Open eclipse
  2. Import project as existing maven project
  3. Open testng.xml 
  4. Right click choose run as TestNg Suite

Scenario automated:
  1. Register a new user on match.com 
  2. Navigate to the home page (www.match.com/home) 
  3. Verify that the user is signed-in
  4. Go to the search page
  5. Verify that there are search results available
  6. From the search results page, block a user
  7. Refresh the page and verify that the user is no longer on the search page
  8. From the search page, attempt to hide a user from search results
  9. Verify that the user is taken to the subscription page

Project structure
master
 - src/test/java
    - helper
        - DriverFactory.java #driver initialization class
    - pageObjects
        - Home.java # home page page objects
        - Registration.java # registration page page objects
    - testcases
 - JRE system library
 - Maven dependencies
 - TestNg
 - src
 - target
 - test-output
 - pom.xml
 - testng.xml
