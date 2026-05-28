package day21;

public class SocialMediaTest
{
    public static void main(String[] args)
            throws Exception
    {
        BaseClass base =
                new BaseClass();

        base.setup();

        LoginPage login =
                new LoginPage();

        login.login();

        Thread.sleep(5000);

        ProfilePage profile =
                new ProfilePage();

        profile.updateProfile();

        Thread.sleep(3000);

        ScreenshotUtil shot =
                new ScreenshotUtil();

        shot.captureScreenshot();

        Thread.sleep(5000);

        base.closeBrowser();
    }
}
