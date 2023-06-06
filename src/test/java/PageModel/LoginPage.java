package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends Basepage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By emailField = By.cssSelector("[type='email']");
    By  passwordField = By.cssSelector("[type='password']");
  By submitLoginBtn = By.cssSelector("button[type='submit']");
By submitBtnLocator = By.cssSelector("button[type='submit']");

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }


    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginBtn() {
        WebElement submitLogin = driver.findElement(submitLoginBtn);
        submitLogin.click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }

    public boolean isSubmitBtnDisplayed() {
        return driver.findElement(submitBtnLocator).isDisplayed();
    }


}