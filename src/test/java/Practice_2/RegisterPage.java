package Practice_2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//a[@id='ctl00_LoginView_RegisterLink']")
    WebElement registerLink;

    @FindBy(xpath = "//input[contains(@name,'ctl00$Main$CreateUserWizardControl$_')]")
    WebElement btnSubmit;

    @FindBy(xpath = "//span[contains(text(),'is required.') and not(contains(@style, 'none'))]")
    List<WebElement> errMsg;

    @FindBy(xpath = "//input[contains(@name, 'Container$FirstName')]")
    WebElement firstName;

    @FindBy(xpath = "//input[contains(@name, 'Container$LastName')]")
    WebElement lastName;



    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driverManager = driver, this);
    }

   public void clickOnSubmit(){
       clickButton(btnSubmit);
   }

   public void clickOnRegisterLink(){
       clickButton(registerLink);
   }

   public List<WebElement> getListElements(){
       /*for (WebElement elements: errMsg) {
           System.out.println(elements.getText());
       }*/
       return errMsg;
   }
}
