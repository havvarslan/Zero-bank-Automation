Feature:Account summary page

  Scenario: Account summary page title
    Given the user logs in
    When the page have the title |Zero-Account Summary|
    Then the page should have the following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    Then Account table columns must have
      | Account     |
      | Credit Card |
      | Balance     |