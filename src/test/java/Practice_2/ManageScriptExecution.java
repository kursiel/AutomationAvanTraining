package Practice_2;

import pages.RegisterPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;


public class ManageScriptExecution {
    RegisterPage driver;

    /*public ManageScriptExecution(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kevin.cascante\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new RegisterPage(new ChromeDriver());

    }

    @BeforeMethod
    public void startDriver(){
        System.out.println("Creating Driver");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kevin.cascante\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new RegisterPage(new ChromeDriver());
        if(driver == null)
        {
            System.out.println("Driver could not be created");
        }
        else{
            System.out.println("Driver created successfully");
            driver.getUrl("http://qa-trainingw7:86/");
        }
    }

    @BeforeTest
    public void startTest(){
        System.out.println("Starting Execution");
    }

    @BeforeClass
    public void DriverInit(){
        System.out.println(" Executing class: Practice_2.ManageScriptExecution");
    }

    @AfterMethod
    public void DriverTermination(){
        System.out.println("Deleting Driver");

        if(driver == null) {
            driver.getDriverManager().close();
            driver.getDriverManager().quit();
        }else{
            System.out.println("Driver cannot be deleted");
        }
    }

    @AfterClass
    public void ClosingExecution(){
        System.out.println("Completing execution class: Practice_2.ManageScriptExecution");
    }

    @AfterTest
    public void EndTest(){
        System.out.println("Completing Execution");
    }

    @Test
    public void ValidateCorrectLoadPage(){
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

    @Parameters({"firstName", "lastName", "email", "userName", "password", "passwordConfirmationMatch", "question"})
    @Test
    public void ValidatePasswordMatchWithConfirmation(String firstName, String lastName, String email, String userName, String password, String passwordConfirmationMatch, String question){
        driver.getUrl("http://192.168.0.103:86/Register.aspx");
        driver.setKeysFirstName(firstName);
        driver.setKeysLastName(lastName);
        driver.setKeysEmail(email);
        driver.setKeysUsername(userName);
        driver.setKeysPassword(password);
        driver.setKeysPasswordConfirmation(passwordConfirmationMatch);
        driver.setKeysQuestion(question);
        //driver.clickOnSubmit();

        Assert.assertEquals(driver.passwordCompareMsg.getText(), "The password and confirmation password must match.");
    }*/
}
