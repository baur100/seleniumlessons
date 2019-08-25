import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
//ee
public class FirstRun {
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
    public void firstRun_OpenMainPage_PageOpened(){
        //Act
        driver.get("https://deens-master.now.sh/");

        //Assert
        Assert.assertEquals(driver.getCurrentUrl(),"https://deens-master.now.sh/");
    }
    @Test
    public void firstRun_LoginToAppImplicitWait_Logged() throws InterruptedException {
        //Arrange
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Act
        driver.get("https://deens-master.now.sh/");
        WebElement loginPageButton=driver.findElement(By.xpath("//*[@href='/login']"));
        loginPageButton.click();

        WebElement emailField=driver.findElement(By.id("email"));
        emailField.sendKeys("smarot10");

        WebElement passwordField=driver.findElement(By.name("password"));
        passwordField.sendKeys("Password_10");

        WebElement loginButton=driver.findElement(By.xpath("//*[@data-testid='loginSubmit']"));
        loginButton.click();

        WebElement searchBox=driver.findElement(By.xpath("//*[@style='overflow: hidden; padding: 2px 0px;']"));
        //Assert
        Assert.assertTrue(searchBox.isDisplayed());
    }
    @Test
    public void firstRun_LoginToAppExplicitWait_Logged() throws InterruptedException {
        //Act
        WebDriverWait wait=new WebDriverWait(driver,10,200);

        driver.get("https://deens-master.now.sh/");
        WebElement loginPageButton=driver.findElement(By.xpath("//*[@href='/login']"));
        loginPageButton.click();


        wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        WebElement emailField=driver.findElement(By.id("email"));
        emailField.sendKeys("smarot10");

        WebElement passwordField=driver.findElement(By.name("password"));
        passwordField.sendKeys("Password_10");

        WebElement loginButton=driver.findElement(By.xpath("//*[@data-testid='loginSubmit']"));
        loginButton.click();

        WebElement searchBox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@style='overflow: hidden; padding: 2px 0px;']")));
//        WebElement searchBox=driver.findElement(By.xpath("//*[@style='overflow: hidden; padding: 2px 0px;']"));
        //Assert
        Assert.assertTrue(searchBox.isDisplayed());
    }
    @Test
    public void firstRun_LoginToAppFluentWait_Logged() throws InterruptedException {
        //Act
//        WebDriverWait wait=new WebDriverWait(driver,10);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .withMessage("Sorry - could not found element")
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);

        driver.get("https://deens-master.now.sh/");
        WebElement loginPageButton=driver.findElement(By.xpath("//*[@href='/login']"));
        loginPageButton.click();

//        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
/*        WebElement emailField = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.id("email"));
            }
        });*/
        WebElement emailField = wait.until(x->driver.findElement(By.id("email")));

        emailField.sendKeys("smarot10");

        WebElement passwordField=driver.findElement(By.name("password"));
        passwordField.sendKeys("Password_10");

        WebElement loginButton=driver.findElement(By.xpath("//*[@data-testid='loginSubmit']"));
        loginButton.click();

//        WebElement searchBox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@style='overflow: hidden; padding: 2px 0px;']")));
        WebElement searchBox = wait.until(x->x.findElement(By.xpath("//*[@style='overflow: hidden; padding: 2px 0px;']")));
        //Assert
        Assert.assertTrue(searchBox.isDisplayed());
    }
}
