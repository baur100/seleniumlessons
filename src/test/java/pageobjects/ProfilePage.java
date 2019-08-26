package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    private String getCouponCode(){
        WebElement textbox = wait.until(x->x.findElement(By.xpath("(//*[@type='text'])[2]")));
        return textbox.getAttribute("value");
    }
    private WebElement getCopyButton(){
        return driver.findElement(By.xpath("//*[@class='copy icon']"));
    }

    private String getTextFromClipboard() throws IOException, UnsupportedFlavorException {
        return (String) Toolkit.getDefaultToolkit()
                .getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

    public boolean CheckClipboardWork() throws IOException, UnsupportedFlavorException {
        String fromTextbox=getCouponCode();
        fromTextbox="https://deens-master.now.sh/register?ref="+fromTextbox;
        getCopyButton().click();
        String fromClipboard=getTextFromClipboard();
        return fromTextbox.equals(fromClipboard);
    }
}
