import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

public class ControlStartDriver {
    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

        public void initDriver () {
            if ("firefox".equals(System.getProperty("browser"))) {
                startFirefox();
            } else {
                startChrome();
            }
        }

        public void startChrome () {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }

        public void startFirefox () {
            WebDriverManager.firefoxdriver().setup();
            var opts = new FirefoxOptions()
                    .configureFromEnv();
            driver = new FirefoxDriver(opts);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
}



