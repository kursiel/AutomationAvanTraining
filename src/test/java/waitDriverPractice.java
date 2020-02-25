import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import com.page.object.waitsPageObject;

public class waitDriverPractice{

    private waitsPageObject driver = new waitsPageObject();

    @Test
    public void implicitWaits(){

        driver.setMyDriver(new ChromeDriver());

        driver.getMyDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //250ms

        //driver.getMyDriver().get("http://demo.guru99.com/");
        driver.getUrl("http://demo.guru99.com/");

        //WebElement emailBox = driver.getMyDriver().findElement(By.xpath("//input[@name='emailid']"));
        //emailBox.sendKeys("tests@gmail.com");
        driver.getEmailBox().sendKeys("tests@gmail.com");

        WebElement btnLogin = driver.getMyDriver().findElement(By.xpath("//input[@name='btnLogin']"));

    }

}
