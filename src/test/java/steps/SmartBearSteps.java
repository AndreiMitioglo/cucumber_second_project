package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.LogInPage;
import pages.WebOrdersPage;
import utils.Driver;
import utils.Waiter;

public class SmartBearSteps {

    WebDriver driver;
    LogInPage logInPage;
    WebOrdersPage webOrdersPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        logInPage = new LogInPage();
    }
    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);

    }

    @When("user enters username as {string}")
    public void userEntersUsernameAs(String userName) {
        switch (userName){
            case "abcd":
            case "Tester":
                logInPage.userName.sendKeys(userName);
                break;
            default:
                throw new NotFoundException("The enter user name text is not defined properly in the feature file!!!");
        }


    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String password) {
        switch (password){
            case "abcd1234":
            case "test":
                logInPage.password.sendKeys(password);
                break;
            default:
                throw new NotFoundException("The entered password is not defined properly in the feature file!!!");
        }

    }



    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        logInPage.logInButton.click();
    }

    @Then("user should see {string} Message")
    public void userShouldSeeMessage(String message) {
        Assert.assertEquals("Invalid Login or Password.", logInPage.invalidMessage.getText());
    }

    @Then("user should be routed to {string}")
    public void userShouldBeRoutedTo(String expectedLink) {
Assert.assertEquals("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/", driver.getCurrentUrl());
    }

    @And("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed() {
        String[] expected = {"View all orders","View all products", "Order"};
        for (int i=0; i<3; i++){
            System.out.println(webOrdersPage.webOrders.get(i).getText());
            Assert.assertEquals(webOrdersPage.webOrders.get(i).getText(), expected[i]);

        }

    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String checkAllButton) {

    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
    }
}
