package pages;

import bases.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
    private final WebDriver driver;

    private final By btnLoginMenu = By.id("login2");
    private final By inputUsername = By.id("loginusername");
    private final By inputPassword = By.id("loginpassword");
    private final By btnLogin = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    private final By welcomeText = By.id("nameofuser");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin() {
        click(btnLoginMenu);

    }

    public void loginWithEnvData(String user, String pass) {
        type(inputUsername, user);
        type(inputPassword, pass);
        System.out.println("DEBUG: Mengetik username dan password...");
    }

    public void clickLoginButton() {
        click(btnLogin);

    }

    public String getWelcomeText() {
        return getText(welcomeText);
    }
}
