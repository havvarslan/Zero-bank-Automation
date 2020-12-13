@accountAct
Feature: Account Activity page

  Scenario: Account drop down
    Given the user logs in
    When the page have the title Account Activity
    Then drop down default option should be "Savings"


  Scenario: Account types
    Given the user logs in
    When the page have the title Account Activity
    And the user should see following options in dropdown
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Transaction table
    Given the user logs in
    When the page have the title Account Activity
    Then the user should be on the on the "Show Transactions" table
    And the user should see following columns
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |