Feature: Open the browser

  Background: To launch the chrome browser
    Given browser is opened


  Scenario: Test the saucedemo
    Given User is already on login Page
    When User enter the credentails
    Then it will login to page

