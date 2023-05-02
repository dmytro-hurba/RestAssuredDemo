Feature: Application login

  Scenario: Home page default login
    Given user in on  NetBanking landing page
    When user  login to application with username and password
    Then homepage is populated
    And cards is displayed

