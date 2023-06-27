Feature: Login Functionality

Scenario Outline: Login with valid credentials
Given Navigate to tutorialsninja login page 
When Enter valid email address <username> in email field
And Enter valid password <password> in password field
And Click on the Login button
Then User should get successfully logged in
Examples: 
|username               |password  |
|borole116@gmail.com    |Test@1998 |
|borole116@gmail.com    |Test@1998 |
|borole116@gmail.com    |Test@1998 |

Scenario: Login with invalid credentials
Given Navigate to tutorialsninja login page 
When Enter invalid email address "admin@xyz.com" in email field
And Enter invalid password "invalid" in password field
And Click on the Login button
Then User should get a warning message as No match for E-Mail Address and/or Password.

Scenario: Login with valid email & invalid password credentials
Given Navigate to tutorialsninja login page 
When Enter valid email address "borole116@gmail.com" in email field
And Enter invalid password "invalid-pass" in password field
And Click on the Login button
Then User should get a warning message as No match for E-Mail Address and/or Password.

Scenario: Login with invalid email & valid password credentials
Given Navigate to tutorialsninja login page 
When Enter invalid email address "admin.com" in email field
And Enter valid password "Test@1998" in password field
And Click on the Login button
Then User should get a warning message as No match for E-Mail Address and/or Password.

Scenario: Login without providing credentials
Given Navigate to tutorialsninja login page 
When Do not enter email address in email field
And Do not enter password in password field
And Click on the Login button
Then User should get a warning message as No match for E-Mail Address and/or Password.
