package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DemoQAAutomation
{
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        Actions action =
                new Actions(driver);

        driver.get("https://demoqa.com/text-box");

        Thread.sleep(3000);

        driver.findElement(By.id("userName"))
                .sendKeys("Su Kumar");

        driver.findElement(By.id("userEmail"))
                .sendKeys("sukumar@gmail.com");

        driver.findElement(By.id("currentAddress"))
                .sendKeys("Bangalore Karnataka");

        driver.findElement(By.id("permanentAddress"))
                .sendKeys("Bihar India");

        js.executeScript("window.scrollBy(0,500)");

        Thread.sleep(2000);

        WebElement submit1 =
                driver.findElement(By.id("submit"));

        js.executeScript("arguments[0].click();", submit1);

        System.out.println("Text Box Completed");

        Thread.sleep(4000);

        driver.get("https://demoqa.com/checkbox");

        Thread.sleep(5000);

        js.executeScript("window.scrollBy(0,300)");

        Thread.sleep(3000);

        WebElement home =
                driver.findElement(By.xpath("//span[text()='Home']"));

        js.executeScript("arguments[0].click();", home);

        System.out.println("Checkbox Completed");

        Thread.sleep(4000);

        driver.get("https://demoqa.com/radio-button");

        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,300)");

        Thread.sleep(2000);

        WebElement yesRadio =
                driver.findElement(By.xpath("//label[@for='yesRadio']"));

        js.executeScript("arguments[0].click();", yesRadio);

        System.out.println("Radio Button Completed");

        Thread.sleep(4000);

        driver.get("https://demoqa.com/select-menu");

        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,500)");

        Thread.sleep(2000);

        WebElement dropdown =
                driver.findElement(By.id("oldSelectMenu"));

        Select select =
                new Select(dropdown);

        select.selectByVisibleText("Purple");

        System.out.println("Dropdown Completed");

        Thread.sleep(4000);

        driver.get("https://demoqa.com/alerts");

        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,300)");

        Thread.sleep(3000);

        WebElement alertButton =
                driver.findElement(By.id("alertButton"));

        js.executeScript("arguments[0].click();", alertButton);

        Thread.sleep(2000);

        driver.switchTo().alert().accept();

        System.out.println("Alert Handled");

        Thread.sleep(4000);

        driver.get("https://demoqa.com/date-picker");

        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,300)");

        Thread.sleep(2000);

        WebElement date =
                driver.findElement(By.id("datePickerMonthYearInput"));

        date.clear();

        date.sendKeys("07/20/2026");

        System.out.println("Date Picker Completed");

        Thread.sleep(4000);

        driver.get("https://demoqa.com/browser-windows");

        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,300)");

        Thread.sleep(2000);

        String parent =
                driver.getWindowHandle();

        WebElement windowButton =
                driver.findElement(By.id("windowButton"));

        js.executeScript("arguments[0].click();", windowButton);

        Thread.sleep(4000);

        for(String win : driver.getWindowHandles())
        {
            driver.switchTo().window(win);

            if(!win.equals(parent))
            {
                String text =
                        driver.findElement(By.id("sampleHeading"))
                                .getText();

                System.out.println(text);

                driver.close();
            }
        }

        driver.switchTo().window(parent);

        System.out.println("Browser Window Completed");

        Thread.sleep(4000);

        driver.get("https://demoqa.com/droppable");

        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,300)");

        Thread.sleep(2000);

        WebElement drag =
                driver.findElement(By.id("draggable"));

        WebElement drop =
                driver.findElement(By.id("droppable"));

        action.dragAndDrop(drag, drop)
                .perform();

        System.out.println("Drag And Drop Completed");

        Thread.sleep(4000);

        driver.get("https://demoqa.com/frames");

        Thread.sleep(3000);

        driver.switchTo().frame("frame1");

        System.out.println("Inside Frame");

        driver.switchTo().defaultContent();

        Thread.sleep(4000);

        driver.get("https://demoqa.com/webtables");

        Thread.sleep(3000);

        js.executeScript("window.scrollBy(0,300)");

        Thread.sleep(2000);

        WebElement addButton =
                driver.findElement(By.id("addNewRecordButton"));

        js.executeScript("arguments[0].click();", addButton);

        Thread.sleep(2000);

        driver.findElement(By.id("firstName"))
                .sendKeys("Su");

        driver.findElement(By.id("lastName"))
                .sendKeys("Kumar");

        driver.findElement(By.id("userEmail"))
                .sendKeys("sukumar@gmail.com");

        driver.findElement(By.id("age"))
                .sendKeys("23");

        driver.findElement(By.id("salary"))
                .sendKeys("50000");

        driver.findElement(By.id("department"))
                .sendKeys("Testing");

        WebElement submit2 =
                driver.findElement(By.id("submit"));

        js.executeScript("arguments[0].click();", submit2);

        System.out.println("Web Table Completed");

        Thread.sleep(5000);

        System.out.println("Automation Completed Successfully");

        driver.quit();
    }
}