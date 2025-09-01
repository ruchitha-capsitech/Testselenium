package gettingStarted.Actingoffice;

import extensions.commonmethods;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class Test1 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.manage().window().maximize();
    }

    @Test(description = "Sales Invoice Creation Test")
    @Epic("Sales Module")
    @Feature("Invoice Creation")
    @Story("User creates a sales invoice")
    @Severity(SeverityLevel.CRITICAL)
    public void testSalesInvoiceCreation() {
        try {
            driver.navigate().to("https://accountsdev.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappdev.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappdev.actingoffice.com%26acr_values%3Dtenant%253Aappdev.actingoffice.com%26state%3DVFtee6Ln1BghAWA7%26nonce%3DBxbxpUwmWRNI%26code_challenge%3D14dXypLaO1DS6oEkdmu0MfgAuUeFfDTOdgk6zE5mS-Q%26code_challenge_method%3DS256");
            Allure.step("Navigated to login page");

            // Login
            commonmethods.entertextmethods(driver, By.id("Input_Email"), "dev@actingoffice.com");
            Allure.step("Entered email");

            commonmethods.entertextmethods(driver, By.id("Input_Password"), "Welcome@1");
            Allure.step("Entered password");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit"))).click();
            Allure.step("Clicked login");

            // Navigate to admin dashboard
            driver.navigate().to("https://appdev.actingoffice.com/admin");
            Allure.step("Navigated to admin dashboard");

            // Invoice creation steps
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div[4]/div/div/button[1]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[2]/div[3]/div/div/div[3]/div/a"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sales"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.name("Invoice"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr/td[2]/div/div/div/div/div[1]/div[2]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']"))).click();

            // Final save
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Save']]"))).click();
            Allure.step("Invoice saved successfully");
            attachScreenshot("Failure Screenshot");

        } catch (Exception e) {
            Allure.step("Test failed: " + e.getMessage());
            attachScreenshot("Failure Screenshot");
            throw e; // rethrow for debugger visibility
        }
    }

    @Attachment(value = "{screenshotName}", type = "image/png")
    public byte[] attachScreenshot(String screenshotName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            attachScreenshot("Failure Screenshot");
        }

    }
}