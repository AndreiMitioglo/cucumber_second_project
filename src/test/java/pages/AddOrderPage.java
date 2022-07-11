package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class AddOrderPage {
    public AddOrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "#ctl00_menu li:nth-child(3) a")
    public WebElement orderButton;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productSelect;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement productQuantity;


    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerName;



    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement street;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement city;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement state;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zip;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement cardVisa;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expireDate;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy(css = "#ctl00_menu li:nth-child(1) a")
    public WebElement viewAllOrdersButton;

    @FindBy(css = ".content")
    public WebElement listOfAllOrdersCheck;

    @FindBy(xpath = "//h2")
    public WebElement listOfOrders;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteButton;


    @FindBy(css = "#ctl00_MainContent_orderMessage")
    public WebElement listOfOrdersMessage;


    @FindBy(css = "#ctl00_menu li")
    public List<WebElement> webOrders;


    @FindBy(css = "#ctl00_MainContent_btnCheckAll")
    public WebElement checkAllButton;



    @FindBy(css = "#ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAllButton;



    @FindBy(xpath = "//table[@class=\"SampleTable\"]//tr[2]//td[2]")
    public List<WebElement> table; // css = "table[class="SampleTable"] tr:nth-child(2) td:nth-child(2)"
}
