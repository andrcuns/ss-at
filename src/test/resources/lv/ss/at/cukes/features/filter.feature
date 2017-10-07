Feature: Client is able to perform search and filtering

  Scenario: Client is able to search by various input parameters
    Given client opens ss.lv home page
    And he changes input language
    And he clicks link with text Электротехника
    And he opens search page
    When client fills in input: ноутбук, region: Рига and period: За последний месяц
    Then search result page is opened

  Scenario: Client is able to see selected elements in separate view
    Given client has opened "Datori un orgtehnika" section
    And he clicks link with text Datori
    When client selects 4 random elements
    And he clicks on show selected items link
    Then only 4 selected elements are shown
