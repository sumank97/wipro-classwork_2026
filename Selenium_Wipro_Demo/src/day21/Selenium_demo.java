package day21;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Selenium_demo {
     public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(30000);
        System.out.println(driver.getTitle());
        driver.quit();
        
	}

}
