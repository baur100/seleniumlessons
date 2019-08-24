package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.ProfilePage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboardTest {
    WebDriver driver;

    @BeforeTest
    public void startUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver= new ChromeDriver();

    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(7000);
        driver.close();
        driver.quit();
    }

    @Test
    public void ClipboardTest_CopyReferralCodeToClipboard_CodeCopied() throws IOException, UnsupportedFlavorException, InterruptedException {
        //Arrange
        LandingPage landingPage =new LandingPage(driver);
        landingPage.open();

        //Act
        LoginPage loginPage=landingPage.openLogingPage();
        landingPage=loginPage.login("smarot10","Password_10");

//        Thread.sleep(5000);
        ProfilePage profilePage=landingPage.openProfile();
        Assert.assertTrue(profilePage.CheckClipboardWork());




    }
}
