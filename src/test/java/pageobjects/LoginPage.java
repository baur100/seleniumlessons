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
        return new LandingPage(driver);
    }

    private WebElement getLoginButton() {
        return By.xpath("//*[@data-testid='loginSubmit']").findElement(driver);
    }

    private WebElement getPasswordField() {
        return driver.findElement(By.name("password"));
    }

    private WebElement getEmailField() {
        return driver.findElement(By.id("email"));
    }
}
