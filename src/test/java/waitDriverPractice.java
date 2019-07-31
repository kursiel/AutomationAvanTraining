import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import com.page.object.waitsPageObject;

public class waitDriverPractice{

    private waitsPageObject driver = new waitsPageObject();

    //Detiene la aplicacion el tiempo establecido y luego la reanuda.
    @Test
    public void implicitWaits(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Candelito19\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

        driver.setMyDriver(new ChromeDriver());

        driver.getMyDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //250ms

        //driver.getMyDriver().get("http://demo.guru99.com/");
        driver.getUrl("http://demo.guru99.com/");

        //WebElement emailBox = driver.getMyDriver().findElement(By.xpath("//input[@name='emailid']"));
        //emailBox.sendKeys("test@gmail.com");
        driver.getEmailBox().sendKeys("test@gmail.com");

        WebElement btnLogin = driver.getMyDriver().findElement(By.xpath("//input[@name='btnLogin']"));

    }

    //Detiene la aplicaccion un tiempo determinado mientras busca el elemento esperado sino regresa un error de timeout exception
    @Test
    public void explicitwaits(){

    }

}
