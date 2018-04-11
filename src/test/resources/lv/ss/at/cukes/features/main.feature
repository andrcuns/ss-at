@main
Feature: Client is able to open main page and search items

  @severity=blocker
  Scenario: Client is able to open home page
    Given client opens ss.lv home page
    Then page is opened

  Scenario: Client is able to search by various input parameters
    Given client has opened "Datori un orgtehnika" section
    And he opens search page
    When client fills in input: portatīvais, region: Rīga and period: Pēdējā mēnesī
    Then search result page is opened