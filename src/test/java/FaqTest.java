import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)

public class FaqTest {

    private WebDriver driver;
    private final int id;
    private final String textAnswer;

    public FaqTest(int id, String textAnswer) {
        this.id = id;
        this.textAnswer = textAnswer;
    }
    private By cookieButton = By.id("rcc-confirm-button");

    @Parameterized.Parameters (name = "id accordion {0}, answer {1} " )
    public static Object[][] getTextAnswer() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3,"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4,"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5,"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6,"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7,"Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }


    @Before
    public void initDriver() {
        StartPage startPage = new StartPage();
        startPage.initDriver();
        driver = startPage.getDriver();
    }

    @Test

    public void responseTextTest() {

        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.findElement(cookieButton).click(); // закрыть куки

        WebElement element = driver.findElement(By.xpath("//*[@id=\"accordion__heading-" + id + "\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element); // скрол до вопроса fiq

        driver.findElement(By.xpath("//*[@id=\"accordion__heading-" + id + "\"]")).click(); // клик на вопрос

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"accordion__panel-" + id + "\"]/p")));

        String text = (driver.findElement(By.xpath("//*[@id=\"accordion__panel-" + id + "\"]/p")).getText());  // получение текста ответа
        assertEquals(text, textAnswer);
    }
    @After
    public void teardown() {
        driver.quit();
    }
}







