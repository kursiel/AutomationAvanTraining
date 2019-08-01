package com.page.object;

import Practice_2.RegisterTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObject extends driverObject {

    private WebDriver driver;

    @FindBy(xpath = "//a[@id='ctl00_LoginView_RegisterLink']")
    private WebElement elementTest;

    public LoginObject(WebDriver initDriver){
        setMyDriver(initDriver);
        //super(initDriver);
        PageFactory.initElements(this.driver = initDriver, this);
    }

    public WebElement getNavBar(){
        return getMyDriver().findElement(By.xpath("//a[text()='Agile Project']"));
    }

    public  WebElement getIdField(){
        return getMyDriver().findElement(By.xpath("//input[@name='uid']"));
    }

    public WebElement getPassField(){
        return getMyDriver().findElement(By.xpath("//input[@name='password']"));
    }

    public WebElement getBtnLogin(){
        return getMyDriver().findElement(By.xpath("//input[@name='btnLogin']"));
    }

    public WebElement getBanner(){
        return getMyDriver().findElement(By.xpath("//marquee"));
    }

    public WebElement getWebElementFactory(String xpath){
        return getMyDriver().findElement(By.xpath(xpath));
    }

    public void clickOnRegisterLink(){
        elementTest.click();
    }
}
