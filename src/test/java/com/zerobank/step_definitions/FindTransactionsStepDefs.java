package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefs {

    @Given("the user access the Find Transactions tab")
    public void the_user_access_the_Find_Transactions_tab() {
        BrowserUtils.waitFor(2);
        new AccountActivity().findTransactions.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        BrowserUtils.waitFor(2);
        AccountActivity accountActivity= new AccountActivity();
        accountActivity.fromDate.clear();
        accountActivity.toDate.clear();
        accountActivity.fromDate.sendKeys(fromDate);
        accountActivity.toDate.sendKeys(toDate);
    }


    @Then("results table should only show transactions dates between {string} and {string}")
    public void results_table_should_only_show_transactions_dates_between_and(String fromDate, String toDate) {
          BrowserUtils.waitFor(2);
          AccountActivity accountActivity = new AccountActivity();
        List<Integer> daysInt= accountActivity.getDaysInteger();
        int fromDay = accountActivity.getFromDay(fromDate);
        int toDay = accountActivity.getToDay(toDate);

        boolean flag = true;
        for (int i=0; i< daysInt.size(); i++){
            if(!(daysInt.get(i) >= fromDay && daysInt.get(i)<= toDay)){
                flag = false;
                break;
            }
        }
          Assert.assertTrue ("Verify the dates", flag);
    }


    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        AccountActivity accountActivity = new AccountActivity();
        List<Integer> dayList = accountActivity.getDaysInteger();

        boolean flag = false;

        if(dayList.size()>1){
            if(dayList.get(0)>= dayList.get(dayList.size()-1)){
                flag=true;
            }
        }else if(dayList.size() == 0){
            flag=true;
        }

        Assert.assertTrue("verify the sorted recent order", flag);
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String excludedDate) {
        List<String> tableDates = BrowserUtils.getElementsText(new AccountActivity().tableDates);
        boolean flag = true;
        for (String tableDate : tableDates) {
            if (tableDate.equals(excludedDate)) {
                flag = false;
            }
        }
        Assert.assertTrue("verify the excluded date", flag);
    }


    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
       BrowserUtils.waitFor(2);
       new AccountActivity().description.clear();
       new AccountActivity().description.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
       BrowserUtils.waitFor(3);
       AccountActivity accountActivity = new AccountActivity();

       List<WebElement> tableDescription = accountActivity.tableDescription;
       List<String> descriptions = BrowserUtils.getElementsText(tableDescription);

       boolean flag = true;
       for(String option : descriptions){
           if(!option.contains(description)){
               flag = false;
               break;
           }
       }
        if (descriptions.size() == 0) {
            flag = false;
        }
       Assert.assertTrue("verify " + description +" containing", flag);
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {
        BrowserUtils.waitFor(3);
        AccountActivity accountActivity = new AccountActivity();

        List<WebElement> tableDescription = accountActivity.tableDescription;
        List<String> descriptions = BrowserUtils.getElementsText(tableDescription);

        boolean flag = false;
        for(String option : descriptions){
            if(option.contains(description)){
                flag = true;
                break;
            }
        }
        Assert.assertTrue("verify " + description +"not containing", flag);
    }

    @Given("clicks search")
    public void clicks_search() {
      BrowserUtils.waitFor(2);
      new AccountActivity().findButton.click();
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        BrowserUtils.waitFor(2);
        List<WebElement> depositTable = new AccountActivity().tableDeposits;
        int a=0;
        for (WebElement deposit:depositTable) {
            if(!deposit.getText().isEmpty()){
                a++;
            }
        }
        System.out.println("# of Deposit "+ a);
        Assert.assertTrue("verify deposit table", a>1);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        BrowserUtils.waitFor(2);
        List<WebElement> withdrawTable = new AccountActivity().tableWithdraw;
        int a=0;
        for(WebElement withdraw : withdrawTable){
            if(!withdraw.getText().isEmpty()){
                a++;
            }
        }
        System.out.println("# of withdraw "+ a);
        Assert.assertTrue("Verify the withdraw ", a>1);
    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
         BrowserUtils.waitFor(2);
         AccountActivity accountActivity = new AccountActivity();
        Select selectType = accountActivity.selectType();
        selectType.selectByVisibleText(type);
        accountActivity.findButton.click();
        BrowserUtils.waitFor(5);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        BrowserUtils.waitFor(2);
        List<WebElement> withdawTable = new AccountActivity().tableWithdraw;
        int a =0;
        for(WebElement withdraw : withdawTable){
            if(!withdraw.getText().isEmpty()){
                a++;
            }
        }
        Assert.assertTrue("Verify no withdraw", a == 0);
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        BrowserUtils.waitFor(2);
        List<WebElement> depositTable = new AccountActivity().tableDeposits;
        int a = 0;
        for(WebElement deposit : depositTable){
            if(!deposit.getText().isEmpty()){
                a++;
            }
        }
        Assert.assertTrue("verify no deposit", a == 0);
    }
}
