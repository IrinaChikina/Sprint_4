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
        driver.get(Constants.BASE_URL);

       CheckOrderStatus checkOrderStatus = new CheckOrderStatus(driver);
        checkOrderStatus.clickStatusOrder();

        checkOrderStatus.inputFieldNumberOrder("123");
        checkOrderStatus.clickButtonGo();

        checkOrderStatus.foundImgNotFound();
    }

    @After
    public void teardown() {
        driver.quit();
    }
   }


