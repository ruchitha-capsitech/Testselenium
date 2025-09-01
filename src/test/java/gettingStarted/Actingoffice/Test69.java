package gettingStarted.Actingoffice;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import extensions.commonmethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Test69 {
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

            WebElement elementPurchase = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sales")));
            elementPurchase.click();

            WebElement elementAddItem = wait.until(ExpectedConditions.elementToBeClickable(By.name("Invoice")));
            elementAddItem.click();

            WebElement customer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Test2']")
            ));
            customer.click();

            WebElement Item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bk-doc-edit\"]/form/div/div[3]/div/table/tbody/tr/td[2]/div/div/div/div/div[1]/div[2]")));
            Item.click();
            WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class, 'rs-option') and normalize-space(text())='Item']")
            ));
            option.click();

            WebElement account = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/form/div/div[3]/div/table/tbody/tr[1]/td[4]/div/div/div/div[1]/div[2]/input")
            ));
            account.click();
            account.sendKeys("testaccount");
            account.sendKeys(Keys.ENTER);

            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div[3]/div[2]/div[2]/button[2]")
            ));
            saveButton.click();

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
                "Entire BK",
                "Add account head",
                "A new account should not be allowed to be created if an account with the same name or same code already exists.",
                "11. Create the account head from all the places where account heads can be added.\n" +
                        "2. Enter the account name, select the type, and the code will be generated automatically. Now, go ahead and save it.",
                "The newly added account should be selectable. Make sure that the same code isn’t being used for any other account, and that no duplicate account exists with the same name. Also, search for the account to confirm it’s not appearing multiple times—like two or three times in the list.",
                "verified",
                "",
                "Tested",
                ""
        );

    }
}