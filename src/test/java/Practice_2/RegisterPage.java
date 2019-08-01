package Practice_2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class RegisterPage extends BasePage {

    public void RegisterTests(WebDriver driver){
        super(driver);

    }

    @FindBy(xpath = "//a[@id='ctl00_LoginView_RegisterLink']")
    WebElement registerLink;

    @FindBy(xpath = "//input[contains(@name,'ctl00$Main$CreateUserWizardControl$_')]")
    WebElement btnSubmit;

   /* @FindBys({
            @FindBy("span[contains(text(),'is required.')][1]")
    })*/

   @FindBy(xpath = "//span[contains(text(),'is required.')]")
    List<WebElement> errMsg;

   public void clickOnSubmit(){
       btnSubmit.click();
   }

   public void clickOnRegisterLink(){
       registerLink.click();
   }

   public String getListElements(){
       return errMsg.get(si);
   }
}
