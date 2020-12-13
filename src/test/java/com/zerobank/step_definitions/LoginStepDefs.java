package com.zerobank.step_definitions;

import com.zerobank.pages.Dashboard;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        BrowserUtils.waitFor(3);
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new Dashboard().signinButton.click();
    }


    @When("the user logs in using {string} and {string} in following credentials")
    public void the_user_logs_in_using_and_in_following_credentials(String userType, String password) {
        new LoginPage().login(userType,password);
    }
    @Then("{string} is displayed")
    public void is_displayed(String message) {
        LoginPage loginPage=new LoginPage();
        if(message.equals("Zero - Account Summary")){
            Assert.assertEquals("Verify title", message, Driver.get().getTitle());
        }else
            Assert.assertEquals(message,loginPage.errorMessage.getText());
    }
}