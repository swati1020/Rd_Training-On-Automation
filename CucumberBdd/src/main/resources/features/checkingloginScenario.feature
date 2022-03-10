Feature: Login Page
Description: test the login functionality for OrangeHRM application

Background: to Launch the chrome Browser
Given Browser

  Scenario Outline: Login Page with various credential
   Given LoginPage is Opened
  And Username is '<username>' and password is '<password>'
   
    When user click on login button
    Then user should navigate to '<page>'

    Examples: 
      | username  | password | page  |
      | Admin |     U@qBLVtm09 | dashboard |
      | name2 |     abcg | retryLogin   |
      
