package gettingStarted.Actingoffice;
import extensions.commonmethods;
import com.aventstack.extentreports.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Test7 {
    static ExtentReports extent;
    static ExtentTest test;
    public static void test() {
        extent = ReportManager.getInstance();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        test = extent.createTest("Sales Estimate Creation Test");
        try {
            driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
            test.info("Navigated to login page");
            driver.manage().window().maximize();
            commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");
            test.pass("entered email address");
            commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");
            test.pass("entered password");

            WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-submit\"]")));
            elementLogin.click();
            driver.navigate().to("https://appdev.actingoffice.com/admin");
            test.info("navigating to admin page");
            WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]")));
            elementDashboard.click();

            WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
            elementBookkeeping.click();

            WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a")));
            elementCompany.click();

            WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
            elementInputsButton.click();
            test.pass("inputs button clicked successfully ");
            WebElement elementSalesButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sales")));
            elementSalesButton.click();
            test.pass("sales button clicked successfully");
            WebElement elementEstimates = wait.until(ExpectedConditions.elementToBeClickable(By.name("Estimates")));
            elementEstimates.click();
            test.pass("estimates button clicked  successfully");
            WebElement addEstimate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Estimate")));
            addEstimate.click();
            test.pass("add estimates button clicked  successfully");
            WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test1']")));
            customer.click();
            test.pass("customer selected successfully");
            WebElement Item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr[1]/td[2]/div/div/div/div/div[1]/div[2]")));
            Item.click();
            WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']")
            ));
            option.click();
            test.pass("item selected  successfully");
            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[.//span[text()='Save']]")
            ));
            saveButton.click();
            test.pass("Save button clicked successfully");

            String folderPath = "screenshots";
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String path = folderPath + "/test7.png";
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(path));
            test.pass(
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());

            test.fail("duplicate estimate number");
        }
        catch (Exception e) {
                test.fail("Test failed: " + e.getMessage());
            }
        finally {
                extent.flush();
            }

    }
    public static void main(String [] args) throws InterruptedException {
        test();
//        ExcelLogger.logResult(
//                "Input/Sales",
//                "Create Estimates",
//                "Logged-in as Admin",
//                "Click on Estimates, Create or select Customer, Select date and expiry date, Create or select item, Enter quantity, unit price,VAT rate, discount rate or Amount and click on Save button.",
//                "Estimate with reference created ",
//                "DUPLICATE ESTIMATE NUMBER.",
//                "",
//                "Tested",
//                "Estimate no. is repeating"
//        );
    }
}
