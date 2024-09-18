import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class ErrorFormOrderTest {

    public static WebDriver driver;
    private final By field;
    private final String textError;

    public ErrorFormOrderTest(By field, String textError) {
        this.field = field;
        this.textError = textError;
    }

    @Parameterized.Parameters(name = "field {0}, textError {1} ")
    public static Object[][] getTextError() {

        FormClientData formClientData = new FormClientData(driver);

        return new Object[][]{
                {formClientData.errorName, "Введите корректное имя"},
                {formClientData.errorSurname, "Введите корректную фамилию"},
                {formClientData.errorAddress, "Введите корректный адрес"},
                {formClientData.errorMetro, "Выберите станцию"},
                {formClientData.errorPhone, "Введите корректный номер"},
        };
    }

    @Before
    public void initDriver() {
        StartPage startPage = new StartPage();
        startPage.initDriver();
        driver = startPage.getDriver();
        driver.get(Constants.BASE_URL);
        startPage.closeCookieMessage();
    }

    @Test

    public void checkErrorForEmpty() {
        ButtonOrder buttonOrder = new ButtonOrder(driver);
        buttonOrder.clickOrderHeader();

        FormClientData formClientData = new FormClientData(driver);
        formClientData.clickButtonOnwards();

        String textErrorActual = driver.findElement(field).getText();
        assertEquals(textError, textErrorActual);
    }

    @Test

    public void checkErrorForInputLatin() {
        ButtonOrder buttonOrder = new ButtonOrder(driver);
        buttonOrder.clickOrderHeader();

        FormClientData formClientData = new FormClientData(driver);

        formClientData.enterDataClientInFormNoMetro("Ivan", "Ivanov", "Pushkina,123", "9998887788");

        formClientData.clickButtonOnwards();

        String textErrorActual = driver.findElement(field).getText();
        assertEquals(textError, textErrorActual);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
