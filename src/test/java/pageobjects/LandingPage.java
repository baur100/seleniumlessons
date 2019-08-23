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

    public LoginPage openLogingPage() {
        WebElement loginButton=getLogingButton();
        loginButton.click();
        LoginPage loginPage = new LoginPage(driver);

        return loginPage;
    }

    private WebElement getLogingButton() {
        WebElement element=driver.findElement(By.partialLinkText("Login"));
        return element;
    }

    public boolean isOpen() {
        wait.until(x->x.findElement(By.xpath("//*[contains(text(),'travels created by locals for')]")).isDisplayed());
        return driver.getCurrentUrl().equals("https://deens-master.now.sh/");
    }
}
