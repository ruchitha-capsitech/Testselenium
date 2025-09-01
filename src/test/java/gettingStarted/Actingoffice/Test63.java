package gettingStarted.Actingoffice;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import extensions.commonmethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Test63 {
    static ExtentReports extent;
    static ExtentTest test;
    public static void test() {
        extent = ReportManager.getInstance();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        test = extent.createTest("Create purchase invoice Test");
        try {
            driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
            driver.manage().window().maximize();
            commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");

            commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");

            WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-submit\"]")));
            elementLogin.click();
            driver.navigate().to("https://appdev.actingoffice.com/admin");

            WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]")));
            elementDashboard.click();

            WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
            elementBookkeeping.click();

            WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a")));
            elementCompany.click();

            WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
            elementInputsButton.click();

            WebElement elementSalesButton = wait.until(ExpectedConditions.elementToBeClickable( By.linkText("Purchases")));
            elementSalesButton.click();

            WebElement elementCreditNotesButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Credit notes")));
            elementCreditNotesButton.click();

            WebElement elementAddCreditNote = wait.until(ExpectedConditions.elementToBeClickable(By.name("Credit note")));
            elementAddCreditNote.click();

            WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']")
            ));
            customer.click();

            WebElement InvoiceRefNo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div/div/div[2]")
            ));
            InvoiceRefNo.click();

            WebElement invoiceNo = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'rs-option') and normalize-space()='PUR-0005']")
            ));
            invoiceNo.click();

            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[.//span[text()='Save']]")
            ));
            saveBtn.click();

            WebElement accountDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[2]/table/tbody/tr/td[2]/div/div/div/div[1]/div[2]")
            ));
            accountDropdown.click();
            WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Cash in hand - 157/1']")
            ));
            desiredOption.click();

//        WebElement RefundAmt = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[2]/table/tbody/tr/td[3]/div/div/div/div/input")));
//        RefundAmt.click();
//        RefundAmt.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//        RefundAmt.sendKeys("15000");

            WebElement saveBtn1 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button[title='Save']")));
            saveBtn1.click();
        }
        catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
        }
        finally {
            extent.flush();
        }
    }

            public static void main(String[] args) {
                //        test();
                ExcelLogger.logResult(
                        "Purchases/Credit note",
                        "Create credit note",
                        "The invoices should already be created",
                        "1. Go to the Credit Note section and add a new credit note\n" +
                                "2. Select an invoice using the invoice reference number and save the credit note.",
                        "If a credit note is made for the entire quantity, then that invoice number should not appear in the invoice reference number dropdown. After the credit note is created, the invoice should no longer be editable.",
                        "verified",
                        "",
                        "Tested",
                        ""
                );

    }
}