package gettingStarted.Actingoffice;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import extensions.commonmethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Test66 {
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

            WebElement elementPurchase = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Purchases")));
            elementPurchase.click();

            WebElement elementSupplier = wait.until(ExpectedConditions.elementToBeClickable(By.name("Suppliers")));
            elementSupplier.click();

            WebElement elementAddSupplier = wait.until(ExpectedConditions.elementToBeClickable(By.name("Supplier")));
            elementAddSupplier.click();

            WebElement Name = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/form/div/div[1]/div[1]/div/div[1]/div/div[1]/div/div[1]/div/div/input")
            ));
            Name.click();
            Name.sendKeys("A LIMITED");

            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[.//span[text()='Save']]")
            ));
            saveButton.click();
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[3]/div/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[18]/div/div[1]/div/button")).click();


            WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/div/form/form/div/div[1]/div[1]/div/div[1]/div/div[1]/div/div[1]/div/div/input")
            ));
            Name1.click();
            Name1.clear();
            Name1.sendKeys("A LIMITED1");

            WebElement saveButton1 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[.//span[text()='Save']]")
            ));
            saveButton1.click();
        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
        } finally {
            extent.flush();
        }
    }

    public static void main(String[] args) {
        //        test();
        ExcelLogger.logResult(
                "Purchases/Supplier",
                "Add a supplier",
                "",
                "1. Please add a new supplier by entering all the required details.\n" +
                        "2. Edit the supplier details, change the information, and save it again.",
                "Check the supplier details to make sure everything is saved correctly. Verify that editing and saving are working properly. Also, check the supplier balance to confirm the calculations are accurate. Finally, go to the report section and ensure the supplier balance there matches the balance shown here.",
                "verified",
                "",
                "Tested",
                ""
        );

    }
}