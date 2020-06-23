Feature: Account transaction

	@EU2-178
	Scenario: Account Activities
		Given the user logs in
		    When the pages have the title Account Activity
		    Then the users should be on the on the "Show Transactions" table
		    And the users should see following columns
		      | Date        |
		      | Description |
		      | Deposit     |
		      | Withdrawal  |