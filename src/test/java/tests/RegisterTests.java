package tests;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegisterPage;

public class RegisterTests extends BaseTest {

    public void ValidateCorrectLoadPage(){
        //driver.getUrl("http://qa-trainingw7:86/");
        registerPage.clickOnRegisterLink();
        //registerPage.wait().until(WebDriver -> ((JavascriptExecutor)WebDriver).executeScript("return document.readyState")).equals("complete");
        Assert.assertTrue(registerPage.verifyLoads());
    }

    @Test
    public void ValidateErrMsgRegisterForm(){
        SoftAssert softAssertion = new SoftAssert();
        RegisterPage registerPage = new RegisterPage(driver);
        openRegisterInUrl(registerPage);

        registerPage.clickOnRegisterLink();
        registerPage.clickOnSubmit();
        registerPage.waitForElementVisible((registerPage.getErrMsgList().get(0)));

        for(int i = 0; i < registerPage.getErrMsgList().size(); i ++){
            softAssertion.assertTrue(registerPage.getErrMsgList().get(i).isDisplayed());
        }
        softAssertion.assertAll();
    }

    @Parameters({"firstName", "lastName", "email", "userName", "password", "passwordConfirmation", "question", "answer" })
    @Test
    public void ValidateUserExistForRegistration(String firstName, String lastName, String email, String userName, String password, String passwordConfirmation, String question, String answer){
        registerPage.fillRegisterForm(firstName, lastName, email, userName, password, passwordConfirmation, question, answer);
        Assert.assertEquals(registerPage.getErrorTextMsg(), "User name already exists. Please enter a different user name.");
    }

    @Parameters({"firstName", "lastName", "email", "userName", "password", "passwordConfirmation", "question", "answer" })
    @Test
    public void ValidateUserCreation(String firstName, String lastName, String email, String userName, String password, String passwordConfirmation, String question, String answer){
        registerPage.fillRegisterForm(firstName, lastName, email, userName, password, passwordConfirmation, question, answer);
        Assert.assertEquals(registerPage.getErrorTextMsg(), "Your account has been successfully created.");
    }

    @Parameters({"firstName", "lastName", "email", "userName", "password", "passwordConfirmationMatch", "question"})
    @Test
    public void ValidatePasswordMatchWithConfirmation(String firstName, String lastName, String email, String userName, String password, String passwordConfirmationMatch, String question){
        registerPage.setKeysFirstName(firstName);
        registerPage.setKeysLastName(lastName);
        registerPage.setKeysEmail(email);
        registerPage.setKeysUsername(userName);
        registerPage.setKeysPassword(password);
        registerPage.setKeysPasswordConfirmation(passwordConfirmationMatch);
        registerPage.setKeysQuestion(question);
        registerPage .clickOnSubmit();

        Assert.assertEquals(registerPage.getErrorTextMsg(), "The password and confirmation password must match.");
    }
}

