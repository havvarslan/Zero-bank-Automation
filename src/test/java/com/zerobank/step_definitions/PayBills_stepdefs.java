package com.zerobank.step_definitions;

import com.zerobank.pages.PayBills;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PayBills_stepdefs {
    @Given("the user should be in Pay Bills Page")
    public void the_user_should_be_in_Pay_Bills_Page() {
        new PayBills().payBills.click();
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String string) {
        String actualTitle =   Driver.get().getTitle();
//        Assert.assertEquals("Verify title",expectedTitle,actualTitle);
    }


    @Then("the user should be able to complete pay operation succesfully with {string} {string} {string}")
    public void the_user_should_be_able_to_complete_pay_operation_succesfully_with(String amount, String date, String description) {
        PayBills payBillsPage = new PayBills();
        payBillsPage.amount.sendKeys(amount);
        payBillsPage.date.sendKeys(date);
        payBillsPage.description.sendKeys(description);
        payBillsPage.payButton.click();
        System.out.println("payBillsPage.payMessage.getText() = " + payBillsPage.payMessage.getText());
        Assert.assertTrue("verify the pay operation message is displayed", payBillsPage.payMessage.isDisplayed());
    }

    @Then("the user should receive an message {string} {string}")
    public void the_user_should_receive_an_message(String amount, String date) {
        PayBills payBillsPage = new PayBills();

        payBillsPage.amount.sendKeys(amount);
        payBillsPage.date.sendKeys(date);
        payBillsPage.payButton.click();
        String actualMessage = "";
        if (amount.isEmpty()) {
            actualMessage = Driver.get().findElement(By.cssSelector("input[name='amount']")).getAttribute("validationMessage");
        } else if (date.isEmpty()) {
            actualMessage = Driver.get().findElement(By.cssSelector("input[name='date']")).getAttribute("validationMessage");
        }

        System.out.println("actualMessage = " + actualMessage);
        String expectedMessage = "Please fill out this field.";

        Assert.assertEquals("verify the recieved message", expectedMessage, actualMessage);

        System.out.println("Please fill out message: "+ actualMessage);
    }

    @Then("the system not allow to enter invalid characters {string} {string}")
    public void the_system_not_allow_to_enter_invalid_characters(String amount, String date) {
        PayBills payBillsPage = new PayBills();

        payBillsPage.amount.sendKeys(amount);
        payBillsPage.date.sendKeys(date);
        payBillsPage.payButton.click();

        Assert.assertTrue("verify the pay operation message is displayed", payBillsPage.payMessage.isDisplayed());


    }

}
