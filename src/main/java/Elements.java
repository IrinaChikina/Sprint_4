import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;


class Elements {

    private final WebDriver driver;

    private By buttonOrderHeader = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");
    private By buttonOrderMiddle = By.className("Button_Middle__1CSJM");
    private By buttonStatusOrder = By.className("Header_Link__1TAG7");
    private By fieldInputNomberOrder = By.className("Input_Input__1iN_Z");
    private By buttonGo = By.className("Header_Button__28dPO");
    private By imgNotFound = By.cssSelector("img[alt='Not found']");

    public Elements(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderHeader() {
        driver.findElement(buttonOrderHeader).click();
    }

    public void clickOrderMiddle() {
        WebElement element = driver.findElement(By.className("Button_Middle__1CSJM"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(buttonOrderMiddle).click();
    }

    public void clickStatusOrder() {
        driver.findElement(buttonStatusOrder).click();
    }

    public void inputFieldNumberOrder (String fieldNumberOrder){
        driver.findElement(fieldInputNomberOrder).sendKeys(fieldNumberOrder);
    }
    public void clickButtonGo() {
        driver.findElement(buttonGo).click();
    }

    public void foundImgNotFound () {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(imgNotFound));

        assertTrue(driver.findElement(imgNotFound).isDisplayed());
    }
}



