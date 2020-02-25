package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//a[@id='ctl00_LoginView_RegisterLink']")
    private WebElement registerLink;

    @FindBy(xpath = "//input[contains(@name,'ctl00$Main$CreateUserWizardControl$_')]")
    private WebElement btnSubmit;

    @FindBy(xpath = "//span[contains(text(),'is required.') and not(contains(@style, 'none'))]")
    private List<WebElement> errMsg;

    @FindBy(xpath = "//input[contains(@name, 'Container$FirstName')]")
    private WebElement firstName;

    @FindBy(xpath = "//input[contains(@name, 'Container$LastName')]")
    private WebElement lastName;

    @FindBy(xpath = "//input[contains(@name, 'Container$Email')]")
    private WebElement email;

    @FindBy(xpath = "//input[contains(@name, 'Container$UserName')]")
    private WebElement username;

    @FindBy(xpath = "//input[contains(@name, 'Container$Password')]")
    private WebElement password;

    @FindBy(xpath = "//input[contains(@name, 'Container$ConfirmPassword')]")
    private WebElement passwordConfirmation;

    @FindBy(xpath = "//input[contains(@name, 'Container$Question')]")
    private WebElement question;

    @FindBy(xpath = "//input[contains(@name, 'Container$Answer')]")
    private WebElement answer;

    @FindBy(xpath = "//td[contains(text(), 'successfully created.')]")
    private WebElement successMsg;

    @FindBy(xpath = "//span[@id='ctl00_Main_InfoLabel']")
    private WebElement errMsgTopLabel;

    @FindBy(xpath = "//span[contains(@id, 'PasswordCompare')]")
    private WebElement passwordCompareMsg;


    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driverManager, this);
    }

    public boolean verifyLoads() {
        if (waitForElementEnabled(firstName) && waitForElementEnabled(lastName) && waitForElementEnabled(email) && waitForElementEnabled(username) && waitForElementEnabled(password)
                && waitForElementEnabled(passwordConfirmation) && waitForElementEnabled(question) && waitForElementEnabled(answer) && waitForElementEnabled(btnSubmit)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean clickOnSubmit() {
        return clickButton(btnSubmit);
    }

    public boolean clickOnRegisterLink() {
        return clickButton(registerLink);
    }

    //This method sends the text which the input FirstName will be filled
    public boolean setKeysFirstName(String firstnameKeys) {
        return setKeys(firstName, firstnameKeys);
    }

    //This method sends the text which the input LastName will be filled
    public boolean setKeysLastName(String lastnameKeys) {
        return setKeys(lastName, lastnameKeys);
    }

    //This method sends the text which the input Email will be filled
    public boolean setKeysEmail(String emailKeys) {
        return setKeys(email, emailKeys);
    }

    //This method sends the text which the input Username will be filled
    public boolean setKeysUsername(String usernameKeys) {
        return setKeys(username, usernameKeys);
    }

    //This method sends the text which the input Password will be filled
    public boolean setKeysPassword(String passwordKeys) {
        return setKeys(password, passwordKeys);
    }

    //This method sends the text which the input Password confirmation will be filled
    public boolean setKeysPasswordConfirmation(String passwordConfirmationKeys) {
        return setKeys(passwordConfirmation, passwordConfirmationKeys);
    }

    //This method sends the text which the input Question will be filled
    public boolean setKeysQuestion(String questionKeys) {
        return setKeys(question, questionKeys);
    }

    //This method sends the text which the input Answer will be filled
    public boolean setKeysAnswer(String answerKeys) {
        return setKeys(answer, answerKeys);
    }

    public List<WebElement> getErrMsgList() {
        return errMsg;
    }

    public String getErrorTextMsg() {

        if (getTextFromElement(successMsg) != null) {
            return getTextFromElement(successMsg);
        } else if (getTextFromElement(errMsgTopLabel) != null) {
            return getTextFromElement(errMsgTopLabel);
        } else if (getTextFromElement(passwordCompareMsg) != null) {
            return getTextFromElement(passwordCompareMsg);
        } else {
            return "";
        }
    }

    public boolean fillRegisterForm(String pFirstName, String pLastName, String pEmail, String pUserName, String pPassword, String pPasswordConfirmation, String pQuestion, String pAnswer) {
        return setKeys(firstName, pFirstName) && setKeys(lastName, pLastName) && setKeys(email, pEmail) && setKeys(username, pUserName) && setKeys(password, pPassword) && setKeys(passwordConfirmation, pPasswordConfirmation)
                && setKeys(question, pQuestion) && setKeys(answer, pAnswer);
    }
}
