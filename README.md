# Introduction
The following repository is a small starter framework built to test JetBrains IDEs. It uses the intellij-ide-starter as the backbone to downloand, run and interact with intellij IDEs. 
The framework is built to provide the minimum to get tests up and running and serves as a proof-of-concept for further development.

The included test does the following:

1. Downloads an IDE and Github project based on the test data provide (IDE, project, branch, ide version)
2. loads IDE and project
3. opens a .md file
4. sends keyboard input to the editor
5. opens the terminal with hotkey input
6. inputs the command "git --help" into the terminal and "presses" enter
7. opens project wide search with hotkey input
8. searches for the input in step 4 across the project
9. closes the application

## How to run
1. pull repository
2. run the example parametrized test

To modify which IDEs, projects, branches, ide versions that are downloaded, you only have to add an additional line to the @CsvSource of the parameterized test. Please see example test for format. 
The actual test code can be adjusted based on indvidual requirements and test cases. The framework was developed and tested in the latest version (as of 12/2024) of Intellij IDEA community edition. Results may vary with other IDEs.

## Notes

* Context setup has been encapsulated for readabillity purposes and to follow best test automation practices. Further expanding the fluent API language design to also include interactions with the IDE, would improve the framework even more.
* branch data was included to account for different branch naming (master/main)
* version data was included because at the time of development (12/2024) the starter was having issues pulling the latest builds for PyCharm and Intellij IDEA (this is also why PyCharm was substituted for Intellij in the test).
* Kotlin was used because the starter is also written in Kotlin, however I am not familiar with Kotlin's modern best practices.
* The framework currenly assumes that a SECURITY.md file exist in the repository, this is of course bad practice and was done for demonstartion purposes only

## Challenges

* Lack of up-to-date documentation on the starter, driver and their respective APIs slowed down development
* I am unfamiliar with the framework and modern Kotlin syntax so I avoided writing assertions as it is unclear how the framework retrieves and returns values. (Some helper methods such "should" and "shouldBe" were mentioned in a video so that could be a good starting point)
  
