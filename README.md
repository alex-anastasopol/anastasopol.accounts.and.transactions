# anastasopol.accounts.and.transactions

<h6> Steps to start the web application </h6>

* start data provider by running this shell command: ```docker run -it --rm -p 8080:8080 mihaitatinta/wiremock-example:0.0.1```
* run ```java -jar anastasopol.accounts.and.transactions-0.0.1-SNAPSHOT.war```



<h6> Working with the web application </h6>

Web app will be accessible on port 8090.

* open browser and access http://localhost:8090/login ; this will login with username "ionescu" ; then can access any of the other links listed below

Endpoints:
* / -> home (text)
* /login -> login (text, json content)
* /accounts -> accounts of currently logged in user (text, json content)
* /transactions ->  transactions of currently logged in user(text, json content)

Responses are in text/plain with JSON-formatted content. Homepage is just plaintext.

<h6>TODOs:</h6>

* add more exception handling
* show total amount in accounts
* show transactions count, total spent
* add tests
* add ui
