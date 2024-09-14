import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;

class FormClientData {

    private final WebDriver driver;

    private final By name1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    private final By surname1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    private final By address1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    private final By metro1 = By.className("select-search__value");
    private final By phone1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");

    private final By buttonOnwardsInForm = By.className("Button_Middle__1CSJM");

    private final By deliveryDate = By.className("react-datepicker__input-container");
    private final By period = By.className("Dropdown-control");
    private final By today = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    private final By buttonOrderInForm = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");

    private final By buttonYesConfirmOrder = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

    //Текст ошибки
    protected By errorName = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div");
    protected By errorSurname = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div");
    protected By errorAddress = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/div");
    protected By errorMetro = By.className("Order_MetroError__1BtZb");
    protected By errorPhone = By.xpath("/html/body/div/div/div[2]/div[2]/div[5]/div");

    public FormClientData(WebDriver driver) {
        this.driver = driver;
    }

    public void formClientName(String fieldName) {
        driver.findElement(name1).sendKeys(fieldName);
    }

    public void formClientSurname(String fieldSurname) {
        driver.findElement(surname1).sendKeys(fieldSurname);
    }

    public void formClientAddress(String fieldAddress) {
        driver.findElement(address1).sendKeys(fieldAddress);
    }

    public void formClientPhone(String fieldPhone) {
        driver.findElement(phone1).sendKeys(fieldPhone);
    }

    public void choiceMetro(int id) {
        driver.findElement(metro1).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//li[@data-index='" + id + "']")));
        driver.findElement(By.xpath(".//li[@data-index='" + id + "']")).click();
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

    public void okOrder (){
        driver.findElement(By.className("Order_ModalHeader__3FDaJ"));
    }
}










