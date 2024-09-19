
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CheckButtonOrderOnFirstPageTest {
    public WebDriver driver;
   ControlStartDriver controlStartDriver = new ControlStartDriver();

    @Before
 public void initDriver() {
        controlStartDriver.initDriver();
      driver = controlStartDriver.getDriver();
   }

    @Test // Хедер.Проверка кнопки "Заказать"

    public void orderHeader() {
        driver.get(Constants.BASE_URL);

        ButtonOrderOnFirstPage buttonOrder = new ButtonOrderOnFirstPage(driver);
        buttonOrder.clickOrderHeader();
        buttonOrder.openFormOrder();
    }

    @Test // В центре.Проверка кнопки "Заказать"

    public void orderMiddle() {
        driver.get(Constants.BASE_URL);

        ButtonOrderOnFirstPage buttonOrder = new ButtonOrderOnFirstPage(driver);
        buttonOrder.clickOrderMiddle();
        buttonOrder.openFormOrder();
    }

    @After
  public void teardown() {
      driver.quit();
    }
}



