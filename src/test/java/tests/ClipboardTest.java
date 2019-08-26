package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.ProfilePage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboardTest extends BaseTest {

    @Test
    public void ClipboardTest_CopyReferralCodeToClipboard_CodeCopied() throws IOException, UnsupportedFlavorException, InterruptedException {

        LandingPage landingPage =new LandingPage(driver);
        landingPage.open();
        LoginPage loginPage=landingPage.openLoginPage();
        landingPage=loginPage.login("smarot10","Password_10");
        ProfilePage profilePage=landingPage.openProfile();

        Assert.assertTrue(profilePage.CheckClipboardWork());
    }
}
