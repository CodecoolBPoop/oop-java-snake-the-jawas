#!/bin/sh
javac /home/akincsei/IntelliJ/3TW-snake/src/*.java
jar cf SnakeFromJawas.jar /home/akincsei/IntelliJ/3TW-snake/out/production/3TW-snake/*.class
javac -cp SnakeFromJawas.jar SnakeFromJawas.jar /home/akincsei/IntelliJ/3TW-snake/src/com/codecool//snake/Main.java

# path/to/containing/folder$ chmod +x ./compile.sh
# path/to/containing/folder$ ./compile.sh
# cd src/
# java exercises.java.Exercise1
# !!!!!!! not really working here
