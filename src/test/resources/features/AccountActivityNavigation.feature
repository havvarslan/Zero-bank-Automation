@accountNav
Feature:Navigation to specific accounts in Accounts Activity

#  Scenario Outline: <accountType> account redirect
#    Given the user logs in
#    When the user clicks on "<accountType>" link on the Account Summary page
#    Then the Account Activity page should be displayed with "<expected_message>"
#    And Account drop down should have "<accountType>" selected
#    Examples:
#      | accountType | expected_message  |
#      | Savings     | Show Transactions |
#      | Brokerage   | Show Transactions |
#      | Checking    | Show Transactions |
#      | Credit Card | Show Transactions |
#      | Loan        | Show Transactions |

Background:
    Given the user logs in


  Scenario:Savings account redirect
    When the user clicks on "Savings" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "Savings" selected

  Scenario:Brokerage account redirect
    When the user clicks on "Brokerage" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "Brokerage" selected

  Scenario:Checking account redirect
    When the user clicks on "Checking" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "Checking" selected

  Scenario:Credit Card account redirect
    When the user clicks on "Credit Card" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "Credit Card" selected

  Scenario:Loan account redirect
    When the user clicks on "Loan" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "Loan" selected


