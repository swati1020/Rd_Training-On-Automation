Feature: Login Page
Description: test the login functionality for OrangeHRM application

Background: to Launch the chrome Browser
Given Browser

Scenario: Login page with correct User
Given Username is 'Admin' and password is 'UQSfdkk'
When user click on login button
Then User should navigate to Dashboard

#Scenario: Login page with incorrect User
#Given Username is 'Admin' and password is 'abcd'
#When user click on login button
#Then User should navigate to Retry Page