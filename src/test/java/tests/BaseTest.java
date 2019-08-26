package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
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
}
