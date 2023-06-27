Feature: Search Functionality

Scenario: Searches for a valid product
Given Navigate to tutorialsninja search page 
When Enter valid product name "HP" into searchbox field
And Click on the Search button
Then User should get valid product displayed in the search result

Scenario: Searches for a invalid product
Given Navigate to tutorialsninja search page 
When Enter invalid product name "Honda" into searchbox field
And Click on the Search button
Then User should get a message about no product matching

Scenario: Searches without any product
Given Navigate to tutorialsninja search page 
When Do not enter any product name into searchbox field
And Click on the Search button
Then User should get a message about no product matching

