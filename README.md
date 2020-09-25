# anastasopol.accounts.and.transactions

Web app will be accessible on port 8090.

Endpoints:
* /
* /login
* /accounts
* /transactions


* http://localhost:8090/ -> home (text)
* http://localhost:8090/login -> login (text, json content)
* http://localhost:8090/accounts -> accounts of currently logged in user (text, json content)
* http://localhost:8090/transactions ->  transactions of currently logged in user(text, json content)


Responses are in text/plain with JSON-formatted content. Homepage is just plaintext.


<h6>TODOs:</h6>
* add more exception handling

* show total amount in accounts
* show transactions count, total spent
* add tests
* add ui

<h6>To start the program </h6>
  
 * start data provider is running: in docker, run this command: <code>docker run -it --rm -p 8080:8080 mihaitatinta/wiremock-example:0.0.1</code> 
  
 * TODO ; run anastasopol.accounts.and.transactions-0.0.1-SNAPSHOT.war

