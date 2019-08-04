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

    @FindBy(xpath = "//input[contains(@name, 'Container$Email')]" )
    WebElement email;

    @FindBy(xpath = "//input[contains(@name, 'Container$UserName')]")
    WebElement username;

    @FindBy(xpath = "//input[contains(@name, 'Container$Password')]")
    WebElement password;

    @FindBy(xpath = "//input[contains(@name, 'Container$ConfirmPassword')]")
    WebElement passwordConfirmation;

    @FindBy(xpath = "//input[contains(@name, 'Container$Question')]")
    WebElement question;

    @FindBy(xpath = "//input[contains(@name, 'Container$Answer')]")
    WebElement answer;

    @FindBy(xpath = "//td[contains(text(), 'successfully created.')]")
    WebElement successMsg;

    @FindBy(xpath = "//span[@id='ctl00_Main_InfoLabel']")
    WebElement errMsgTopLabel;

    @FindBy(xpath = "//span[contains(@id, 'PasswordCompare')]")
    WebElement passwordCompareMsg;


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

   //This method sends the text which the input FirstName will be filled
   public void setKeysFirstName(String firstnameKeys){
        setKeys(firstName, firstnameKeys);
   }

    //This method sends the text which the input LastName will be filled
   public  void setKeysLastName(String lastnameKeys){
        setKeys(lastName, lastnameKeys);
   }

    //This method sends the text which the input Email will be filled
   public void setKeysEmail(String emailKeys){
        setKeys(email, emailKeys);
   }

    //This method sends the text which the input Username will be filled
   public void setKeysUsername(String usernameKeys){
        setKeys(username, usernameKeys);
   }

    //This method sends the text which the input Password will be filled
   public void setKeysPassword(String passwordKeys){
        setKeys(password, passwordKeys);
   }

    //This method sends the text which the input Password confirmation will be filled
   public void setKeysPasswordConfirmation(String passwordConfirmationKeys){
        setKeys(passwordConfirmation, passwordConfirmationKeys);
   }

    //This method sends the text which the input Question will be filled
   public void setKeysQuestion(String questionKeys){
        setKeys(question, questionKeys);
   }

    //This method sends the text which the input Answer will be filled
   public void setKeysAnswer(String answerKeys){
        setKeys(answer,answerKeys);
   }

   public List<WebElement> getListElements(){
       /*for (WebElement elements: errMsg) {
           System.out.println(elements.getText());
       }*/
       return errMsg;
   }
}
