Feature: Add new user address after login

  Scenario Outline: Add new user address and check values
    Given User is logged to the mystore-testlab website
    When User decides to add new address
    And User fill the form with data <alias>, <address>, <city>, <zip>, <phoneNumber>
    Then User new address cointains <alias>, <address>, <city>, <zip>, <phoneNumber>
    And User delete new address
    And User checked if the address removal was successful, not contain <alias>, <address>, <city>, <zip>, <phoneNumber>
    And User close the browser
    Examples:
      | alias  | address  | city    | zip    | phoneNumber |
      | Office | ul.Jasna | Opoczno | 44-198 | 552112764   |
