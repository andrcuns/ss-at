@all @filter
Feature: Client is able to perform search and selection

  Scenario: Client is able to search by various input parameters
    Given client has opened "Datori un orgtehnika" section
    And he opens search page
    When client fills in input: portatīvais, region: Rīga and period: Pēdējā mēnesī
    Then search result page is opened

  Scenario: Client is able to select price range for items
    Given client has opened "Datori un orgtehnika" section
    And he clicks link with text Datori
    When client enters price range from 20 to 400 and submits form
    Then only elements with price 20 to 400 are shown