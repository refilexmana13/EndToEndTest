package pages;

import bases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class E2ePage extends BasePage {
    private final WebDriver driver;

    private final By clickProduct = By.xpath("//*[@id=\"tbodyid\"]/div[4]/div/a/img");
    private final By clickAddToCart = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    private final By clickCart = By.xpath("//*[@id=\"cartur\"]");
    private final By clickPlaceOrder = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    private final By inputName = By.id("name");
    private final By inputCountry = By.id("country");
    private final By inputCity = By.id("city");
    private final By inputCard = By.id("card");
    private final By inputMonth = By.id("month");
    private final By inputYear = By.id("year");
    private final By clickPurchase = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    private final By clickOk = By.xpath("/html/body/div[10]/div[7]/div/button");

    public E2ePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProduct() {
        click(clickProduct);
    }

    public void clickAddToCart() {
        click(clickAddToCart);
        acceptAlert();
    }

    public void clickCart() {
        click(clickCart);
    }

    public void clickPlaceOrder() {
        click(clickPlaceOrder);
    }

    public void inputData(String name, String country, String city, String card, String month, String year) {
        type(inputName, name);
        type(inputCountry, country);
        type(inputCity, city);
        type(inputCard, card);
        type(inputMonth, month);
        type(inputYear, year);
        System.out.println("Debug: mengisi form pembelian dengan data yang diberikan.");
    }

    public void clickPurchase() {
        click(clickPurchase);
    }

    public void clickOk() {
        click(clickOk);
    }

}
