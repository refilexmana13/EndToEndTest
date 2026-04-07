package stepdefs;

import bases.BaseTest;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.E2ePage;
import pages.LoginPage;

import java.time.Duration;

public class DemoBlazeStepDef extends BaseTest {
    protected LoginPage loginPage;
    protected E2ePage e2ePage;

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        if (driver == null) {
            getDriver();
        }
        loginPage = new LoginPage(driver);
        System.out.println("Memulai tes login...");
        Assert.assertNotNull("Driver tidak ditemukan!", driver);
    }

    @And("I click the login link")
    public void iClickTheLoginLink() {
        loginPage.clickLogin();
    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
        String username = dotenv.get("USER_NAME");
        String password = dotenv.get("PASSWORD");

        loginPage.loginWithEnvData(username, password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see text {string}")
    public void iShouldSeeText(String welcomeText) {
        String actualText = loginPage.getWelcomeText();
        Assert.assertEquals("Login gagal, teks tidak sesuai!", welcomeText, actualText);
    }

    @And("I login with valid credentials")
    public void iLoginWithValidCredentials() {
        e2ePage = new E2ePage(driver);
        loginPage.clickLogin();
        String username = dotenv.get("USER_NAME");
        String password = dotenv.get("PASSWORD");
        loginPage.loginWithEnvData(username, password);
        loginPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nameofuser\"]")));
        System.out.println("Debug: Proses login otomatis dijalankan dalam satu langkah.");
    }

    @And("I select the {string} product")
    public void iSelectTheProduct(String SamsungGalaxyS6) {
        e2ePage.clickProduct();
    }

    @And("I click the Add to cart button")
    public void IClickTheAddToCartButton() {
        e2ePage.clickAddToCart();
    }

    @And("I accept the alert")
    public void iAcceptTheAlert() {

    }

    @And("I click on the Cart link")
    public void iClickOnTheCartLink() {
        e2ePage.clickCart();
    }

    @And("I click the Place Order button")
    public void iClickThePlaceOrderButton() {
        e2ePage.clickPlaceOrder();
    }


    @And("I fill in the order form with valid details")
    public void iFillInTheOrderFormWithValidDetails() {
       String name = dotenv.get("INPUT_NAME");
       String country = dotenv.get("INPUT_COUNTRY");
       String city = dotenv.get("INPUT_CITY");
       String card = dotenv.get("INPUT_CREDIT_CARD");
       String month = dotenv.get("INPUT_MONTH");
       String year = dotenv.get("INPUT_YEAR");
       e2ePage.inputData(name, country, city, card, month, year);
    }

    @And("I click the Purchase button")
    public void iClickThePurchaseButton() {
        e2ePage.clickPurchase();
    }

    @Then("I should see a confirmation message with order details")
    public void iShouldSeeAConfirmationMessageWithOrderDetails() {
    }

    @And("I click the {string} button on the confirmation dialog")
    public void iClickTheButtonOnTheConfirmationDialog(String arg0) {
        e2ePage.clickOk();
    }

}
