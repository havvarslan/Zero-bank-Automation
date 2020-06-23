Feature: 

	@EU2-175
	Scenario: ZRBNK-Account Activity Page(Havva)
		Given the user logs in
		When the page have the title Account Activity
		Then drop down default option should be "Savings"