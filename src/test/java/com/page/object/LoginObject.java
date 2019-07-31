package com.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObject extends driverObject {

    public LoginObject(WebDriver initDriver){
        setMyDriver(initDriver);
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
}
