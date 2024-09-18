
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class CheckButtonOrderTest  {
    public WebDriver driver;
   StartPage startPage = new StartPage();

    @Before
 public void initDriver() {
        startPage.initDriver();
      driver = startPage.getDriver();
      driver.get(Constants.BASE_URL);
   }

    @Test // Хедер.Проверка кнопки "Заказать"

    public void orderHeader() {

        ButtonOrder buttonOrder = new ButtonOrder(driver);
        buttonOrder.clickOrderHeader();
        buttonOrder.openFormOrder();
    }

    @Test // В центре.Проверка кнопки "Заказать"

    public void orderMiddle() {
        ButtonOrder buttonOrder = new ButtonOrder(driver);
        buttonOrder.clickOrderMiddle();
        buttonOrder.openFormOrder();
    }

    @After
  public void teardown() {
      driver.quit();
    }
}



