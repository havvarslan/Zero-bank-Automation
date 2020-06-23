
  Feature: Purchase Foreign Currency
    Scenario: Available currencies
      Given the user accesses the Purchase foreign currency cash tab
      Then following currencies should be available
                      |Australia(dollar)  |
                      |Canada(dollar)     |
                      |Switzerland(franc) |
                      |China(yuan)        |
                      |Denmark(krone)     |
                      |Eurozone(euro)     |
                      |Great Britain(pound|
                      |Japan(yen)         |
                      |Mexico(peso)       |
                      |Norway(krone)      |
                      |New Zealand(dollar)|
                      |Singapore(dollar   |

      Scenario: Error message for not selecting currency
        Given the user accesses the Purchase foreign currency cash tab
        When user tries to calculate cost without selecting a currency
        Then error message shoud be displayed

      Scenario: Error message for not entering a value
        Given the user accesses the Purchase foreign currency cash tab
        When user tries to calculate cost without entering value
        Then error message should be displayed