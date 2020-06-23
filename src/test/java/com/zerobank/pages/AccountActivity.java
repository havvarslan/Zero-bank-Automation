package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivity extends BasePage {
    public AccountActivity() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "li#account_activity_tab a")
    public WebElement accountActivityButton;

    @FindBy(css = "select#aa_accountId")
    public WebElement dropdownMenu;

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> tableColumn;

    @FindBy(linkText = "Show Transactions")
    public WebElement showTrans;

    @FindBy(linkText = "Savings")
    public WebElement savingsTab;

    @FindBy(linkText = "Brokerage")
    public WebElement brokerageTab;

    @FindBy(linkText = "Checking")
    public WebElement checkingTab;

    @FindBy(linkText = "Credit Card")
    public WebElement creditCardTab;

    @FindBy(linkText = "Loan")
    public WebElement loanTab;
//Find Transaction Part
    @FindBy(xpath = "//*[@id='tabs']/ul/li[2]/a")
    public WebElement findTransactions;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id="aa_toDate")
    public WebElement toDate;

    @FindBy(css = ".btn.btn-primary")
    public WebElement findButton;

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(id = "aa_type")
    public WebElement typeOfTransaction;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr[1]/td[1]")
    public WebElement searchLastDate;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr[3]/td[1]")
    public WebElement searchFirstDate;

    @FindBy(css = "div.well")
    public WebElement noResult;




}
