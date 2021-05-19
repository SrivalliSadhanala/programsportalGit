Feature: The User Should be navigated to Speakers in ProgramsPortal

  Scenario: The user is in ProgramsPortal Home Page, user should be navigated to Speakers Page
    Given User signedin to the Programs portal and is in HomePage
    When User clicks on togglebutton
    And From the displayed items user clicks on MasterDataManagement
    And when he selects Speakers from MasterDataManagement
    Then User will be navigated to Speakers Page