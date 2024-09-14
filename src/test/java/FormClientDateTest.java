import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FormClientDateTest {
    private WebDriver driver;
    StartPage startPage = new StartPage();

    @Before
    public void initDriver() {
        startPage.initDriver();
        driver = startPage.getDriver();
    }

    @Test

    public void order1ScooterTest() {

        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.findElement(By.id("rcc-confirm-button")).click(); //Закрытие сообщения Куки

        Elements buttonOrder = new Elements(driver);
        buttonOrder.clickOrderHeader();

        FormClientData formClientData = new FormClientData(driver);
        // formClientData.formClientName("Ирина");
        formClientData.enterDataClientInForm("Ирина", "Иванова", "Москва,Мира,1", 7, "89992223344");

        formClientData.clickButtonOnwards();
        formClientData.enterDataOrderInForm();

        formClientData.clickButtonOrder();

        formClientData.confirmOrder();
    }


    @Test

    public void order2ScooterTest() {

        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.findElement(By.id("rcc-confirm-button")).click(); //Закрытие сообщения Куки

        Elements buttonOrder = new Elements(driver);
        buttonOrder.clickOrderHeader();

        FormClientData formClientData = new FormClientData(driver);

        formClientData.enterDataClientInForm("Иван", "Петров", "Советская, 28", 18, "+73334445566");

        formClientData.clickButtonOnwards();

        formClientData.enterDataOrderInForm();

        formClientData.clickButtonOrder();

        formClientData.confirmOrder();
        formClientData.okOrder();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}







