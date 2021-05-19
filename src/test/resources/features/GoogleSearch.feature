Feature: search a word

  Background: searching a word named rose

  Scenario: user searches a word in google
    When user type word and enter
    Then user found that word
