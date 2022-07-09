package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class LogInPage {
  public LogInPage(){
      PageFactory.initElements(Driver.getDriver(), this);
  }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement userName;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement password;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement logInButton;

    @FindBy(id = "ctl00_MainContent_status")
    public WebElement invalidMessage;



  @FindBy(id = "")
  public WebElement viewAllProducts;

  @FindBy(id = "")
  public WebElement orders;

}
