//package com.zerobank.step_definitions;
//
//import com.zerobank.pages.PayBills;
//import com.zerobank.utilities.BrowserUtils;
//import com.zerobank.utilities.Driver;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.support.ui.Select;
//
//public class PayBillsStepDefs {
//    @When("user should be on the {string} page")
//    public void user_should_be_on_the_page(String pageName) {
//        BrowserUtils.waitFor(3);
//        PayBills payBills = new PayBills();
//        payBills.payBills.click();
//        String actualPageName = payBills.payBills.getText();
//        Assert.assertEquals("verify page name", pageName, actualPageName);
//
//    }
//
//    @Then("the title should be {string}")
//    public void the_title_should_be(String expectedTitle) {
//        String actualTitle =   Driver.get().getTitle();
//        Assert.assertEquals("Verify title",expectedTitle,actualTitle);
//    }
//
//    @When("the user submits a payment operation with entering the {string}, {string}, {string}, {string}, {string}")
//    public void the_user_submits_a_payment_operation_with_entering_the(String payee,
//                                                                       String account,
//                                                                       String amount,
//                                                                       String date,
//                                                                       String description) {
//      PayBills payBills = new PayBills();
//        Select payeeDrop = new Select(payBills.payeeDropdown);
//        payeeDrop.selectByIndex(3);
//
//        Select accountDrop = new Select(payBills.accountDropdown);
//        accountDrop.selectByVisibleText("Loan");
//
//        payBills.amount.sendKeys(amount);
//        payBills.date.sendKeys(date);
//        payBills.description.sendKeys(description);
//        payBills.payButton.sendKeys(Keys.ENTER);
//
//    }
//
//    @Then("the message {string} should be displayed")
//    public void the_message_should_be_displayed(String expected_message) {
//       BrowserUtils.waitFor(3);
//       PayBills payBills = new PayBills();
//       if(expected_message.equals(payBills.paymentSuccess.getText())){
//           Assert.assertEquals("verify success", expected_message,payBills.paymentSuccess.getText());
//       }else{
//           JavascriptExecutor js = (JavascriptExecutor) Driver.get();
//           Boolean is_valid = (Boolean) js.executeScript("return arguments[0].checkValidity();", payBills.amount);
//           String message = (String) js.executeScript("return arguments[0].validationMessage;", payBills.amount);
//           // String message = payBillsPage.date.getAttribute("validationMessage");
//           System.out.println(message);
//           Assert.assertEquals("Verify message",expected_message, message);
//       }
//
//
//    }
//
//
//
//    @When("user submits a payment with alphabetical or special characters in the {string}")
//    public void user_submits_a_payment_with_alphabetical_or_special_characters_in_the(String string) {
//
//    }
//
//    @When("user submits a payment with alphabetical characters in the {string}")
//    public void user_submits_a_payment_with_alphabetical_characters_in_the(String string) {
//
//    }
//
//    @Then("the message {string} should not be displayed")
//    public void the_message_should_not_be_displayed(String string) {
//
//    }
//
//}
