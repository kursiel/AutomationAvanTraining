import com.page.object.LoginObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class seleniumTesting {

        LoginObject driver; //new LoginObject(new ChromeDriver());
        //driver.setMyDriver(new ChromeDriver());
    public seleniumTesting(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kevin.cascante\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new LoginObject(new ChromeDriver());
    }

    @Test
    public void login(){

        //WebDriver driver = new ChromeDriver();
        //driver.getUrl("http://demo.guru99.com/");
        driver.getUrl("http://google.com");
        /*WebElement navItem = driver.findElement(By.xpath("//a[text()='Agile Project']"));
        navItem.click();*/

        driver.getNavBar().click();

        //WebElement element = driver.findElement(By.xpath("//input[@name='uid']"));
        driver.getIdField().sendKeys("1303");

        //WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        driver.getPassField().sendKeys("Guru99");

        //WebElement btnLogin = driver.findElement(By.xpath("//input[@name='btnLogin']"));
        driver.getBtnLogin().click();

        //WebElement banner = driver.findElement(By.xpath("//marquee"));
        String textBanner = driver.getBanner().getText();
       // Assert.assertEquals("Welcome To Customer's Page of Guru99 Bank", textBanner, "Test Succ" );
        Assert.assertTrue(textBanner.contains("Welcome2 To Customer's Page of Guru99 Bank"), "Error the title does not match with the title on the page");

    }
}
