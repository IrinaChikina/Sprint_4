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
    ControlStartDriver controlStartDriver = new ControlStartDriver();

    @Before
    public void initDriver() {
        controlStartDriver.initDriver();
        driver = controlStartDriver.getDriver();
    }

    @Test

    public void conversionInStartPage() {

        driver.get(Constants.NOT_BASE_URL);

        Logo logo = new Logo(driver);
        logo.clickLogoScooter();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(Logo.startPageScooter));
        assertTrue(driver.findElement(Logo.startPageScooter).isDisplayed());
    }

    @Test
    public void conversionInYandexPage() {

        driver.get(Constants.BASE_URL);

        Logo logo = new Logo(driver);
        logo.clickLogoYandex();

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String currentUrl = driver.getCurrentUrl();
        assertEquals("Открылась страница отличная от главной страницы Яндекса",Constants.PAGE_YA_RU,currentUrl);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

