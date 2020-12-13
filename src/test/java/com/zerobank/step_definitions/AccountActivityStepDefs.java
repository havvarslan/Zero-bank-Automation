package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.ZeroAccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepDefs {

    @When("the page have the title Account Activity")
    public void the_page_have_the_title_Account_Activity() {
        BrowserUtils.waitFor(3);
        new AccountActivity().accountActivityButton.click();

        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Verify title","Zero - Account Activity",actualTitle);
    }

    @Then("drop down default option should be {string}")
    public void drop_down_default_option_should_be(String expectedOption) {
      BrowserUtils.waitFor(3);
      AccountActivity accountActivity = new AccountActivity();
      Select dropdown = new Select(accountActivity.dropdownMenu);
      String actualOption = dropdown.getFirstSelectedOption().getText();

      Assert.assertEquals(expectedOption,actualOption);
    }

    @When("the user should see following options in dropdown")
    public void the_user_should_see_following_options_in_dropdown(List<String> dropdownList) {
        BrowserUtils.waitFor(3);
        List<String> actualListOfTable = new AccountActivity().accountDropdown();

        Assert.assertEquals(dropdownList, actualListOfTable);
        System.out.println("Actual table= "+ actualListOfTable);
        System.out.println("expected table= "+ dropdownList);
    }

    @Then("the user should be on the on the {string} table")
    public void the_user_should_be_on_the_on_the_table(String string) {
        BrowserUtils.waitFor(3);
        AccountActivity accountActivity = new AccountActivity();
        Assert.assertTrue("verify that transaction table", accountActivity.showTrans.isDisplayed());


    }

    @Then("the user should see following columns")
    public void the_user_should_see_following_columns(List<String> tableColoumn) {
        BrowserUtils.waitFor(3);
        List<String> actualListOfTable = BrowserUtils.getElementsText(new AccountActivity().tableColumn);

        Assert.assertEquals(tableColoumn, actualListOfTable);
        System.out.println("Actual table= "+ actualListOfTable);
        System.out.println("expected table= "+ tableColoumn);
    }
//    @When("the user clicks on {string} link on the Account Summary page")
//    public void the_user_clicks_on_link_on_the_Account_Summary_page(String selectedOption) {
//       BrowserUtils.waitFor(3);
//       AccountActivity accountActivity = new AccountActivity();
//
//       if(selectedOption.equals(accountActivity.savingsTab.getText())){
//           accountActivity.savingsTab.click();
//       }else if(selectedOption.equals(accountActivity.brokerageTab.getText())){
//           accountActivity.brokerageTab.click();
//       }else if(selectedOption.equals(accountActivity.checkingTab.getText())){
//           accountActivity.checkingTab.click();
//       }else if (selectedOption.equals(accountActivity.creditCardTab.getText())){
//           accountActivity.creditCardTab.click();
//       }else{
//           accountActivity.loanTab.click();
//       }
//       BrowserUtils.waitFor(3);
//
//    }
//
//    @Then("the Account Activity page should be displayed with {string}")
//    public void the_Account_Activity_page_should_be_displayed_with(String expected_message) {
//        BrowserUtils.waitFor(3);
//        String actualTitle = new AccountActivity().showTrans.getText();
//        Assert.assertEquals("Verify header", expected_message,actualTitle);
//    }
//
//    @Then("Account drop down should have {string} selected")
//    public void account_drop_down_should_have_selected(String expectedSelection ) {
//        BrowserUtils.waitFor(3);
//        AccountActivity accountActivity = new AccountActivity();
//        Select dropdown = new Select(accountActivity.dropdownMenu);
//        String actualOption = dropdown.getFirstSelectedOption().getText();
//
//        Assert.assertEquals(expectedSelection,actualOption);
//    }
//    @Then("the Account Activity page should be displayed")
//    public void the_Account_Activity_page_should_be_displayed() {
//        BrowserUtils.waitFor(3);
//        new AccountActivity().accountActivityButton.click();
//
//        String actualTitle = Driver.get().getTitle();
//        Assert.assertEquals("Verify title","Zero - Account Activity",actualTitle);
//    }

}



