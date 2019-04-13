@blank
Feature: Some blank feature with various cuke things

  Background:
    Given I run the first step

  Scenario: Scenario one basic pass
    When I run second step with argument "test"
    Then step should pass

  Scenario: Scenario two with table
    When I run step with data table
      | name      | value      |
      | something | with value |
    Then step should pass

  Scenario: Scenario three with failure
    When I run second step with argument "test"
    Then step should fail with attachment

  Scenario: Scenario four with failure and steps after
    When I run second step with argument "step"
    Then step should fail with attachment
    And I run the first step

  Scenario Outline: Scenario outline with args
    When I run second step with argument "<argument>"
    Then step should pass
    Examples:
      | argument |
      | arg1     |
      | arg2     |