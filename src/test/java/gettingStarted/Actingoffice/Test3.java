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
public class Test3 {
    static ExtentReports extent;
    static ExtentTest test;
    public static void test() {
        extent = ReportManager.getInstance();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        test = extent.createTest("Overpayment handling Test");

        try {
        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
            test.info("Navigated to login page");
        driver.manage().window().maximize();
        commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");
        commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-submit\"]"))).click();
        driver.navigate().to("https://appdev.actingoffice.com/admin");
            test.info("navigating to admin page");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs"))).click();
            test.pass("inputs button clicked");
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Purchases"))).click();
            test.pass("purchase button clicked");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Payments"))).click();
        test.pass("payment button clicked");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Payment"))).click();
        test.pass("add payment button clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']"))).click();
            test.pass("Customer selected");
        WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='amount']")));
        amountInput.click();
        amountInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        amountInput.sendKeys("£4000.00");
            test.pass("amount entered");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/div[2]/form/div/div[1]/div[1]/div[3]/div[1]/div/div/div/div[2]/div"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Cash in hand - 157/1']"))).click();
            test.pass("account selected");
        wait.until(ExpectedConditions.elementToBeClickable( By.xpath("//*[@id=\"bk-doc-edit\"]/div[4]/button[2]"))).click();
            test.pass("save button clicked");
            String path = "screenshots/test3.1.png";
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(path));
            test.pass(
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            String path1 = "screenshots/test3.2.png";
            File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot1, new File(path1));
            test.pass(
                    MediaEntityBuilder.createScreenCaptureFromPath(path1).build());
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
//                "Payments",
//                "Overpayment handling",
//                "Existing invoice unpaid",
//                "Send payment exceeding invoice total",
//                "Warning shown; overpayment recorded",
//                " Payment created successfully",
//                "",
//                "Tested",
//                ""
//        );
    }
}
