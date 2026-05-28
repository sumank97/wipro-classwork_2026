package SocialMedia;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ProfilePage extends BaseClass
{
    By profilePhoto =
            By.xpath("//input[@type='file']");

    @Test(priority = 2)
    public void updateProfile()
            throws Exception
    {
        Thread.sleep(5000);

        driver.get("https://www.linkedin.com/in/");

        Thread.sleep(5000);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "window.scrollBy(0,500)");

        Thread.sleep(3000);

        WebElement upload =
                driver.findElement(profilePhoto);

        upload.sendKeys(
                "C:\\Users\\Suman\\Pictures\\photo.jpg");

        System.out.println(
                "Profile Picture Uploaded");
    }
}