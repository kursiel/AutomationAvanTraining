package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static long PAGE_LOAD_TIMEOUT = 40;
    protected WebDriver driverManager; //Global Variable to store WebDriver
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driverManager = driver;
        this.wait = new WebDriverWait(driverManager, PAGE_LOAD_TIMEOUT);
    }

    public boolean getUrlPage(String url) {
        try {
            driverManager.get(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean clickButton(WebElement button) {
        try {
            if (waitForElementEnabled(button)) {
                button.click();
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("click cannot be completed by: " + e);
            return false;
        }
    }

    public boolean setKeys(WebElement inputField, String value) {
        try {
            if (waitForElementEnabled(inputField)) {
                clearOnElement(inputField);
                inputField.sendKeys(value);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("The keys were not sent to the element by: " + e);
            return false;
        }
    }

    public boolean clearOnElement(WebElement element) {
        try {
            if (waitForElementEnabled(element)) {
                element.clear();
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Clear");
            return false;
        }
    }

    public String getTextFromElement(WebElement element) {
        try {
            if (waitForElementVisible(element)) {
                return element.getText();
            }
            return "";
        } catch (Exception e) {
            System.out.println("The text could not get from element by: " + e);
            return "";
        }
    }

    public boolean waitForElementVisible(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            System.out.println("Somethings wrong happened by: " + e);
            return false;
        }
    }

    public boolean waitForElementEnabled(WebElement element) {
        try {
            //return wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
            return wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
        } catch (Exception e) {
            System.out.println("Somethings wrong happened by: " + e);
            return false;
        }
    }

    public boolean waitForElementNotVisible(WebElement element) {
        try {
            //return !wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
            return wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            System.out.println("Somethings wrong happened by: " + e);
            return false;
        }
    }

}
