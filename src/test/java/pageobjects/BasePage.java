package pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;


public class BasePage {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    public BasePage(WebDriver driver){
        this.driver=driver;
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);
    }
}
