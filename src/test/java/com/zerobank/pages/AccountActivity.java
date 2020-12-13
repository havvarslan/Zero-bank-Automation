package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends BasePage {
    public AccountActivity() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "li#account_activity_tab a")
    public WebElement accountActivityButton;

    @FindBy(id = "aa_accountId")
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

    @FindBy(xpath = "(//table)[2]//tbody/tr/td[1]")
    public List<WebElement> tableDates;

    @FindBy(xpath = "(//table)[2]//tbody/tr/td[2]")
    public List<WebElement> tableDescription;

    @FindBy(xpath = "(//table)[2]/tbody//tr/td[3]")
    public List<WebElement> tableDeposits;

    @FindBy(xpath = "(//table)[2]/tbody//tr/td[4]")
    public List<WebElement> tableWithdraw;

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

    public List<String> accountDropdown(){
        Select dropdown = new Select(dropdownMenu);
        List<WebElement> dropdownListed = dropdown.getOptions();
        List<String> allOptions = new ArrayList<>();
        for (WebElement option : dropdownListed) {
            allOptions.add(option.getText());
        }
        System.out.println(allOptions);
        return allOptions;
    }

    public WebElement defaultOption() {
        Select select = new Select(dropdownMenu);
        return select.getFirstSelectedOption();
    }

    public List<Integer> getDaysInteger() {
        List<Integer> dayList = new ArrayList<>();
        for (WebElement tableDate : tableDates) {
            String date = tableDate.getText();
            String[] split = date.split("-");
            dayList.add(Integer.parseInt(split[2]));
        }

        return dayList;
    }

    public int getFromDay(String date){
        String[] splitDate = date.split("-");
        int fromDay = Integer.parseInt(splitDate[2]);
        return fromDay;
    }

    public int getToDay(String to) {

        String[] split = to.split("-");

        int toDay = Integer.parseInt(split[2]);

        return toDay;
    }
    public Select selectType(){
        Select select = new Select(typeOfTransaction);
        return select;
    }

}
