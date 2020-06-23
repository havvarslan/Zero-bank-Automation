Feature: Users should be able to login

  Background:
    Given the user is on the login page


  Scenario Outline:Login with <userType>
    When the user logs in using "<userType>" and "<password>" in following credentials
    Then  "<message>" is displayed
    Examples:
      | userType  | password      | message                          |
      | username  | password      | Zero - Account Summary           |
      | wronguser | password      | Login and/or password are wrong. |
      | username  | wrongpassword | Login and/or password are wrong. |
      |           | password      | Login and/or password are wrong. |
      | username  |               | Login and/or password are wrong. |



