package Practice_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    public static long PAGE_LOAD_TIMEOUT = 40;
    protected WebDriver driverManager;
    public WebDriverWait wait;

   public BasePage(WebDriver driver){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kevin.cascante\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driverManager = driver;
    }

    public void getUrl(String url){
        driverManager.get(url);
    }

    public WebDriver getDriverManager(){
        return driverManager;
    }

    public WebDriverWait getWaitDriver(){
       wait = new WebDriverWait(getDriverManager(), PAGE_LOAD_TIMEOUT);
       return wait;
    }

    public void clickButton(WebElement button){
       button.click();
    }
}
