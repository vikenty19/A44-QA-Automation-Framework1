package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
    public void isEqualizerDisplayed() {
        WebElement equalizer = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".bars")));
        Assert.assertTrue(equalizer.isDisplayed());
        System.out.println("Is equalizer displayed  " + equalizer.isDisplayed());
    }
    public void isPauseBtnDisplayed() {
        WebElement pauseBtn = driver.findElement(By.cssSelector("span[role='button'] > .fa.fa-pause"));
        new Actions(driver).moveToElement(pauseBtn)
                .perform();
        pauseBtn.click();
        Assert.assertTrue(pauseBtn.isDisplayed());
        System.out.println("Is pause btn displayed?  " + pauseBtn.isDisplayed());
    }

    public String getNewProfileName() {
        WebElement profile = waitUntilVisible(By.cssSelector("span .name"));//.view-profile>span
        String newName = profile.getText();
        return newName;

    }
}
