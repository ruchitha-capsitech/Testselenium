package gettingStarted.Actingoffice;

import extensions.commonmethods;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class Test212 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.manage().window().maximize();
        Allure.step("Browser launched and maximized");
    }

    @Test(description = "Asset Disposal Navigation Test")
    @Epic("Assets Module")
    @Feature("Disposed Assets")
    @Story("User navigates to disposed assets")
    @Severity(SeverityLevel.NORMAL)
    public void testDisposedAssetsNavigation() {
        try {
            driver.navigate().to("https://accountsuat.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappuat.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappuat.actingoffice.com%26acr_values%3Dtenant%253Aappuat.actingoffice.com%26state%3DP0TrCqetlD3Frb7S%26nonce%3D3yAJGonYS8rc%26code_challenge%3DK-CWwVztcxdOk3nlJ2i50KVZFyjQmkNuDW1Jys-l_wg%26code_challenge_method%3DS256");
            Allure.step("Navigated to login page");

            driver.findElement(By.id("Input_Email")).sendKeys("demo.admin@actingoffice.com");
            Allure.step("Entered email");

            driver.findElement(By.id("Input_Password")).sendKeys("AdminAO@1947");
            Allure.step("Entered password");

            commonmethods.entertextmethods(driver, By.id("Input_Password"), "AdminAO@1947");
            Allure.step("Used common method to enter password");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit"))).click();
            Allure.step("Clicked login");

            driver.navigate().to("https://appuat.actingoffice.com/admin");
            Allure.step("Navigated to admin dashboard");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div/div[2]/div[1]/div[4]/div/div/button[1]"))).click();
            Allure.step("Clicked dashboard button");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]"))).click();
            Allure.step("Clicked bookkeeping");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[1]/div[4]/div/div/div[3]/div/a"))).click();
            Allure.step("Clicked company");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs"))).click();
            Allure.step("Clicked inputs button");

            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Assets"))).click();
            Allure.step("Clicked Assets link");

            wait.until(ExpectedConditions.elementToBeClickable(By.name("Disposed"))).click();
            Allure.step("Clicked Disposed assets");

            Allure.step("Successfully navigated to Disposed Assets section");

        } catch (Exception e) {
            Allure.step("Test failed: " + e.getMessage());
            attachScreenshot("Failure Screenshot");
            throw e;
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
        if (driver != null) {
            driver.quit();
            Allure.step("Browser closed");
        }
    }
}


//package gettingStarted.Actingoffice;
//import extensions.commonmethods;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//
//public class Test212 {
//    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        driver.navigate().to("https://accountsuat.actingoffice.com/login?returnUrl=%2Foauth%2Fauthorize%2Fcallback%3Fclient_id%3Dweb%26redirect_uri%3Dhttps%253A%252F%252Fappuat.actingoffice.com%252Foidc-callback%26scope%3Dopenid%2520profile%2520offline_access%2520api%26response_type%3Dcode%26tenant%3Dappuat.actingoffice.com%26acr_values%3Dtenant%253Aappuat.actingoffice.com%26state%3DP0TrCqetlD3Frb7S%26nonce%3D3yAJGonYS8rc%26code_challenge%3DK-CWwVztcxdOk3nlJ2i50KVZFyjQmkNuDW1Jys-l_wg%26code_challenge_method%3DS256");
//        driver.manage().window().maximize();
//        driver.findElement(By.id("Input_Email")).sendKeys("demo.admin@actingoffice.com");
//        driver.findElement(By.id("Input_Password")).sendKeys("AdminAO@1947");
//
//        commonmethods.entertextmethods(driver, By.id("Input_Password"), "AdminAO@1947");
//
//        WebElement elementLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-submit\"]")));
//        elementLogin.click();
//        driver.navigate().to("https://appuat.actingoffice.com/admin");
//
//        WebElement elementDashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div/div[2]/div[1]/div[4]/div/div/button[1]")));
//        elementDashboard.click();
//
//        WebElement elementBookkeeping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/a[1]")));
//        elementBookkeeping.click();
//
//        WebElement elementCompany = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div[3]/div/div/div[2]/div/div/div/div/div[1]/div[4]/div/div/div[3]/div/a")));
//        elementCompany.click();
//
//        WebElement elementInputsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputs")));
//        elementInputsButton.click();
//
//        WebElement elementExpenseclaims = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Assets")));
//        elementExpenseclaims.click();
//
//        WebElement elementUser = wait.until(ExpectedConditions.elementToBeClickable(By.name("Disposed")));
//        elementUser.click();
//    }}