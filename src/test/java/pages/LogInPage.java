package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LogInPage extends BasePage {

    @FindBy(xpath = "//input[@id='ctl00_Main_LoginConrol_UserName']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='ctl00_Main_LoginConrol_Password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='ctl00_Main_LoginConrol_LoginButton']")
    private WebElement btnLogIn;

    @FindBy(xpath = "//td[text()='Your login attempt was not successful. Please try again.']")
    private WebElement errLogInMsg;

    @FindBy(id = "ctl00_TopMenuRepeater_ctl00_MenuLink")
    private WebElement menuLinkHome;

    @FindBy(id = "ctl00_TopMenuRepeater_ctl01_MenuLink")
    private WebElement menuLinkPostAd;

    @FindBy(id = "ctl00_TopMenuRepeater_ctl02_MenuLink")
    private WebElement menuLinkMyAdsProfile;

    @FindBy(xpath = "//div[@id='nav_header']//a")
    private List<WebElement> navMenu;

    public LogInPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driverManager, this);
    }

    public boolean verifyLoads(){
            for (WebElement element : navMenu) {
                if(!waitForElementEnabled(element)){
                    return false;
                }// if inside foreach
            }//foreach
            return waitForElementEnabled(userName) && waitForElementEnabled(password) && waitForElementEnabled(btnLogIn);
    }

    public HomePage logIn( String usr, String pwd ){
        if(setKeys(userName, usr) && setKeys(password, pwd) && clickButton(btnLogIn)) {
            return new HomePage(driverManager);
        }else{
            return null;
        }
    }

    public String getErrorMsg(){
        waitForElementVisible(errLogInMsg);
        return getTextFromElement(errLogInMsg);
    }
}
