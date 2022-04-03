@echo off
title 15-Puzzle Game

cd src && javac -d ../bin *.java
java -cp ../bin GUI

pause