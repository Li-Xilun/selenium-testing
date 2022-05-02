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


class EditPage extends PageBase {

    private By logoLocator= By.xpath("//div[@class='logo']/a");
    private By editpencilLocator= By.xpath("//div[@ng-show='!showEditor.firstName']");
    private By inputLocatorFN= By.id("firstName");
    public EditPage(WebDriver driver)
    {
        super(driver);
    }

    public MainPage editFirstName(String f) {

        WebElement editpencilLocatorElement = this.waitVisibiiltyAndFindElement(editpencilLocator);
        editpencilLocatorElement.click();	

        WebElement inputLocatorFNElement = this.waitVisibiiltyAndFindElement(inputLocatorFN);
        inputLocatorFNElement.clear();
        WebElement inputLocatorFNElement2 = this.waitVisibiiltyAndFindElement(inputLocatorFN);
        inputLocatorFNElement2.sendKeys(f+"\n");

        //WebElement logoLocatorElement = waitVisibiiltyAndFindElement(logoLocator);
        //logoLocatorElement.click();
        
        return new MainPage(this.driver);
    }

}
