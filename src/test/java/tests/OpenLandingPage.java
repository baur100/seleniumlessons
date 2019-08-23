package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

public class OpenLandingPage {
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
    public void OpenLandingPage_OpenLandingPage_LandingPageOpened(){
        //Arrange
        LandingPage landingPage =new LandingPage(driver);

        //Act
        landingPage.open();

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(),"https://deens-master.now.sh/");
    }
    @Test
    public void OpenLandingPage_OpenLoginPage_LoginPageOpened() throws InterruptedException {
        //Arrange
        LandingPage landingPage =new LandingPage(driver);
        landingPage.open();

        //Act
        LoginPage loginPage=landingPage.openLogingPage();
        landingPage=loginPage.login("smarot10","Password_10");

        //Assert
        Assert.assertTrue(landingPage.isOpen());
    }
}
