# PersonalWeightTracker
Egen Coding Challenge - Level 2

# Run
1. Open three CMD windows (Windows) or three Terminal windows (MacOS, Linux) and arrange so you can view them conveniently.
2. In each window, change to the directory where you cloned the repo
3. In the first window, build the application using mvn clean package
4. In the same window run: java -jar target/personalweighttracker-0.0.1-SNAPSHOT.jar registration and wait for it to start up
5. Switch to the second window and run: java -jar target/personalweighttracker-0.0.1-SNAPSHOT.jar metrics and again wait for it to start up
6. In the third window run: java -jar target/personalweighttracker-0.0.1-SNAPSHOT.jar alerts
7. In your favorite browser open the links: http://localhost:1111 for eureka server
8. Browse the api GET http://localhost:8080/metrics/read, GET http://localhost:8080/metrics/readRange/timestampBegin/timestampEnd, POST http://localhost:8080/metrics/create
9. Browse the api GET http://localhost:8081/alerts/read, GET http://localhost:8080/alerts/readRange/timestampBegin/timestampEnd
