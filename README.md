# anastasopol.accounts.and.transactions

<h4> Steps to start the web application </h4>

* The following must be installed on your computer:
  * Java runtime 8 or higher
  *   Docker
* Download the web application file: [anastasopol.accounts.and.transactions-0.0.1-SNAPSHOT.war](https://github.com/alex-anastasopol/anastasopol.accounts.and.transactions/blob/master/release/anastasopol.accounts.and.transactions-0.0.1-SNAPSHOT.war) 
* Run the following shell commands:
  * start data provider: ```docker run -it --rm -p 8080:8080 mihaitatinta/wiremock-example:0.0.1```
  * navigate to folder where ```anastasopol.accounts.and.transactions-0.0.1-SNAPSHOT.war``` was downloaded: e.g. cd ```C:\webapps```
  * start the web application: ```java -jar anastasopol.accounts.and.transactions-0.0.1-SNAPSHOT.war```



<h4> Working with the web application </h4>

Web app will be accessible on port 8090.

* open browser and access ```http://localhost:8090/login/username?ionescu```
* then you can access any of the other links listed below


<h5>Endpoints:</h5>

* __/__ -> home (text)
* __/login__ -> login (text, json content)
* __/accounts__ -> accounts of currently logged in user (text, json content)
* __/transactions__ ->  transactions of currently logged in user(text, json content)

Responses content type is ```text/plain``` with JSON content. Homepage is just plaintext.




<h4> Images:</h4>

<h5>Home:</h5>

![Image of homepage](https://github.com/alex-anastasopol/anastasopol.accounts.and.transactions/blob/master/readme_images/homepage.png)



<h5>Login:</h5>

![Image of login page](https://github.com/alex-anastasopol/anastasopol.accounts.and.transactions/blob/master/readme_images/login.png)



<h5>Accounts:</h5>

![Image of accounts page](https://github.com/alex-anastasopol/anastasopol.accounts.and.transactions/blob/master/readme_images/accounts.png)



<h5>Transactions:</h5>

![Image of transactions page](https://github.com/alex-anastasopol/anastasopol.accounts.and.transactions/blob/master/readme_images/transactions.png)





<h4>TODOs:</h4>

* add more exception handling
* show total amount in accounts
* show transactions count, total spent
* add tests
* add ui


