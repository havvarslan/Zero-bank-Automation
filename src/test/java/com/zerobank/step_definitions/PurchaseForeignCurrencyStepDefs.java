package com.zerobank.step_definitions;

import com.zerobank.pages.PayBills;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {
    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        BrowserUtils.waitFor(2);
        new PayBills().purchaseForeignTab.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrencyList) {
        BrowserUtils.waitFor(2);
        List<String> actualCurrencyList = new PayBills().getcurrencyDropdown();
        Assert.assertEquals("Verify currency dropdown", expectedCurrencyList, actualCurrencyList);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        BrowserUtils.waitFor(2);
        PayBills payBills = new PayBills();
        payBills.currencyAmount.sendKeys("2000");
        payBills.currencyCalculate.click();
    }


    @When("user tries to calculate cost without entering value")
    public void user_tries_to_calculate_cost_without_entering_value() {
        BrowserUtils.waitFor(2);
        new PayBills().currencyRadioButton.click();
        new PayBills().currencyCalculate.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        BrowserUtils.waitFor(2);
        Alert alert = Driver.get().switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals("Verify alert", "Please, ensure that you have filled all the required fields with valid values.", alert.getText());
        alert.accept();
    }



}
