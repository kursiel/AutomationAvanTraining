package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LogInPage;
import pages.RegisterPage;

public class BaseTest {

    protected RegisterPage registerPage;

    public WebDriver driver;

    @Parameters({"webDriver"})
    @BeforeMethod
    public void setWebDriver(String webDriver){
        if(webDriver.equals("Chrome")) {
            driver = new ChromeDriver();
        }else if(webDriver.equals("Firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\kevin.cascante\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(webDriver.equals("Edge")){
            System.setProperty("webdriver.edge.driver", "C:\\Users\\kevin.cascante\\Downloads\\edgedriver_win64\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
    }

    //@BeforeTest
    public void openLogInUrl(LogInPage logInPage){
        //basePage.getUrlPage("http://qa-trainingw7:86/Login.aspx");
        //basePage.getWaitDriver().until(WebDriver -> ((JavascriptExecutor)WebDriver).executeScript("return document.readyState")).equals("complete");
        logInPage.getUrlPage("http://qa-trainingw7:86/Login.aspx");
    }

    public void openRegisterInUrl(RegisterPage registerPage){
        registerPage.getUrlPage("http://qa-trainingw7:86/Register.aspx");
    }

    @AfterMethod
    public void closeDriver() {
        if(driver != null) {
            //basePage.driverManager.close();
            driver.quit();
        }
    }
}
