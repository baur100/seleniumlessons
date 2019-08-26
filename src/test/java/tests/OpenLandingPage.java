package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

public class OpenLandingPage extends BaseTest {


    @Test
    public void OpenLandingPage_OpenLandingPage_LandingPageOpened(){

        LandingPage landingPage =new LandingPage(driver);
        landingPage.open();

        Assert.assertEquals(driver.getCurrentUrl(),"https://deens-master.now.sh/");
    }
    @Test
    public void OpenLandingPage_OpenLoginPage_LoginPageOpened() throws InterruptedException {
        LandingPage landingPage =new LandingPage(driver);
        landingPage.open();
        LoginPage loginPage=landingPage.openLoginPage();
        landingPage=loginPage.login("smarot10","Password_10");

        Assert.assertTrue(landingPage.isOpen());
    }
}
