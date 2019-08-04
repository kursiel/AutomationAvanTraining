package Practice_2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.asserts.*;
import org.testng.annotations.Test;
import com.page.object.LoginObject;
import java.util.ArrayList;
import java.util.List;

public class RegisterTests {
    RegisterPage driver;

    public RegisterTests(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Candelito19\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new RegisterPage(new ChromeDriver());
    }

    @Test
    public void ValidateCorrectLoadPage(){
        driver.getUrl("http://qa-trainingw7:86/");
        driver.clickOnRegisterLink();
        driver.getWaitDriver().until(WebDriver -> ((JavascriptExecutor)WebDriver).executeScript("return document.readyState")).equals("complete");
    }


    @Test
    public void ValidateErrMsgRegisterForm(){
        driver.getUrl("http://qa-trainingw7:86/");
        driver.clickOnRegisterLink();
        driver.clickOnSubmit();
        driver.getWaitDriver().until(ExpectedConditions.visibilityOf(driver.errMsg.get(0)));
        for(int i = 0; i < driver.errMsg.size(); i ++){
            Assert.assertTrue(driver.errMsg.get(i).isDisplayed());
        }
    }

    @Parameters({"firstName", "lastName", "email", "userName", "password", "passwordConfirmation", "question", "answer" })
    @Test
    public void ValidateUserExistForRegistration(String firstName, String lastName, String email, String userName, String password, String passwordConfirmation, String question, String answer){
        driver.getUrl("http://192.168.0.103:86/Register.aspx");
        driver.setKeysFirstName(firstName);
        driver.setKeysLastName(lastName);
        driver.setKeysEmail(email);
        driver.setKeysUsername(userName);
        driver.setKeysPassword(password);
        driver.setKeysPasswordConfirmation(passwordConfirmation);
        driver.setKeysQuestion(question);
        driver.setKeysAnswer(answer);
        driver.clickOnSubmit();

        Assert.assertEquals(driver.errMsgTopLabel.getText(), "User name already exists. Please enter a different user name.");
    }

    @Parameters({"firstName", "lastName", "email", "userName", "password", "passwordConfirmation", "question", "answer" })
    @Test
    public void ValidateUserCreation(String firstName, String lastName, String email, String userName, String password, String passwordConfirmation, String question, String answer){
        driver.getUrl("http://192.168.0.103:86/Register.aspx");
        driver.setKeysFirstName(firstName);
        driver.setKeysLastName(lastName);
        driver.setKeysEmail(email);
        driver.setKeysUsername(userName);
        driver.setKeysPassword(password);
        driver.setKeysPasswordConfirmation(passwordConfirmation);
        driver.setKeysQuestion(question);
        driver.setKeysAnswer(answer);
        driver.clickOnSubmit();
        Assert.assertEquals(driver.successMsg.getText(), "Your account has been successfully created.");
    }

    @Parameters({"firstName", "lastName", "email", "userName", "password", "passwordConfirmation", "question"})
    @Test
    public void ValidatePasswordMatchWithConfirmation(String firstName, String lastName, String email, String userName, String password, String passwordConfirmation, String question){
        driver.getUrl("http://192.168.0.103:86/Register.aspx");
        driver.setKeysFirstName(firstName);
        driver.setKeysLastName(lastName);
        driver.setKeysEmail(email);
        driver.setKeysUsername(userName);
        driver.setKeysPassword(password);
        driver.setKeysPasswordConfirmation(passwordConfirmation);
        driver.setKeysQuestion(question);
        //driver.clickOnSubmit();

        Assert.assertEquals(driver.passwordCompareMsg.getText(), "The password and confirmation password must match.");
    }
}
