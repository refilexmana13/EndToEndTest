package bases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriverWait getWait() {
        return new WebDriverWait(BaseTest.driver, Duration.ofSeconds(20));
    }

    protected void click(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String text) {
        WebElement element = getWait().until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        BaseTest.driver.switchTo().alert().accept();
    }
}
