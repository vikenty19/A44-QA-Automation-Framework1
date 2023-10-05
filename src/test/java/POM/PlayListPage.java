package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PlayListPage extends BasePage{
    public PlayListPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void clearPlayLIstNameField() {
        WebElement pListNameToDelete = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)>a")));
        System.out.println(pListNameToDelete.getText());
        new Actions(driver)
                .doubleClick(pListNameToDelete)
                .perform();

    }
    public void enterPlaylistName(String name) {
        WebElement playlistInputField = waitUntilClickable(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public void plusBtnClick() {
        WebElement plusBtn = waitUntilVisible(By.cssSelector(".fa-plus-circle"));
        plusBtn.click();
    }

    public void goToPlayListField() {
        WebElement newPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        newPlaylist.click();

    }

    public void enterNewPlaylistName(String name) {
        WebElement enterField = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("input[name='name']")));
        enterField.click();
        enterField.clear();
//    enterField.sendKeys(playlistName);

        new Actions(driver).sendKeys(name)
                .keyDown(Keys.ENTER)
                .perform();
    }

    public void checkPlayListName(String name) {
        WebElement playListHeader = waitUntilVisible((By.cssSelector("#playlistWrapper h1")));
        wait.until(ExpectedConditions.textToBePresentInElement(playListHeader, name));
        Assert.assertEquals(playListHeader.getText(), name);
    }

    public void isSuccessBunnerDisplayed() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".success")));
    }

    public void deleteCreatedPlaylist() {
        WebElement deletePlistBtn = waitUntilClickable(By
                .cssSelector(".btn-delete-playlist"));
        deletePlistBtn.click();
    }
}

