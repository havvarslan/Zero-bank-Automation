package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(css = "#alert_content>span")
    public WebElement paymentSuccess;



}
