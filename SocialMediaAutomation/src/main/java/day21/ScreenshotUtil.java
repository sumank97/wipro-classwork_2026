package day21;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil extends BaseClass
{
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
