package POM;

import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void openProfile(){
        WebElement avatar =waitUntilVisible(By.cssSelector(".avatar"));
        avatar.click();
    }

    public void enterPasswordInProfile() {
        WebElement currentPasswordInput = waitUntilClickable(By.id("inputProfileCurrentPassword"));
        currentPasswordInput.click();
        currentPasswordInput.clear();
        currentPasswordInput.sendKeys("te$t$tudent");
    }

    public void enterNewNameInProfile(String name) {
        WebElement profileName = waitUntilClickable(By.cssSelector("#inputProfileName"));
        profileName.click();
        profileName.clear();
        profileName.sendKeys(name);
    }

    public void enterEmailInProfilePage() {
        WebElement emailInput = waitUntilClickable(By.cssSelector("#inputProfileEmail"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("demo@class.com");
    }

    public void clickSaveInProfile() {
        WebElement saveBtn = waitUntilClickable(By.cssSelector(".btn-submit"));
        saveBtn.click();
    }

}
