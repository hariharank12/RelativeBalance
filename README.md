# RelativeBalance
To find relative balance of an account for a given time frame.

## Design Conventions
* Uses Java8 for console implementation.
* Uses inputTransactions.csv for input transactions in class path. 
* Choice of build tool is Maven because of first class IDE support.
* Uses Junit4 for testing.
* Uses domain driven design, Strategy pattern and Hash set data structure used for eliminating redundancy transaction(of reversal type) 
and corresponding transaction is marked for deletion. 

## Build and Run
* mvn clean install && mvn exec:java -Dexec.mainClass="org.me.accounts.App" -Dexec.args="ACC334455 '20/10/2018 12:00:00' '20/10/2018 15:00:00'" or 
java -jar RelativeBalance-1.0.jar "ACC334455" "20/10/2018 12:00:00" "20/10/2018 19:00:00"
