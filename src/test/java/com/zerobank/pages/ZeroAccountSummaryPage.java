package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ZeroAccountSummaryPage extends BasePage {
    public ZeroAccountSummaryPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "h2.board-header")
    public List<WebElement> listOfHeader;
    @FindBy(xpath = "//div[3]/div/table/thead/tr/th")
    public List<WebElement> listOfTable;

    @FindBy(xpath = "//*[@class='board-header'][1]")
    public WebElement cashAccount;

    @FindBy(xpath = "//*[@class='board-header'][2]")
    public WebElement investmentAccount;

    @FindBy(xpath = "//*[@class='board-header'][3]")
    public WebElement creditAccount;

    @FindBy(xpath = "//*[@class='board-header'][4]")
    public WebElement loanAccount;

}
