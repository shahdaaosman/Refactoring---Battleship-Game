# Refactoring - Battleship Game

This project is a refactoring for the Battleship Game that was built in Assignment 3

Refactoring 1: change the implementation of play method to getAwinner method NewGame.java line 73

Refactoring 2: remove duplicated code that check for existing shoot in Board.java line 86

Refactoring 3: Extract method by include all playing steps in playGame method NewGame.java line 78 & 90

Refactoring 4: add Gameplayer super class for player to extend player types NewGame.java line 43

Refactoring 5: move intiBoard() form Board.java to GamePlayer.java class GamePlayer.java line 39

Refactoring 6: build Template pattern to let each game player follow game steps GamePlayer.java line 14

Refactoring 7: each game player have different shoot method ComputerPlayer.java line 12 HumanPlayer.java Line 27

Refactoring 8: rename Player class to HumanPlayer.java line 14

# Features implemented
<p>The main refactoring was built by using Template pattern:</p>
  <p>1-Template Design Pattern.</p>
  The Template Method defines a skeleton of an algorithm in an operation, and defers some steps to subclasses. 
  <p>2-Singelton Design Pattern.</p>
  This design pattern help to Ensure that game class has only one instance, and provide a global point of access to it.
  <p>3-Simple Factory Design Pattern.</p>
  This allows interfaces for creating objects without exposing the object creation logic to the client.

# Implementation Details
By Adding the Template pattern the game become Flexible to add any type of player
and make sure that they all will follow the same steps for playing.
it help to avoid duplication in the code: the general workflow structure is implemented once in the abstract class's algorithm, and necessary variations are implemented in the subclasses.
Control at what points subclassing is allowed to do changes.

# Getting Started

This project built in a Java Maven Template and it
use Apache Maven to compile and run. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run


```bash
java -classpath target/Example-1-1.0-SNAPSHOT-jar-with-dependencies.jar edu.bu.met.cs665.Main
```

or


```bash
run.sh 
```

# Using Findbugs 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn findbugs:gui 
```

or 


```bash
mvn findbugs:findbugs
```

# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```


# Generate  coveralls:report 

```bash
mvn -DrepoToken=YOUR-REPO-TOCKEN-ON-COVERALLS  cobertura:cobertura coveralls:report
```


