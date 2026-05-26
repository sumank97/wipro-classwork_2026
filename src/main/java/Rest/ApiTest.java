package Rest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ApiTest {
    
    
    public static ExtentReports extent;
    public static ExtentSparkReporter spark;
    public static ExtentTest test;

    @BeforeSuite
    public void setupReport() {
      
        String reportPath = "D:/Core Java/RestApi/test-output/ExtentReport.html";
        spark = new ExtentSparkReporter(reportPath);
        
        
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Test
    public void getUsersApiTest() {
       
        test = extent.createTest("Get Users API Test");

        try {
         
            
           
            test.log(Status.PASS, "Get Users API executed successfully");
            
        } catch (Exception e) {
            test.log(Status.FAIL, "Test Failed: " + e.getMessage());
        }
    }

    @AfterSuite
    public void tearDown() {
       
        extent.flush();
    }
}