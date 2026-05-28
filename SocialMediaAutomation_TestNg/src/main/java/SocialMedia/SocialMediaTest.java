package SocialMedia;

import org.testng.annotations.Test;

public class SocialMediaTest extends BaseClass
{
    LoginPage login =
            new LoginPage();

    ProfilePage profile =
            new ProfilePage();

    ScreenshotUtil shot =
            new ScreenshotUtil();

    @Test
    public void socialMediaAutomation()
            throws Exception
    {
        login.login();

        Thread.sleep(5000);

        profile.updateProfile();

        Thread.sleep(3000);

        shot.captureScreenshot();

        Thread.sleep(3000);

        System.out.println(
                "Automation Completed");
    }
}
