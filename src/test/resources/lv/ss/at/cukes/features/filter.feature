@filter
Feature: Client is able to perform search and selection

  Scenario: Client is able to see selected elements in separate view
    Given client has opened "Datori un orgtehnika" section
    And he clicks link with text Datori
    When client selects 4 random elements
    And he clicks on show selected items link
    Then only selected elements are shown

  Scenario: Client is able to select price range for items
    Given client has opened "Datori un orgtehnika" section
    And he clicks link with text Datori
    When client enters price range from 20 to 400 and submits form
    Then only elements with price 20 to 400 are shown