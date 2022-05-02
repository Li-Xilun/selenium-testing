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


class LoginPage extends PageBase {

    private By inputLocatorEmail= By.name("username");
    private By inputLocatorPass=By.name("password");
    private By submitLoginLocator= By.xpath("//button[@ng-click='doLogin()']");
    

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public MainPage login(String u, String p) {
            WebElement inputLocatorEmailElement = this.waitVisibiiltyAndFindElement(inputLocatorEmail);
            inputLocatorEmailElement.sendKeys(u+"\n");

            WebElement inputLocatorPassElement = this.waitVisibiiltyAndFindElement(inputLocatorPass);
            inputLocatorPassElement.sendKeys(p+"\n");
            
            WebElement submitLoginLocatorElement = this.waitVisibiiltyAndFindElement(submitLoginLocator);
            submitLoginLocatorElement.click();
            return new MainPage(this.driver);
    } 

}
