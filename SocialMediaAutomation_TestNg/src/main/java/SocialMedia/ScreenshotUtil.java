package SocialMedia;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ScreenshotUtil extends BaseClass
{
    @Test(priority = 3)
    public void captureScreenshot()
            throws Exception
    {
        File src =
                ((TakesScreenshot)driver)
                        .getScreenshotAs(
                                OutputType.FILE);

        File dest =
                new File(
                        "C:\\Screenshots\\profile.png");

        FileHandler.copy(src, dest);

        System.out.println(
                "Screenshot Captured");
    }
}