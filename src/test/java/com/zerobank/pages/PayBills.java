package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PayBills extends BasePage{
    public PayBills(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "h2.board-header")
    public WebElement payBillsHeader;

    @FindBy(linkText = "Pay Bills")
    public WebElement payBills;

    @FindBy(css = "select#sp_payee")
    public WebElement payeeDropdown;

    @FindBy(css = "div#alert_content>span")
    public WebElement payMessage;

    @FindBy(css = "select#sp_account")
    public WebElement accountDropdown;

    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id="sp_date")
    public WebElement date;

    @FindBy(id = "sp_description")
    public WebElement description;

    @FindBy(id="pay_saved_payees")
    public WebElement payButton;
//Add New Payee
    @FindBy(linkText = "Add New Payee")
    public WebElement newPayeeTab;

    @FindBy(id="alert_content")
    public WebElement payeeMessage;

    @FindBy(id="np_new_payee_name")
    public WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddress;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails;

    @FindBy(id="add_new_payee")
    public WebElement addNewPayee;

    //Purchase Foreign Currency
    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignTab;

    @FindBy(id ="pc_currency")
    public WebElement currencyDropdown;

    @FindBy(id ="pc_amount")
    public WebElement currencyAmount;

    @FindBy(id = "pc_calculate_costs")
    public WebElement currencyCalculate;

    @FindBy(id = "pc_inDollars_true")
    public WebElement currencyRadioButton;

    public List<String> getcurrencyDropdown(){
        Select dropdown = new Select(currencyDropdown);
        List<WebElement> dropdownListed = dropdown.getOptions();
        List<String> allOptions = new ArrayList<>();
        for (WebElement option : dropdownListed) {
            allOptions.add(option.getText());
        }
        return allOptions;
    }






}
