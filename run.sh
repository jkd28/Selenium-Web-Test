echo "Compiling Tests..."
javac -cp .:selenium-java-2.52.0.jar:selenium-server-standalone-2.52.0.jar:hamcrest-core-1.3.jar:junit-4.12.jar *.java
echo "Executing Tests..."
java -cp .:selenium-java-2.52.0.jar:selenium-server-standalone-2.52.0.jar:hamcrest-core-1.3.jar:junit-4.12.jar TestRunner
