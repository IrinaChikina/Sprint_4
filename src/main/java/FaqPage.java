import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FaqPage {
   public WebDriver driver;

    public FaqPage (WebDriver driver) {
        this.driver = driver;
    }

        public By indAccordionHeading(int id){
            return By.xpath("//*[@id=\"accordion__heading-" + id + "\"]");
        }

        public By indAccordionPanel(int id) {
        return By.xpath("//*[@id=\"accordion__panel-" + id + "\"]/p");
        }

}



