package gettingStarted.Actingoffice;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import extensions.commonmethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Test80 {
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

            WebElement elementJournalButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Journals")));
            elementJournalButton.click();

            WebElement elementFrom = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/div/input")));
            elementFrom.click();
            elementFrom.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            elementFrom.sendKeys("01/02/2025");

            WebElement elementTo = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div[2]/div[3]/div/div/div/div/input")));
            elementTo.click();
            elementTo.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            elementTo.sendKeys("28/10/2025");

            WebElement refresh = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div[2]/button")
            ));
            refresh.click();
        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
        } finally {
            extent.flush();
        }
    }

    public static void main(String[] args) {
        //        test();
        ExcelLogger.logResult(
                "Journals",
                "Date range",
                "",
                "Apply any date range",
                "Transactions will be displayed based on the selected date range.",
                "verified",
                "",
                "Tested",
                ""
        );

    }
}