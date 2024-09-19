import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)

public class FormClientDateTest {
    private WebDriver driver;
    public final String name;
    public final String surname;
    public final String address;
    public final int indMetro;
    public final String phone;

    public FormClientDateTest (String name, String surname, String address, int indMetro, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.indMetro = indMetro;
        this.phone = phone;
    }

    @Parameterized.Parameters(name = "id accordion {0}, answer {1} ")
    public static Object[][] getTextAnswer() {
        return new Object[][]{
                {"Ирина", "Иванова", "Москва,Мира,1", 7, "89992223344"},
                {"Иван", "Петров", "Советская, 28", 18, "+73334445566"}
        };
    }

    @Before
    public void initDriver() {
        ControlStartDriver controlStartDriver = new ControlStartDriver();
        controlStartDriver.initDriver();
        driver = controlStartDriver.getDriver();
    }

    @Test

    public void orderScooterSheSmashTest() {
        driver.get(Constants.BASE_URL);

        ButtonOrderOnFirstPage buttonOrder = new ButtonOrderOnFirstPage(driver);
        buttonOrder.clickOrderHeader();

        FormClientData formClientData = new FormClientData(driver);
        formClientData.closeCookieMessage();

        formClientData.enterDataClientInForm(name,surname,address,indMetro,phone);

        formClientData.clickButtonOnwards();
        formClientData.enterDataOrderInForm();

        formClientData.clickButtonOrder();

        formClientData.confirmOrder();
        formClientData.okOrder();
        formClientData.foundBookingOrder();
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
