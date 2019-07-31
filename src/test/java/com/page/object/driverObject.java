package com.page.object;

import org.openqa.selenium.WebDriver;

public abstract class driverObject {

    private WebDriver myDriver;

    public void setMyDriver(WebDriver driver){
        this.myDriver = driver;
    }

    public WebDriver getMyDriver(){
        return myDriver;
    }

    public  void getUrl(String url){
        getMyDriver().get(url);
    }

}
