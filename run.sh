echo "Compiling Tests..."
if javac -cp .:selenium-java-2.52.0.jar:selenium-server-standalone-2.52.0.jar:hamcrest-core-1.3.jar:junit-4.12.jar *.java; then
    echo "Executing Tests..."
    java -cp .:selenium-java-2.52.0.jar:selenium-server-standalone-2.52.0.jar:hamcrest-core-1.3.jar:junit-4.12.jar TestRunner
else
    echo "TESTS FAILED TO COMPILE, NO TESTS EXECUTED"
fi
