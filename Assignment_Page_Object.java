package Page_Object;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_Page_Object {

    WebDriver driver;
    WebDriverWait wait;

    public Assignment_Page_Object(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // User Authentication Section

    @FindBy(xpath="//*[@id=\"__next\"]/div[1]/div/div[1]/div/div[1]/div[2]/div/div[4]/div[1]/div[1]")
    WebElement myaccount;

    public void clickOnMyAccount() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(myaccount)).click();
    }

    @FindBy(xpath="//*[@id=\"__next\"]/div[1]/div/div[1]/div/div[1]/div[2]/div/div[4]/div[1]/div[2]/div[2]/div[8]")
    WebElement loginOption;

    public void selectLoginOption() {
        wait.until(ExpectedConditions.elementToBeClickable(loginOption)).click();
    }

    // Method to test with login for valid and invalid
    @FindBy(xpath="//*[@id=\"__next\"]/div[6]/div[2]/div/main/div/div[1]/div[2]/div[2]/div[1]/div[1]/input")
    WebElement number;

    @FindBy(xpath="//*[@id=\"__next\"]/div[6]/div[2]/div/main/div/div[1]/div[2]/div[2]/div[2]/div[1]/input")
    WebElement password;

    public void enterInvalidCredentials(String numberValue, String passwordValue) {
        wait.until(ExpectedConditions.elementToBeClickable(number)).sendKeys(numberValue);
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(passwordValue);
    }

    public void enterBlankCredentials() {
        wait.until(ExpectedConditions.elementToBeClickable(number)).sendKeys("");
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys("");
    }

    public void enterOneEmptyCredential(String numberValue, String passwordValue) {
        wait.until(ExpectedConditions.elementToBeClickable(number)).sendKeys(numberValue);
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(passwordValue);
    }

    public void enterOneCorrectAndOneIncorrectCredential(String numberValue, String passwordValue) {
        wait.until(ExpectedConditions.elementToBeClickable(number)).sendKeys(numberValue);
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(passwordValue);
    }

    public boolean isLoginFailed() {
        try {
            // Find the error message element
            WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class, 'login-error')]"));
            // If error message is found, return true indicating login failed
            return errorMessage.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            // If error message is not found or if there's any exception, return false
            return false;
        }
    }

    public void enterValidCredentials(String numberValue, String passwordValue) {
        wait.until(ExpectedConditions.elementToBeClickable(number)).sendKeys(numberValue);
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(passwordValue);
    }

    @FindBy(xpath="//*[@id=\"__next\"]/div[6]/div[2]/div/main/div/div[1]/div[2]/div[2]/button")
    WebElement signIn;

    public void clickOnSignIn() {

        wait.until(ExpectedConditions.elementToBeClickable(signIn)).click();
    }

    // Product Search Section
    @FindBy(xpath="//*[@id=\"__next\"]/div[1]/div/div[1]/div/div[1]/div[2]/div/div[3]/div[1]/div/input")
    WebElement search;

    public void enterSearch(String value) {
        wait.until(ExpectedConditions.elementToBeClickable(search)).sendKeys(value);
    }

    @FindBy(xpath="//*[@id=\"__next\"]/div[1]/div/div[1]/div/div[1]/div[2]/div/div[3]/div[3]/div/div[1]/div[1]/span[2]")
    WebElement searchOption;

    public void selectSearchOption() {

        wait.until(ExpectedConditions.elementToBeClickable(searchOption)).click();
    }

    // Shopping Cart Interaction
    @FindBy(xpath="//*[@id=\"__next\"]/div[2]/div[2]/div[2]/div[3]/div[9]/button")
    WebElement addToCart;

    public void ClickOnAddToCart(){

        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div/div[1]/div/div[1]/div[2]/div/div[4]/div[2]/div")
    WebElement viewCart;

    public void ClickOnCartOption(){

        wait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();
    }

   @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div[3]/div[1]/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div[1]/div/div[3]")
    WebElement addQty;

    public void ClickOnAddQty(){

        wait.until(ExpectedConditions.elementToBeClickable(addQty)).click();
    }

    @FindBy(xpath = "//h2/div/button")
    WebElement checkoutButton;


    public void clickOnCheckoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".justify-between > .btn")));
        element.click();    }
}
