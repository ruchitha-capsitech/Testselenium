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
public class Test4 {
    static ExtentReports extent;
    static ExtentTest test;
    public static void test() {
        extent = ReportManager.getInstance();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        test = extent.createTest("Create Credit note with no payment Test");

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
        test.pass("inputs selected");
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sales"))).click();
            test.pass("sales selected");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Credit notes"))).click();
            test.pass("credit notes selected");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Credit note"))).click();
            test.pass("add credit note selected");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test1']"))).click();
            test.pass("customer selected");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div/div/div[2]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'rs-option') and normalize-space()='INV-0063']"))).click();
            test.pass("invoice selected");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Save']]"))).click();
        test.pass("save button clicked");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Save']"))).click();
            String path1 = "screenshots/test4.png";
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
//                "Input/Sales",
//                "Create Credit note",
//                "Sales invoice created and no payment received from customer",
//                "Go to credit note and click on credit note, Select customer, date, invoice reference number, update quantity returned, Unit price, discount rate or amount, enter note if any and click on save button.",
//                "Credit note created and related sales invoice due amount reduced by credit note amount. Also General ledger of Sales, VAT and Customer updated.",
//                " Payment created successfully",
//                "",
//                "Tested",
//                ""
//        );
    }

    }

