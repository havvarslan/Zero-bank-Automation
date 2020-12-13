package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigation {
    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String selectedOption) {
        BrowserUtils.waitFor(3);
       AccountActivity accountActivity = new AccountActivity();

       if(selectedOption.equals(accountActivity.savingsTab.getText())){
           accountActivity.savingsTab.click();
       }else if(selectedOption.equals(accountActivity.brokerageTab.getText())){
           accountActivity.brokerageTab.click();
       }else if(selectedOption.equals(accountActivity.checkingTab.getText())){
           accountActivity.checkingTab.click();
       }else if (selectedOption.equals(accountActivity.creditCardTab.getText())){
           accountActivity.creditCardTab.click();
       }else{
          accountActivity.loanTab.click();
       }
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Zero - Account Activity";
        Assert.assertEquals("Verify header", expectedTitle,actualTitle);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedSelection) {
        BrowserUtils.waitFor(3);
        String actualOption = new AccountActivity().defaultOption().getText();
        Assert.assertEquals(expectedSelection,actualOption);
    }
}
