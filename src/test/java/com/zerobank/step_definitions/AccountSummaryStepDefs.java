package com.zerobank.step_definitions;

import com.zerobank.pages.Dashboard;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.ZeroAccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {
    @Given("the user logs in")
    public void the_user_logs_in() {
        BrowserUtils.waitFor(3);
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(3);
        new Dashboard().signinButton.click();
        new LoginPage().login2();
    }

    @When("the page have the title |Zero-Account Summary|")
    public void the_page_have_the_title_Zero_Account_Summary() {
        BrowserUtils.waitFor(3);

        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Verify title","Zero - Account Summary",actualTitle);

    }

    @Then("the page should have the following account types")
    public void the_page_should_have_the_following_account_types(List<String> headerList) {
        BrowserUtils.waitFor(2);
        ZeroAccountSummaryPage summaryPage = new ZeroAccountSummaryPage();
        List<String> actualList = BrowserUtils.getElementsText(summaryPage.listOfHeader);

        Assert.assertEquals(headerList,actualList);
        System.out.println("actualOptions = " + actualList);
        System.out.println("menuOptions = " + headerList);

    }

    @Then("Account table columns must have")
    public void account_table_columns_must_have(List<String> tableList) {
     BrowserUtils.waitFor(3);
     ZeroAccountSummaryPage accountsTable = new ZeroAccountSummaryPage();
     List<String> actualListOfTable = BrowserUtils.getElementsText(accountsTable.listOfTable);

     Assert.assertEquals(tableList, actualListOfTable);
        System.out.println("Actual table= "+ actualListOfTable);
        System.out.println("expected table= "+ tableList);

    }

}
