Feature: SignUp into Programs Portal

  Scenario: User should be able to Signup
    Given Programs portal URL
    When User enters credentials
    And Click on Submit button
    Then User should be navigated to SignIn Page