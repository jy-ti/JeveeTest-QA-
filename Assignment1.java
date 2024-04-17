package Assignment;

import Page_Object.Assignment_Page_Object;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Assignment1 {

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
        assignment.clickOnMyAccount();
        assignment.selectLoginOption();
        assignment.enterInvalidCredentials("9812345678", "abcd@12");
        assignment.clickOnSignIn();
    }
    @Test
    public void testInvalidLoginWithBlankCredentials() {
            assignment.clickOnMyAccount();
            assignment.selectLoginOption();
            assignment.enterBlankCredentials();
    }
    @Test
    public void testInvalidLoginWithOneEmptyCredential() {
            assignment.clickOnMyAccount();
            assignment.selectLoginOption();
            assignment.enterOneEmptyCredential("9862361366", " ");
            assignment.clickOnSignIn();
    }
    @Test
    public void testInvalidLoginWithOneCorrectAndOneIncorrectCredential() {

            assignment.clickOnMyAccount();
            assignment.selectLoginOption();
            assignment.enterOneCorrectAndOneIncorrectCredential("9862361366", "abcd@12");
            assignment.clickOnSignIn();
    }
    @Test
    public void testValidLogin() {
        try {
            // Enter valid credentials
            assignment.clickOnMyAccount();
            assignment.selectLoginOption();
            assignment.enterValidCredentials("9862361366", "Jyoti@1366");
            assignment.clickOnSignIn();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            //Assert.fail("Test failed: " + e.getMessage());
        }
    }
    @Test
    public void SearchSelect() {
        try {
            //SearchSelect
            assignment.clickOnMyAccount();
            assignment.selectLoginOption();
            assignment.enterValidCredentials("9862361366", "Jyoti@1366");
            assignment.clickOnSignIn();

            assignment.enterSearch("cream");
            assignment.selectSearchOption();

            //Shopping Cart Interaction
            assignment.ClickOnAddToCart();
            assignment.ClickOnCartOption();
            assignment.ClickOnAddQty();
            // assignment.SelectProductToCheckOut();
            assignment.clickOnCheckoutButton();


            // Assertion to verify that login is successful
            Assert.assertFalse(assignment.isLoginFailed(), "Login failed unexpectedly");

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
           // Assert.fail("Test failed: " + e.getMessage());
        }
    }
}
