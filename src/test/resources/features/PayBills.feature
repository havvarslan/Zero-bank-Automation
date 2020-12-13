Feature: Pay Bills

  Scenario: Pay Bills page
    Given the user logs in
    When user should be on the "Pay Bills" page
    Then the title should be "Zero - Pay Bills"


  Scenario Outline: Pay operation
    Given the user logs in
    When user should be on the "<pageType>" page
    And the user submits a payment operation with entering the "<payee>", "<account>", "<amount>", "<date>", "<description>"
    Then the message "<expected_msj>" should be displayed
    Examples:
      | pageType  | payee       | account | amount | date       | description | expected_msj                            |
      | Pay Bills | Wells Fargo | Loan    | 300200 | 2020-06-03 | for savings | The payment was successfully submitted. |
 #     | Pay Bills | Sprint      | Savings |        | 2020-06-03 | for savings | Please fill out this field.         |
  #    | Pay Bills | Sprint      | Savings | 10000  |            | for savings | Please fill out this field.           |

 Scenario Outline: Pay operation with lack info
   Given the user logs in
   When user should be on the "<pageType>" page
   And the user submits a payment operation without entering the "<amount>" or "<date>"
   Then the message should be displayed "<expected_message>"
    Examples:
#      | pageType  | amount | date       | expected_message              |
#      | Pay Bills | 300900 |            | "Please fill out this field." |
#      | Pay Bills |        | 2020-06-03 | "Please fill out this field." |

#  Scenario: No alphabetical or special characters in amount
#    Given the user logs in
#    When user should be on the "Pay Bills" page
#    And user submits a payment with alphabetical or special characters in the "amount"
#    And user submits a payment with alphabetical characters in the "date"
#    Then the message "The payment was successfully submitted" should not be displayed
