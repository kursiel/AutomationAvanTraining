package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

public class LogInTests extends BaseTest {

    @Parameters({"userName", "password"})
    @Test
    public void successlogIn(String userName, String password){
        HomePage homePage;
        LogInPage logInPage = new LogInPage(driver);

        openLogInUrl(logInPage);
        logInPage.verifyLoads();
        homePage = logInPage.logIn(userName, password);
        Assert.assertTrue(homePage.verifyLoads());
    }

    //Example
    @Parameters({"userNameWrong", "password"})
    @Test
    public void failUserLogIn(String userNameWrong, String password){
        HomePage homePage;
        LogInPage logInPage = new LogInPage(driver);

        openLogInUrl(logInPage);
        logInPage.verifyLoads();
        homePage = logInPage.logIn(userNameWrong, password);
        Assert.assertEquals(logInPage.getErrorMsg(), "Your login attempt was not successful. Please try again.");
    }

    @Parameters({"userName", "passwordWrong"})
    @Test
    public void failPasswordLogIn(String userName, String passwordWrong){
        HomePage homePage;
        LogInPage logInPage = new LogInPage(driver);

        openLogInUrl(logInPage);
        logInPage.verifyLoads();
        homePage = logInPage.logIn(userName, passwordWrong);
        Assert.assertEquals(logInPage.getErrorMsg(), "Your login attempt was not successful. Please try again.");
    }
}
