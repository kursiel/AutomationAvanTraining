package com.page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class waitsPageObject extends driverObject {

    public WebElement getEmailBox(){
        return getMyDriver().findElement(By.xpath("//input[@name='emailid']"));
    }
}
