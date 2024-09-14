import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class OrderStatusTest {
    private WebDriver driver;
    StartPage startPage = new StartPage();

    @Before
    public void initDriver() {
        startPage.initDriver();
        driver = startPage.getDriver();
    }

    @Test
    public void notExistsNumberTest (){
        driver.get("https://qa-scooter.praktikum-services.ru/");

        Elements buttonOrder = new Elements(driver);
        buttonOrder.clickStatusOrder();

        buttonOrder.inputFieldNumberOrder("123");
        buttonOrder.clickButtonGo();

        buttonOrder.foundImgNotFound();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

