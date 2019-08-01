package Practice_2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.*;
import org.testng.annotations.Test;
import com.page.object.LoginObject;
import java.util.ArrayList;
import java.util.List;

public class RegisterTests {

    public static long PAGE_LOAD_TIMEOUT = 40;
    LoginObject driver;

    public RegisterTests(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Candelito19\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new LoginObject(new ChromeDriver());
    }

    @Test
    public void ValidateCorrectLoadPage(){

        WebDriverWait wait = new WebDriverWait(driver.getMyDriver(), PAGE_LOAD_TIMEOUT);
        driver.getUrl("http://qa-trainingw7:86/");
        WebElement registerLink = driver.getMyDriver().findElement(By.xpath("//a[@id='ctl00_LoginView_RegisterLink']"));
        registerLink.click();

        wait.until(WebDriver -> ((JavascriptExecutor)WebDriver).executeScript("return document.readyState")).equals("complete");
    }


    @Test
    public void ValidateErrMsgRegisterForm(){

        driver.getUrl("http://qa-trainingw7:86/");
        //driver.getWebElementFactory("//a[@id='ctl00_LoginView_RegisterLink']").click();
        driver.clickOnRegisterLink();
        driver.getWebElementFactory("//input[contains(@name,'ctl00$Main$CreateUserWizardControl$_')]").click();

        ArrayList<String> requireMsg = new ArrayList<String>();

        for(int i = 1; i <= 7; i++){

            requireMsg.add(driver.getWebElementFactory("//span[contains(text(),'is required.')]["+i+"]").getText());
        }
    }
}
