Feature: Register Functionality

Scenario: Creates an account only with mandatory fields
Given Navigate to tutorialsninja Register Account page 
When Enters the details into below fields
| firstName  | Utka               | 
| lastName   | singam             | 
| telephone  | 8907654323         | 
| password   | 234567             | 
And Select privacy policy checkbox
And Click on the Continue button
Then User account should get created successfully

Scenario: Creates an account with all fields
Given Navigate to tutorialsninja Register Account page 
When Enters the details into below fields
| firstName | dhivya           | 
| lastName  | Menon            | 
| telephone | 123567890        | 
| password  | 5678903          | 
And Select subscribe Yes for Newsletter
And Select privacy policy checkbox 
And Click on the Continue button
Then User account should get created successfully

Scenario: Creates a duplicate account
Given Navigate to tutorialsninja Register Account page 
When Enters the duplicate details into below fields
| firstName | Yogesh              | 
| lastName  | Borole              | 
| email     | borole116@gmail.com | 
| telephone | 7620510652          | 
| password  | Test@1998           | 
And Select subscribe Yes for Newsletter
And Select privacy policy checkbox 
And Click on the Continue button
Then User should get a warning message like E-Mail Address is already registered

Scenario: Creates an account without filling any details
Given Navigate to tutorialsninja Register Account page
When do not enters any details into all fields
And Click on the Continue button
Then User should get a warning message for every mandatory field including Privacy Policy
