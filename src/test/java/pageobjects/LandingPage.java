package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends BasePage{
    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://deens-master.now.sh/");
    }

    public LoginPage openLoginPage() {
        WebElement loginButton= getLoginButton();
        loginButton.click();
        LoginPage loginPage = new LoginPage(driver);

        return loginPage;
    }

    private WebElement getLoginButton() {
        WebElement element=driver.findElement(By.partialLinkText("Login"));
        return element;
    }

    public boolean isOpen() {
        wait.until(x->x.findElement(By.xpath("//*[contains(text(),'travels created by locals for')]")).isDisplayed());
        return driver.getCurrentUrl().equals("https://deens-master.now.sh/");
    }
    
    private WebElement getProfileIcon(){
        return wait.until(x->x.findElement(By.xpath("(//*[@class=' ls-is-cached lazyloaded'])[1]")));
    }
    private WebElement getProfileMenuItem(){
        return wait.until(x->x.findElement(By.xpath("//*[@class='text' and text()='Profile']")));
    }

    public ProfilePage openProfile() {
        WebElement profileIcon = getProfileIcon();
        profileIcon.click();
        WebElement profileMenuItem = getProfileMenuItem();
        profileMenuItem.click();
        return new ProfilePage(driver);
    }
}
