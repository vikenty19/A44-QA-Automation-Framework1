package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends Basepage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css ="[type='email']" )
            WebElement emailInput ;


 
    @FindBy(xpath = "//input[@type='password']")
         WebElement passwordInput;


    @FindBy(css ="button[type='submit']" )
            WebElement submitLogin;

   private By submitBtnLocator = By.cssSelector("button[type='submit']");

    public LoginPage enterEmail(String email) {

        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }


    public LoginPage enterPassword(String password) {

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginBtn() {
        submitLogin.click();
        return this;
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