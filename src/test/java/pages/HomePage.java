package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h3[@class='section']")
    private WebElement homePageTitle;

    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl00_TopCategoryButton")
    private WebElement antiquesCollectiblesTitle;

    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl04_TopCategoryButton")
    private WebElement gardenTitle;

    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl01_TopCategoryButton")
    private WebElement artscraftsTitle;

    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl05_TopCategoryButton")
    private WebElement homeTitle;

    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl02_TopCategoryButton")
    private WebElement autoTitle;

    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl06_TopCategoryButton")
    private WebElement musicTitle;

    @FindBy(id = "ctl00_Main_CategoryBrowser_TopCategoryList_ctl03_TopCategoryButton")
    private WebElement electronicTitle;

    //Lista de Web Elements
    @FindBy(xpath = "//h3[contains(text(),' Browse Categories')]/following-sibling::div//li")
    private List<WebElement> subCategories;

    @FindBy(id = "ctl00_LoginView_MemberName")
    private WebElement memberName;

    @FindBy(id = "ctl00_TopMenuRepeater_ctl00_MenuLink")
    private WebElement menuLinkHome;

    @FindBy(id = "ctl00_TopMenuRepeater_ctl01_MenuLink")
    private WebElement menuLinkPostAd;

    @FindBy(id = "ctl00_TopMenuRepeater_ctl02_MenuLink")
    private WebElement menuLinkMyAdsProfile;

   @FindBy(xpath = "//div[@id='nav_header']/ul//span")
   private List<WebElement> navMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driverManager, this);
    }


    public boolean verifyLoads(){
            if(waitForElementEnabled(memberName) && waitForElementEnabled(menuLinkHome) && waitForElementEnabled(menuLinkPostAd) && waitForElementEnabled(menuLinkMyAdsProfile)){
                for(WebElement elements : subCategories){
                    if(!waitForElementEnabled(elements)){
                        return false;
                    }
                }
                return true;
            }else{
                return false;
            }
    }

    public boolean verifyUsr( String usr){
        return usr.equals(getTextFromElement(memberName));
    }

    //Options
    //1 - Home
    //2 - Post an Ad
    //3 - My Ads & Profile
    public boolean navToHomeTab(String link){
            if(link == menuLinkHome.getText()){
                clickButton(menuLinkHome);
                return true;
            }else if(link == menuLinkPostAd.getText()){
                clickButton(menuLinkPostAd);
                return true;
            }else if(link == menuLinkMyAdsProfile.getText()){
                clickButton(menuLinkMyAdsProfile);
                return true;
            }else{
                return false;
            }
    }
}
