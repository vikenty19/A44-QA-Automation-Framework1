package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    public BasePage( WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(givenDriver);
        PageFactory.initElements(driver,this);


    }
    By successLocator = By.cssSelector(".success");
    public void refreshDriver(){
        driver.navigate().refresh();
    }

    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement waitUntilVisible(By element) {
        return new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(element));

    }

    public WebElement waitUntilClickable(By element) {
        return new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(element));

    }
    public void isSuccessBannerDisplayed() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(successLocator));
    }

}
