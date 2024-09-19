import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import static org.hamcrest.CoreMatchers.containsString;

class FormClientData {

    private final WebDriver driver;

    private final By cookieButton = By.id("rcc-confirm-button");
    private final By name = By.xpath("//input[@placeholder='* Имя']");
    private final By surname = By.xpath("//input[@placeholder='* Фамилия']");;
    private final By address = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metro = By.className("select-search__value");
    private final By phone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    private final By buttonOnwardsInForm = By.className("Button_Middle__1CSJM");

    private final By deliveryDate = By.className("react-datepicker__input-container");
    private final By period = By.className("Dropdown-control");
    private final By today = By.xpath("//div[@class='Dropdown-menu']/div[text()='сутки']");
    private final By buttonOrderInForm = By.xpath("//*[@id=\"root\"]//div[3]/button[2]");

    private final By buttonYesConfirmOrder = By.cssSelector("div.Order_Modal__YZ-d3 > div.Order_Buttons__1xGrp > button:nth-child(2)");
    private final By okButton = By.className("Order_ModalHeader__3FDaJ");
    private final By bookingScooter = By.xpath("//div[2]/div[5]/div[1]");

    //Текст ошибки
    protected By errorName = By.xpath("//div[2]/div[1]/div");
    protected By errorSurname = By.cssSelector("div.Order_Form__17u6u > div:nth-child(2) > div");
    protected By errorAddress = By.xpath("//div[2]/div[3]/div");
    protected By errorMetro = By.className("Order_MetroError__1BtZb");
    protected By errorPhone =By.xpath("//div[2]/div[2]/div[5]/div");

    public FormClientData(WebDriver driver) {
        this.driver = driver;
    }

    public void closeCookieMessage (){
        driver.findElement(cookieButton).click();
    }

    public void formClientName(String fieldName) {
        driver.findElement(name).sendKeys(fieldName);
    }

    public void formClientSurname(String fieldSurname) {
        driver.findElement(surname).sendKeys(fieldSurname);
    }

    public void formClientAddress(String fieldAddress) {
        driver.findElement(address).sendKeys(fieldAddress);
    }

    public void formClientPhone(String fieldPhone) {
        driver.findElement(phone).sendKeys(fieldPhone);
    }

    public void choiceMetro(int id) {

        By indexMetro = By.xpath(".//li[@data-index='" + id + "']");

        driver.findElement(metro).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.visibilityOfElementLocated(indexMetro));
        driver.findElement(indexMetro).click();
    }

    public void enterDataClientInForm(String fieldName, String fieldSurname, String fieldAddress, int id, String fieldPhone) {
        formClientName(fieldName);
        formClientSurname(fieldSurname);
        formClientAddress(fieldAddress);
        choiceMetro(id);
        formClientPhone(fieldPhone);
    }

    public void enterDataClientInFormNoMetro(String fieldName, String fieldSurname, String fieldAddress, String fieldPhone) {
        formClientName(fieldName);
        formClientSurname(fieldSurname);
        formClientAddress(fieldAddress);
        formClientPhone(fieldPhone);
    }
    public void clickButtonOnwards() {
        driver.findElement(buttonOnwardsInForm).click();
    }

    public void formOrderDate() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(deliveryDate));

        driver.findElement(deliveryDate).click();
    }

    public void choiceDayInCalendar (){
        LocalDate currentDate = LocalDate.now();
        int date = currentDate.getDayOfMonth();
        if (date < 10) {
            driver.findElement(By.className("react-datepicker__day--00" + date)).click();
        } else {
            driver.findElement(By.className("react-datepicker__day--0" + date)).click();
        }
    }

    public void formOrderPeriod () {
        driver.findElement(period).click();
        driver.findElement(today).click();
    }

    public void enterDataOrderInForm (){
        formOrderDate();
        choiceDayInCalendar();
        formOrderPeriod();
    }

    public void clickButtonOrder (){
        driver.findElement(buttonOrderInForm).click();
    }

    public void confirmOrder (){
        driver.findElement(buttonYesConfirmOrder).click();
    }

    public void okOrder () {
        driver.findElement(okButton).click();
    }

    public void foundBookingOrder () {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(bookingScooter));
        String booking = driver.findElement(bookingScooter).getText();
        String expectedText = "Заказ оформлен";
        MatcherAssert.assertThat("Оформление заказа не подтверждено",booking,containsString(expectedText));
    }
}










