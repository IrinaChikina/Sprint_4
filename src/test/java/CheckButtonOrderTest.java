
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CheckButtonOrderTest {
    private WebDriver driver;
    StartPage startPage = new StartPage();

    @Before
    public void initDriver() {
        startPage.initDriver();
        driver = startPage.getDriver();
    }

    @Test // Хедер.Проверка кнопки "Заказать"

    public void orderHeader() {

        driver.get("https://qa-scooter.praktikum-services.ru/");

        Elements buttonOrder = new Elements(driver);
        buttonOrder.clickOrderHeader();
    }

    @Test // В центре.Проверка кнопки "Заказать"

    public void orderMiddle() {

        driver.get("https://qa-scooter.praktikum-services.ru/");

        Elements buttonOrder = new Elements(driver);
        buttonOrder.clickOrderMiddle();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}



