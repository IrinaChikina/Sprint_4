import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logo {
    private final WebDriver driver;

    private static By logoScooter = By.cssSelector("img[alt = 'Scooter']");//попадёшь на главную страницу «Самоката».
    private static By logoYandex = By.cssSelector("img[alt = 'Yandex']"); //в новом окне откроется главная страница Яндекса.
    public static By startPageScooter = By.className("Home_FirstPart__3g6vG");

    public Logo(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoScooter (){
        driver.findElement(logoScooter).click();
    }

    public void clickLogoYandex (){
        driver.findElement(logoYandex).click();
    }
}
