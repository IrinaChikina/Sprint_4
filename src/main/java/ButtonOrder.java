import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class ButtonOrder  {

    private final WebDriver driver;

    private By buttonOrderHeader = By.xpath("//*[@id=\"root\"]//div[2]/button[1]");
    private By buttonOrderMiddle = By.className("Button_Middle__1CSJM");
    private By formScooterFor = By.className("Order_Header__BZXOb");

    String expected = "Для кого самокат";

    public ButtonOrder(WebDriver driver) {
        this.driver = driver;
    }

    public void openFormOrder (){
      String actual = driver.findElement(formScooterFor).getText();
        Assert.assertEquals("Форма для оформления заказа не открывается", expected, actual);
    }

    public void clickOrderHeader() {
        driver.findElement(buttonOrderHeader).click();
    }

    public void clickOrderMiddle() {
        WebElement element = driver.findElement(buttonOrderMiddle);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(buttonOrderMiddle).click();
    }
}



