Feature: 

	#User story
	#
	#as a user I should be able to access account activity page
	@EU2-176
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