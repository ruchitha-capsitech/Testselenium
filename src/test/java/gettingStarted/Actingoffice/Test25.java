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
public class Test25 {
    static ExtentReports extent;
    static ExtentTest test;
    public static void test() {
        extent = ReportManager.getInstance();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        test = extent.createTest("Rollback bad debts invoice Test");
        try {
        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
            test.info("Navigated to login page");
        driver.manage().window().maximize();
        commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");

        commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");


        By login = By.xpath("//*[@id=\"login-submit\"]");
        WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(login));
        elementLogin.click();
        driver.navigate().to("https://appdev.actingoffice.com/admin");
            test.info("Navigated to login page");

        By dashboard = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]");
        WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(dashboard));
        elementDashboard.click();

        By bookkeeping = By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]");
        WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(bookkeeping));
        elementBookkeeping.click();

        By company = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a");
        WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(company));
        elementCompany.click();

        By inputsButton = By.id("inputs");
        WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(inputsButton));
        elementInputsButton.click();
            test.pass("inputs button clicked  successfully");
        By salesButton = By.linkText("Sales");
        WebElement elementSalesButton = wait.until(ExpectedConditions.elementToBeClickable(salesButton));
        elementSalesButton.click();
            test.pass("Sales button clicked  successfully");
        By rollback = By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div/div/div/div[3]/div/div/div[8]/div/div/div/button");
        WebElement elementRollback = wait.until(ExpectedConditions.elementToBeClickable(rollback));
        elementRollback.click();
            test.pass("Rollback button clicked  successfully");
        By yes = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/button[2]");
        WebElement elementYes = wait.until(ExpectedConditions.elementToBeClickable(yes));
        elementYes.click();
            test.pass("yes button clicked  successfully");
            String path = "screenshots/test25.png";
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(path));
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        }
        catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
        }
        finally {
            extent.flush();
        }
    }
    public static void main(String[] args) {
               test();
//        ExcelLogger.logResult(
//                "Input/Sales",
//                "Rollback bad debts invoice",
//                "This invoice has already been marked as a bad debt",
//                "Click on the rollback icon and confirm by selecting 'Yes.",
//                "Verify that the impact of the bad debts entry is removed from all reports.",
//                "Bad debts removed successfully",
//                "",
//                "Tested",
//                ""
//        );
    }}