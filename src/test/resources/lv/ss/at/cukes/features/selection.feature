@selection @disabled
Feature: Client is able to open selected elements

  Scenario: Client is able to see selected elements in separate view
    Given client has opened "Datori un orgtehnika" section
    And he clicks link with text Datori
    When client selects 4 random elements
    And he clicks on show selected items link
    Then only selected elements are shown