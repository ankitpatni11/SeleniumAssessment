Feature: Automate Add to Cart using Cucumber
Description: the file searches for appium book on amazon.com and prints the total amount and rating for 10th book

Scenario: User add Appium book into Cart

Given user is on Home Page

Then user search for Appium Book
Then user selects the 10th Book
Then Print the rating of the Book
Then Add Book into the Cart
Then Print Total AMount of the Book




