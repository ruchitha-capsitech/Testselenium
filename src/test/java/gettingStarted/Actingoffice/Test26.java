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
public class Test26 {
    static ExtentReports extent;
    static ExtentTest test;
    public static void test() {
        extent = ReportManager.getInstance();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        test = extent.createTest("Allocate the invoice amount from the advance receipt amount Test");
        try {
        driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
            test.info("Navigated to login page");
        driver.manage().window().maximize();
        commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");

        commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");

        WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-submit\"]")));
        elementLogin.click();
        driver.navigate().to("https://appdev.actingoffice.com/admin");
            test.info("Navigated to login page");

        WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]")));
        elementDashboard.click();

        WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
        elementBookkeeping.click();

        WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a")));
        elementCompany.click();

        WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
        elementInputsButton.click();
            test.pass("inputs button clicked  successfully");

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sales"))).click();
            test.pass("Sales button clicked  successfully");

        wait.until(ExpectedConditions.elementToBeClickable(By.name("Receipts"))).click();
            test.pass("Receipts button clicked  successfully");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("Receipt"))).click();
            test.pass("add Receipts button clicked  successfully");
        WebElement RecievedFrom = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Acrobat Productions Ltd']")
        ));
        RecievedFrom.click();
            test.pass("RecievedFrom selected  successfully");
        WebElement amountInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@placeholder='amount']")
        ));
        amountInput.click();
        amountInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        amountInput.sendKeys("£4000.00");
            test.pass("amount entered  successfully");
        WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"bk-doc-edit\"]/div[2]/form/div/div[1]/div[1]/div[3]/div[1]/div/div/div/div[2]/div")
        ));
        accountDropdown.click();
        WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Cash in hand - 157/1']")
        ));
        desiredOption.click();
            test.pass("account selected  successfully");
        WebElement elementSave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/div[4]/button[2]")));
        elementSave.click();
            test.pass("inputs button clicked  successfully");
        WebElement elementInvoices = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/button[1]")));
        elementInvoices.click();
            test.pass("invoices button clicked  successfully");
        WebElement elementAddInvoiceButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Invoice")));
        elementAddInvoiceButton.click();
            test.pass("Add Invoice button clicked  successfully");
        WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Acrobat Productions Ltd']")
        ));
        customer.click();
            test.pass("customer selected  button clicked  successfully");
        WebElement Item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr/td[2]/div/div/div/div/div[1]/div[2]")));
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
            test.pass(" save button clicked  successfully");
        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/button[3]/span")
        ));
        save.click();
            test.pass(" save button clicked  successfully");
            String path = "screenshots/test26.png";
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
//                "Advance receipt",
//                "Allocate the invoice amount from the advance receipt amount",
//                "1. Create a receipt with the current date.\n" +
//                        "2. Now create the invoice for that customer.\n" +
//                        "3. Click on 'Save'. A pop-up will appear asking if you want to allocate the advance receipt amount to this invoice. You need to allocate the amount and then save to proceed further.",
//                "1. Allocation of invoice amount from a current-dated receipt should only be allowed if the invoice date is the same as or after the receipt date. If the invoice date is before the receipt date, allocation should not be allowed\n" +
//                        "2. Please check if the allocated amount from the advance receipt is calculated. Also, if the invoice isn’t fully paid, the status should show 'Due'; if fully paid, it should show 'Paid'.",
//                "verified",
//                "",
//                "Tested",
//                ""
//        );
    }}