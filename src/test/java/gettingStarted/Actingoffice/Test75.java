package gettingStarted.Actingoffice;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import extensions.commonmethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Test75 {
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

            WebElement elementDividends = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Dividends")));
            elementDividends.click();

            WebElement elementDividend = wait.until(ExpectedConditions.elementToBeClickable(By.name("Dividend")));
            elementDividend.click();

            WebElement director = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/form/form/div/div[1]/div/div[1]/div/div/div/div[2]/div")
            ));
            director.click();
            WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Testuser']")
            ));
            desiredOption.click();

            WebElement type = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/form/form/div/div[2]/div[1]/div/div/div/div[2]/div")
            ));
            type.click();
            WebElement desiredOption1 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Equity']")
            ));
            desiredOption1.click();


            WebElement addshareholder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/form/form/div/div[4]/button")));
            addshareholder.click();

            WebElement shareholdertype = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div[1]/div[1]/div/div/div/div[2]/div")
            ));
            shareholdertype.click();
            WebElement desiredOption2 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'rs-option') and normalize-space()='Individual']")
            ));
            desiredOption2.click();


            WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div[1]/div[2]/div/div/div[2]/div/div/input")));
            name.click();

            WebElement fname = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Mrs']")
            ));
            fname.click();

            WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div[1]/div[2]/div/div/div[2]/div[2]/div/div/input")
            ));
            firstName.sendKeys("testing-user1");

            WebElement noofshares = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div[3]/div[1]/div[3]/div/div/div/input")
            ));
            noofshares.click();
            noofshares.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            noofshares.sendKeys("3");

            WebElement nominal = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div[3]/div[2]/div[1]/div/div/div/input")
            ));
            nominal.click();
            nominal.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            nominal.sendKeys("3");

            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/button[2]")));
            saveButton.click();

            WebElement dividendshare = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[2]/form/form/div/div[2]/div[3]/div/div/div/input")
            ));
            dividendshare.click();
            dividendshare.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            dividendshare.sendKeys("£600.00");


            WebElement saveButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/button[3]")));
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
                "Add shareholder from inside the Dividend",
                "",
                "",
                "Click on add +dividend, again click on +Shareholder, Select shareholder type, Enter name,  Address, email, phone number, Select share type and class, enter number of shares and Nominal value. Now click on save to add shareholder in the list of shareholders. if we want to add more shareholders then click on + Share tab and repeat the above process. finally click on Save.",
                "",
                "verified",
                "",
                "Tested",
                ""
        );

    }
}