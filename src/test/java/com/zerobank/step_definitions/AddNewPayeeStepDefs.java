package com.zerobank.step_definitions;

import com.zerobank.pages.PayBills;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {
    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        BrowserUtils.waitFor(2);
        new PayBills().newPayeeTab.click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> payeeInfo) {
        BrowserUtils.waitFor(2);
        PayBills payBills = new PayBills();
        payBills.payeeName.sendKeys(payeeInfo.get("Payee Name"));
        payBills.payeeAddress.sendKeys(payeeInfo.get("Payee Address"));
        payBills.payeeAccount.sendKeys(payeeInfo.get("Account"));
        payBills.payeeDetails.sendKeys(payeeInfo.get("Payee details"));
        payBills.addNewPayee.click();
    }

    @Then("message {string}, should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
       String actualMessage = new PayBills().payeeMessage.getText();
       Assert.assertEquals("Verify payee message", expectedMessage,actualMessage);
    }


}
