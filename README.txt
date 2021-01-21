#Installation

1. Download and Install JDK 13.0.1

------------------------------------------------------------------------------------------------------------------------
##WINDOWS##
2. In you system variables create JAVA variable that points to your jdk folder in Program Files
(ex. C:\Program Files\Java\jdk-9.0.4)

3. In your `Path` system variable point to `\bin` in your jdk folder in Program Files
ex.(C:\Program Files\Java\jdk-9.0.4\bin)

4. Download and install Maven Apache 3.5.2 from `https://maven.apache.org/docs/3.5.2/release-notes.html`

5. In your system variables create MAVEN variable that points to your newly installed Maven Apache
ex.(C:\Program Files\Maven\apache-maven-3.5.2)

6. In your `Path` system variable point to `\bin` in your maven folder
ex.(C:\Program Files\Maven\apache-maven-3.5.2\bin)

------------------------------------------------------------------------------------------------------------------------
##MAC##
2. In your .bash_profile create JAVA variable that points your jdk folder
ex.(export JAVA_HOME=$(/usr/libexec/java_home)

3. In your .bash_profile export the `PATH` to your Maven bin folder
ex.(export PATH=$PATH:/User/username/Documents/Maven/apache-maven-3.5.2/bin)

------------------------------------------------------------------------------------------------------------------------
7. Download and install Community version for IntelliJ from `https://www.jetbrains.com/idea/download`

8. After opening the project go to File -> Project Structure -> Project Settings -> Project
*change Project language level to `13`

9. Go to File -> Project Structure -> Project Settings -> Modules -> Sources
*change Language level to `13`

10. Make sure that the Project SDK and Module SDK are 9.

________________________________________________________________________________________________________________________

#Execution
Run the following commands in terminal:
1. mvn clean
2. mvn test -Dbrowser=chrome
2.a if you can also run it  chromeHeadless, firefox, firefoxHeadless