Feature: Edit The User Role
  
Background: To launch the chrome browser
Description: We are testing the user edit functionality for OrangeHRM application

  #@Scenario 1
  Scenario: Login 
     Given User has its Credentials 
      And Password  
     When User enters the correct Username and Password  
     Then It should be loggedin and navigate to dashboard 
   
   #@Scenario 2
   Scenario: Unsuccessful Login
     When User enters either wrong Username or Password  
     Then It should be reverse back on the login page with an error message

  #@Scenario 3
   Scenario: Dashboard Page for User 
   Given Dashboard Page
   When click on admin button 
   Then On Click user should able to see the User Management under management user can see the admin option
   
   #@Scenario 4
   Scenario: User's Page
   Given user page
   When Click on Users button 
   Then It should navigate to users page
   
     #@Scenario 5
   Scenario: User's Page
   Given Dashboard page for user
   When Click on Users button 
   Then It should navigate to users page
   
       #@Scenario 6
   Scenario: User's Page
   Given user page
   When Click on edit icon where user='Amanda'
   Then user should be able to edit Users pop-up on screen
   
          #@Scenario 7
   Scenario: User's Page
   Given users page
   When click on Admin Role dropdown and Click on global admin from list of available admin roles 
  Then User click on save button
   Then User should be able to see the list of Admin roles updated to global admin and user 
   
          #@Scenario 8
   Scenario: User's Page
   Given user page
   When again click on edit icon where username="amanda" 
   AND click on select from the dropdown
   Then click on save button 
   Then user should be able to see the admin role got upadated to global again
   
           #@Scenario 9
   Scenario: User's Page
   Given user page
   When go to left panel and click on down-arrow on left panel
   Then click on logout
   Then user should be reverse back on the login page
   
   
   
   
   


