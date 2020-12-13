@currency
  Feature: Purchase Foreign Currency

     Background:
        Given the user logs in
        And the user should be in Pay Bills Page

    Scenario: Available currencies
      Given the user accesses the Purchase foreign currency cash tab
      Then following currencies should be available
                      |Select One          |
                      |Australia (dollar)  |
                      |Canada (dollar)     |
                      |Switzerland (franc) |
                      |China (yuan)        |
                      |Denmark (krone)     |
                      |Eurozone (euro)     |
                      |Great Britain (pound)|
                      |Hong Kong (dollar)  |
                      |Japan (yen)         |
                      |Mexico (peso)       |
                      |Norway (krone)      |
                      |New Zealand (dollar)|
                      |Sweden (krona)      |
                      |Singapore (dollar)   |
                      |Thailand (baht)     |

      Scenario: Error message for not selecting currency
        Given the user accesses the Purchase foreign currency cash tab
        When user tries to calculate cost without selecting a currency
        Then error message should be displayed

      Scenario: Error message for not entering a value
        Given the user accesses the Purchase foreign currency cash tab
        When user tries to calculate cost without entering value
        Then error message should be displayed