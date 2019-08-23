package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LandingPage login(String username, String password) {
        WebElement emailField=wait.until(x->getEmailField());
        emailField.sendKeys(username);
        WebElement passwordField = getPasswordField();
        passwordField.sendKeys(password);
        WebElement loginButton = getLoginButton();
        loginButton.click();
        LandingPage landingPage=new LandingPage(driver);
        return landingPage;
    }

    private WebElement getLoginButton() {
        WebElement loginButton=driver.findElement(By.xpath("//*[@data-testid='loginSubmit']"));
        return loginButton;
    }

    private WebElement getPasswordField() {
        WebElement passwordField=driver.findElement(By.name("password"));
        return passwordField;
    }

    private WebElement getEmailField() {
        return driver.findElement(By.id("email"));
    }
}
