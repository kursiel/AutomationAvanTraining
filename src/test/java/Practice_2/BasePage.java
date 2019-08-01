package Practice_2;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    private WebDriver driverManager;

    protected BasePage(WebDriver driver){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kevin.cascante\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driverManager = driver;
    }

}
