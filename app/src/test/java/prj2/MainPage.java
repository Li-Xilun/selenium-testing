package prj2;

import java.util.Arrays;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Collections;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class MainPage extends PageBase {

    private By clicktoLoginLocator=By.linkText("Log In");
    private By informLocator= By.xpath("//div[@class='user-info']/button");
    private By editinformLocator= By.linkText("Edit Profile");

    private By logoLocator= By.xpath("//div[@class='logo']/a");
    //private By informLocator2= By.xpath("//div[@class='user-info']/button");
    private By submitLogoutLocator= By.linkText("Sign Out");
    
    private By aboutLocator= By.linkText("About DZone");

    public MainPage(WebDriver driver)
    {
        super(driver);
        this.driver.get("https://dzone.com/");
    }
    public String getPageTitle()
    {
            return this.driver.getTitle();
    }

    public LoginPage login() {
        WebElement clicktoLoginLocatorElement = this.waitVisibiiltyAndFindElement(clicktoLoginLocator);
        clicktoLoginLocatorElement.click();
        return new LoginPage(this.driver);
    }

    public void logout() {
        WebElement infElement = this.waitVisibiiltyAndFindElement(informLocator);
        infElement.click();
        WebElement logoutElement = this.waitVisibiiltyAndFindElement(submitLogoutLocator);
        logoutElement.click();
    }


    public AboutPage about(){
        WebElement aboutElement = this.waitVisibiiltyAndFindElement(aboutLocator);
        aboutElement.click();
        return new AboutPage(this.driver);
    }


    public EditPage editProfile(){
        WebElement infElement = this.waitVisibiiltyAndFindElement(informLocator);
        infElement.click();
        WebElement editElement = this.waitVisibiiltyAndFindElement(editinformLocator);
        editElement.click();
        return new EditPage(this.driver);

    }

    public void refresh() {
        WebElement logoLocatorElement = waitVisibiiltyAndFindElement(logoLocator);
        logoLocatorElement.click();
    }

    public String GetUsername(){
        return this.waitVisibiiltyAndFindElement(By.xpath("//span[@class='username']")).getText();
    }

}
