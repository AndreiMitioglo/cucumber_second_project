package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class WebOrdersPage {
    public WebOrdersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
        @FindBy(css = "#ctl00_menu li")
        public List<WebElement> webOrders;


    @FindBy(css = "#ctl00_MainContent_btnCheckAll")
    public WebElement checkAllButton;



    @FindBy(css = "#ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAllButton;


}
