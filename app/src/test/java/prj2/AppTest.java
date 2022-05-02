/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package prj2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;



public class AppTest {

    public WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); 
    }

    @Test
    public void pageTitleTest()
    {
        MainPage mainPage = new MainPage(this.driver);
       String t = mainPage.getPageTitle();
        Assert.assertTrue(t.contains("DZone: Programming & DevOps news, tutorials & tools"));
    }

    @Test
    public void loginTest() {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.getBodyText().contains("ABOUT US"));
        Assert.assertTrue(!mainPage.getBodyText().contains("Thanks for visiting DZone today"));

        LoginPage l = mainPage.login();
        MainPage m = l.login("leliho7314@topyte.com", "Exoweareone0408");
        Assert.assertTrue(m.getBodyText().contains("Thanks for visiting DZone today"));

        MainPage mainPage2 = new MainPage(this.driver);
        mainPage2.logout();
        Assert.assertTrue(!mainPage2.getBodyText().contains("Thanks for visiting DZone today"));
    }


    @Test
    public void editProfileTest() {

        MainPage mainPage = new MainPage(this.driver);

        LoginPage l = mainPage.login();
        MainPage m = l.login("leliho7314@topyte.com", "Exoweareone0408");
        EditPage e = mainPage.editProfile();
        MainPage m2 = e.editFirstName("xyyyu");
        //System.out.println(m2.getBodyText());
        //m2.refresh();

        MainPage mainPage2 = new MainPage(this.driver);
        Assert.assertTrue(mainPage2.getBodyText().contains("xyyyu"));

        mainPage.logout();
    }



    @Test
    public void aboutTest(){
        MainPage mainPage = new MainPage(this.driver);
        AboutPage a = mainPage.about();
        Assert.assertTrue(a.getBodyText().contains("What's in DZone's Technical Library?"));
    }


    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}

