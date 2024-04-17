package Assignment;

import Page_Object.Assignment_Page_Object;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentExtent1 {

    private static ExtentReports extentReports = ExtentReportManager.getExtentReports();
    private ExtentTest extentTest;
    WebDriver driver;
    Assignment_Page_Object assignment;

    @BeforeMethod
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Eastpoint\\Desktop\\QA\\Chrome driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        assignment = new Assignment_Page_Object(driver);
        driver.get("https://www.jeevee.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testInvalidLoginWithInvalidCredentials() {
        extentTest = extentReports.createTest("Test Invalid Login with Invalid Credentials");
        extentTest.log(Status.INFO, "Clicking on My Account");
        assignment.clickOnMyAccount();
        extentTest.log(Status.INFO, "Selecting Login Option");
        assignment.selectLoginOption();
        extentTest.log(Status.INFO, "Entering invalid credentials");
        assignment.enterInvalidCredentials("9812345678", "abcd@12");
        extentTest.log(Status.INFO, "Clicking on Sign In");
        assignment.clickOnSignIn();
        extentTest.log(Status.PASS, "Invalid login attempt executed successfully");
    }

    @Test
    public void testInvalidLoginWithBlankCredentials() {
        extentTest = extentReports.createTest("Test Invalid Login with Blank Credentials");
        extentTest.log(Status.INFO, "Clicking on My Account");
        assignment.clickOnMyAccount();
        extentTest.log(Status.INFO, "Selecting Login Option");
        assignment.selectLoginOption();
        extentTest.log(Status.INFO, "Entering blank credentials");
        assignment.enterBlankCredentials();
        extentTest.log(Status.PASS, "Invalid login attempt with blank credentials executed successfully");
    }

    @Test
    public void testInvalidLoginWithOneEmptyCredential() {
        extentTest = extentReports.createTest("Test Invalid Login with One Empty Credential");
        extentTest.log(Status.INFO, "Clicking on My Account");
        assignment.clickOnMyAccount();
        extentTest.log(Status.INFO, "Selecting Login Option");
        assignment.selectLoginOption();
        extentTest.log(Status.INFO, "Entering one empty credential");
        assignment.enterOneEmptyCredential("9862361366", " ");
        extentTest.log(Status.INFO, "Clicking on Sign In");
        assignment.clickOnSignIn();
        extentTest.log(Status.PASS, "Invalid login attempt with one empty credential executed successfully");
    }

    @Test
    public void testInvalidLoginWithOneCorrectAndOneIncorrectCredential() {
        extentTest = extentReports.createTest("Test Invalid Login with One Correct and One Incorrect Credential");
        extentTest.log(Status.INFO, "Clicking on My Account");
        assignment.clickOnMyAccount();
        extentTest.log(Status.INFO, "Selecting Login Option");
        assignment.selectLoginOption();
        extentTest.log(Status.INFO, "Entering one correct and one incorrect credential");
        assignment.enterOneCorrectAndOneIncorrectCredential("9862361366", "abcd@12");
        extentTest.log(Status.INFO, "Clicking on Sign In");
        assignment.clickOnSignIn();
        extentTest.log(Status.PASS, "Invalid login attempt with one correct and one incorrect credential executed successfully");
    }

    @Test
    public void testValidLogin() {
        extentTest = extentReports.createTest("Test Valid Login");
        try {
            extentTest.log(Status.INFO, "Clicking on My Account");
            assignment.clickOnMyAccount();
            extentTest.log(Status.INFO, "Selecting Login Option");
            assignment.selectLoginOption();
            extentTest.log(Status.INFO, "Entering valid credentials");
            assignment.enterValidCredentials("9862361366", "Jyoti@1366");
            extentTest.log(Status.INFO, "Clicking on Sign In");
            assignment.clickOnSignIn();
            extentTest.log(Status.PASS, "Valid login attempt executed successfully");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Exception occurred: " + e.getMessage());
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void SearchSelect() {
        extentTest = extentReports.createTest("Test Search and Select");
        try {
            extentTest.log(Status.INFO, "Clicking on My Account");
            assignment.clickOnMyAccount();
            extentTest.log(Status.INFO, "Selecting Login Option");
            assignment.selectLoginOption();
            extentTest.log(Status.INFO, "Entering valid credentials");
            assignment.enterValidCredentials("9862361366", "Jyoti@1366");
            extentTest.log(Status.INFO, "Clicking on Sign In");
            assignment.clickOnSignIn();

            extentTest.log(Status.INFO, "Entering search term");
            assignment.enterSearch("cream");
            extentTest.log(Status.INFO, "Selecting search option");
            assignment.selectSearchOption();

            extentTest.log(Status.INFO, "Clicking on Add to Cart");
            assignment.ClickOnAddToCart();
            extentTest.log(Status.INFO, "Clicking on Cart Option");
            assignment.ClickOnCartOption();
            extentTest.log(Status.INFO, "Clicking on Add Quantity");
            assignment.ClickOnAddQty();
            extentTest.log(Status.INFO, "Clicking on Checkout Button");
            assignment.clickOnCheckoutButton();

            extentTest.log(Status.PASS, "Search, select, and checkout process executed successfully");
            Assert.assertFalse(assignment.isLoginFailed(), "Login failed unexpectedly");
        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Exception occurred: " + e.getMessage());
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        extentReports.flush();
    }
}