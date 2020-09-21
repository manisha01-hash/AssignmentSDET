Feature: Login Feature


  Scenario: Login as Admin
    Given I am able to navigate onto login page
    When I enter the username as "Admin"
    And I enter the password as "admin123"
    And I click on the login button
    Then I should see the username as "Welcome Linda"
    
    Scenario: Login as Linda.anderson
    Given I am able to navigate onto login page
    When I enter the username as "Linda.anderson"
    And I enter the password as "Linda.anderson"
    And I click on the login button
    Then I should see a Error message as "Invalid credentials"
    
    Scenario: Login as Negative testing
    Given I am able to navigate onto login page
    When I enter the username as "Manisha"
    And I enter the password as "Manisha123"
    And I click on the login button 
    Then I should see a Error message as "Invalid credentials"
    
    
