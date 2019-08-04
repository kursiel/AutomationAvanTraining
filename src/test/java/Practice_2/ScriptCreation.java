package Practice_2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ScriptCreation {

    RegisterPage driver;

    public ScriptCreation(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Candelito19\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new RegisterPage(new ChromeDriver());
    }

    public void ValidateCorrectLoadPage(){
        driver.getUrl("http://qa-trainingw7:86/");
        driver.clickOnRegisterLink();

        if(driver.btnSubmit.isDisplayed() && driver.registerLink.isDisplayed()){
            System.out.println("The page was loaded correctly");
        }
        else{
            System.out.println("It was an error during the page loading");
        }
    }

    public void ValidateErrMsgRegisterForm(){
        driver.getUrl("http://qa-trainingw7:86/");
        driver.clickOnRegisterLink();
        driver.clickOnSubmit();

        for(int i = 0; i < driver.errMsg.size(); i ++){
            System.out.println(driver.errMsg.get(i).getText() + "The component  is displayed: "+ driver.errMsg.get(i).isDisplayed());
        }
    }

    public void ValidateUserExistForRegistration(){
        driver.getUrl("http://192.168.0.103:86/Register.aspx");
        driver.setKeysFirstName("Roberto");
        driver.setKeysLastName("Albeiro");
        driver.setKeysEmail("ra1234@gmail.com");
        driver.setKeysUsername("ra12");
        driver.setKeysPassword("123456@");
        driver.setKeysPasswordConfirmation("123456@");
        driver.setKeysQuestion("What is my mother's name?");
        driver.setKeysAnswer("Sonia Albeiro");
        driver.clickOnSubmit();

        if(driver.errMsgTopLabel.getText().equals("User name already exists. Please enter a different user name.")){
            System.out.println("Valid error message displayed");
        }
        else{
            System.out.println("Invalid error message displayed");
        }
    }

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

        if(driver.passwordCompareMsg.getText().equals("The password and confirmation password must match.")){
            System.out.println("Valid password error message was displayed");
        }
        else{
            System.out.println("Invalid password error message was displayed");
        }
    }
}
