package gettingStarted.Actingoffice;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import extensions.commonmethods;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
public class Test2 {
    static ExtentReports extent;
    static ExtentTest test;
    public static void test()
    {    extent = ReportManager.getInstance();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        test = extent.createTest("Detect duplicate invoice Test");

        try {
        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
        driver.manage().window().maximize();
            test.info("Navigated to login page");
            commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");
            test.pass("Entered email");

            commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");
            test.pass("Entered password");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-submit\"]"))).click();
            test.pass("Clicked login");

            driver.navigate().to("https://appdev.actingoffice.com/admin");
            test.info("Navigated to admin dashboard");
        wait.until(ExpectedConditions.elementToBeClickable( By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs"))).click();
            test.pass("inputs button clicked");
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Purchases"))).click();
            test.pass("Purchases button clicked");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Invoice"))).click();
            test.pass("add invoice  button clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']")
        )).click();
            test.pass("Supplier selected");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr/td[2]/div/div/div/div/div[1]/div[2]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']")
        )).click();
            test.pass("Item selected");
        WebElement elementInvoiceNo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/form/div/div[1]/div[1]/div/div[2]/div[1]/div[2]/div/div/div/input")));
        elementInvoiceNo.click();
        elementInvoiceNo.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        elementInvoiceNo.sendKeys("PUR-0008");
            test.pass("Invoice selected");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//span[text()='Save']]")
        )).click();
            test.pass("save button clicked");
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/button[3]")
            )).click();
            test.pass("save button clicked");

            String path = "screenshots/test2.png";
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(path));
            test.pass(
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
        }
        finally {
//            driver.quit();
            extent.flush();
        }
    }
    public static void main(String[] args) {
       test();
//        ExcelLogger.logResult(
//                "Purchase Invoice",
//                "Detect duplicate invoice",
//                "Valid supplier exists",
//                "Enter an already-used invoice number",
//                "Error: “Duplicate invoice” shown",
//                " Duplicate Invoice no.",
//                "",
//                "Tested",
//                ""
    //    );
    }
}
