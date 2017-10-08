@all
Feature: Client is able to perform search and selection

  @severity=blocker
  Scenario: Client is able to open home page
    Given client opens ss.lv home page
    Then page is opened

  Scenario: Client is able to search by various input parameters
    Given client has opened "Datori un orgtehnika" section
    And he opens search page
    When client fills in input: portatīvais, region: Rīga and period: Pēdējā mēnesī
    Then search result page is opened

  Scenario: Client is able to see selected elements in separate view
    Given client has opened "Datori un orgtehnika" section
    And he clicks link with text Datori
    When client selects 4 random elements
    And he clicks on show selected items link
    Then only 4 selected elements are shown
