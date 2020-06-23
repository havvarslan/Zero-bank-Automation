package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.Dashboard;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class FindTransactionsStepDefs {

    @Given("the user access the Find Transactions tab")
    public void the_user_access_the_Find_Transactions_tab() {
        BrowserUtils.waitFor(3);
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(3);
        new Dashboard().signinButton.click();
        new LoginPage().login2();
        BrowserUtils.waitFor(2);
        AccountActivity accountActivity = new AccountActivity();
        accountActivity.accountActivityButton.click();
        BrowserUtils.waitFor(2);
        accountActivity.findTransactions.sendKeys(Keys.ENTER);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String string, String string2) {
        BrowserUtils.waitFor(2);
        AccountActivity accountActivity= new AccountActivity();
        accountActivity.fromDate.sendKeys(string);
        accountActivity.toDate.sendKeys(string2);
    }


    @Then("results table should only show transactions dates between {string} and {string}")
    public void results_table_should_only_show_transactions_dates_between_and(String string, String string2) {
//          BrowserUtils.waitFor(2);
//          AccountActivity accountActivity = new AccountActivity();
//        Assert.assertEquals(string2, accountActivity.searchFirstDate.getText());
//       // Assert.assertEquals(string, accountActivity.searchLastDate.getText());
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
       BrowserUtils.waitFor(2);
       new AccountActivity().description.sendKeys(string);
    }

    @When("click search")
    public void click_search() {
      BrowserUtils.waitFor(2);
      new AccountActivity().findButton.click();
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
       BrowserUtils.waitFor(3);
       AccountActivity accountActivity = new AccountActivity();
       //Assert.assertEquals(string, accountActivity.);
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        BrowserUtils.waitFor(2);
        AccountActivity accountActivity = new AccountActivity();
        accountActivity.description.sendKeys(string);
        Assert.assertTrue(accountActivity.noResult.isDisplayed());

    }

    @Then("result table shoud only show descriptions containing {string}")
    public void result_table_shoud_only_show_descriptions_containing(String string) {

    }

    @Then("results table should only show descriptions contaiing {string}")
    public void results_table_should_only_show_descriptions_contaiing(String string) {

    }

    @Given("clicks search")
    public void clicks_search() {
      BrowserUtils.waitFor(2);
      new AccountActivity().findButton.click();
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {

    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {

    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
         BrowserUtils.waitFor(2);
         AccountActivity accountActivity = new AccountActivity();
        Select typeDropdown = new Select(accountActivity.typeOfTransaction);
        typeDropdown.selectByVisibleText(string);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {

    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {

    }
}
