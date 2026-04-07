package bases;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected static Dotenv dotenv = Dotenv.load();


    // method untuk inisialisasi WebDriver
    protected void getDriver() {
        String url = dotenv.get("BASE_URL");
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
