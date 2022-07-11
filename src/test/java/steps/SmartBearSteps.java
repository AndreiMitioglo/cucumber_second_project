package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.apache.bcel.generic.Select;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.AddOrderPage;
import pages.LogInPage;
import pages.WebOrdersPage;
import utils.Driver;
import utils.Waiter;

public class SmartBearSteps {

    WebDriver driver;
    LogInPage logInPage;
    WebOrdersPage webOrdersPage;
     AddOrderPage addOrderPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        logInPage = new LogInPage();
        addOrderPage = new AddOrderPage();
        webOrdersPage = new WebOrdersPage();
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
            System.out.println(addOrderPage.webOrders.get(i).getText());
            Assert.assertEquals(addOrderPage.webOrders.get(i).getText(), expected[i]);

        }

    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String checkButton) {
        switch (checkButton){
            case "Check All":
                Waiter.pause(5);
                addOrderPage.checkAllButton.click();
                break;
            case "Uncheck All":
                addOrderPage.uncheckAllButton.click();
                break;
            case "Process":
                addOrderPage.processButton.click();
                break;
            case "Delete Selected":
                addOrderPage.deleteButton.click();
                break;
            default:
                throw new NotFoundException("The check button is not defined properly in the feature file!!!");
        }

    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for (int i=0; i<8; i++){

            Assert.assertTrue(logInPage.allProductChecked.get(i).isEnabled());

        }

    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for (int i=0; i<8; i++){

            Assert.assertFalse(logInPage.allProductChecked.get(i).isSelected());

        }
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String orderLink) {

        switch (orderLink){
            case "Order":
                addOrderPage.orderButton.click();
                break;
            case "View all orders":
                Waiter.pause(5);
                addOrderPage.viewAllOrdersButton.click();
                break;
            default:
                throw new NotFoundException("The order link is not defined properly in the feature file!!!");
        }

    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String productSelect) {
          addOrderPage.productSelect.sendKeys(productSelect);



    }
    @And("user enters {int} as quantity")
    public void userEntersAsQuantity(int quantity) {
        addOrderPage.productQuantity.clear();
        Waiter.pause(3);
        addOrderPage.productQuantity.sendKeys("2");

    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation() {
        addOrderPage.customerName.sendKeys("Andrei Mitioglo");
        addOrderPage.street.sendKeys("1545 W Chase Ave");
        addOrderPage.city.sendKeys("Chicago");
        addOrderPage.state.sendKeys("IL");
        addOrderPage.zip.sendKeys("60626");

    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation() {
        addOrderPage.cardVisa.click();
        addOrderPage.cardNumber.sendKeys("1234567812345");
        addOrderPage.expireDate.sendKeys("06/23");
    }

    @Then("user should see their order displayed in the {string} table")
    public void userShouldSeeTheirOrderDisplayedInTheTable(String listOfOrders) {
       Assert.assertTrue( addOrderPage.listOfOrders.isEnabled());
    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder(DataTable dataTable) {
        for (int i=0; i<dataTable.asList().size(); i++){

            Assert.assertEquals(dataTable.asList().get(i), addOrderPage.table.get(i).getText());

        }


    }

    @Then("validate all orders are deleted from the {string}")
    public void validateAllOrdersAreDeletedFromThe(String listOfAllOrders) {
        Assert.assertTrue(addOrderPage.listOfAllOrdersCheck.isDisplayed());

    }

    @And("validate user sees {string} Message")
    public void validateUserSeesMessage(String message) {
        Assert.assertEquals("List of orders is empty. In order to add new order use this link.",addOrderPage.listOfOrdersMessage.getText());
    }


}
