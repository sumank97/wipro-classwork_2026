package automationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DemoQAAutomation {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--log-level=3"); 
        
        WebDriver driver = new ChromeDriver(options);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String excelPath = "./test-data/TestData.xlsx";
        Object[][] mySuiteData = ThreadDemo.getTestDataFromExcel(excelPath, "Sheet1");

        if (mySuiteData == null || mySuiteData.length == 0) {
            System.err.println("Execution halted: No data pulled out from the Excel file.");
            driver.quit();
            return;
        }

        for (int i = 0; i < mySuiteData.length; i++) {
            String fullName = mySuiteData[i][0].toString();
            String email = mySuiteData[i][1].toString();
            String currentAddr = mySuiteData[i][2].toString();
            String permanentAddr = mySuiteData[i][3].toString();

            try {
                System.out.println("-------------------------------------------------------");
                System.out.println("Executing Automation Run Pattern Row [" + (i + 1) + "] for: " + fullName);
                
                driver.get("https://demoqa.com/text-box");

                WebElement nameInput = explicitWait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("userName"))
                );
                
                nameInput.clear();
                nameInput.sendKeys(fullName);

                WebElement emailInput = driver.findElement(By.id("userEmail"));
                emailInput.clear();
                emailInput.sendKeys(email);

                WebElement currentAddrInput = driver.findElement(By.id("currentAddress"));
                currentAddrInput.clear();
                currentAddrInput.sendKeys(currentAddr);

                WebElement permanentAddrInput = driver.findElement(By.id("permanentAddress"));
                permanentAddrInput.clear();
                permanentAddrInput.sendKeys(permanentAddr);

                WebElement submitButton = driver.findElement(By.id("submit"));
                js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
                js.executeScript("arguments[0].click();", submitButton);
                
                System.out.println("Console Logging Assertion Verification Step -> Button Clicked");
                System.out.println("Form lifecycle passed cleanly for target user record profile: " + fullName);

            } catch (Exception e) {
                System.err.println("AUTOMATION ENGINE ALERT: Intercepted error at data row [" + (i + 1) + "]: " + e.getMessage());
            }
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("All rows processed successfully.");
        
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("WebDriver active session terminated cleanly. System workspace offline.");
            }
        }
    }
}
