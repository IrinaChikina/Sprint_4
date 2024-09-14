import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogoTest {
    private WebDriver driver;
    StartPage startPage = new StartPage();

    @Before
    public void initDriver() {
        startPage.initDriver();
        driver = startPage.getDriver();
    }

    @Test

    public void conversionInStartPage() {

        driver.get("https://qa-scooter.praktikum-services.ru/order");

        Logo logo = new Logo(driver);
        logo.clickLogoScooter();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(Logo.startPageScooter));
        assertTrue(driver.findElement(Logo.startPageScooter).isDisplayed());
    }

    @Test
    public void conversionInYandexPage() {

        driver.get("https://qa-scooter.praktikum-services.ru");

        Logo logo = new Logo(driver);
        logo.clickLogoYandex();

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String currentUrl = driver.getCurrentUrl();
        assertEquals("Открылась страница отличная от главной страницы Яндекса","https://ya.ru",currentUrl);
    }


    @After
    public void teardown() {
        driver.quit();
    }
}

