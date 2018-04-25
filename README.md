# dvla-proj
Project name:
dvla-proj


##Project Description:

Part 1:
Write a Service layer bean to do the following:
1. Scan configured directory in file system which will return this information -- &gt;
filename, file mime type, file size, file extension
2. Use a directory containing a reasonably large number of files, minimum 10.
3. Provide a way to retrieve certain supported mime type files: configure excel and csv
are supported currently

Part 2:
Write a selenium/cucumber framework to do the following:
1. Use the above service layer bean to get supported files (excel or csv are
supported, from input directory)
2. Go through the file and read vehicle registration details in the file.
3. Open webpage : https://www.gov.uk/get-vehicle- information-from- dvla and go
through all vehicles from excel/csv file.
4. On the Vehicle details page assert the details (Make/Color) match with expected
output in excel/csv file.

##Project Approach:

1.	Java 8 is used to create the service layered application to scan the directory for files. Features such as Lambdas and steams are used for development.
2.	Page object pattern is used for selenium web driver tests for testing the DVLA vehicle information journey.
3.	Maven is used as build tool and Cucumber-JVM is used as the BDD tool to write the test scenarios in form of feature files in Gherkin language.


##Installation:

1)This project requires maven and java installed on the machine. 
2)Maven downloads all the required dependencies once the project is downloaded on to the machine.
3)In the IDE, the project needs to be imported as a maven project.
4)Java 1.8 minimum version is required as lambdas and streams are used in the project. 
