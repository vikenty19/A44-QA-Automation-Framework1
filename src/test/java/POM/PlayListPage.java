package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class PlayListPage extends BasePage {
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

    public void createNewPlaylist(String name) {
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

    public void deletedPlistNotInTheList(String name) {
        List<WebElement> playlistTable = driver.findElements(By.cssSelector(".playlist.playlist>a"));
        List<String> playListNames = new ArrayList<>();
        for (int i = 2; i < playlistTable.size(); i++) {  // i=2 to not include favorites,recently tabs
            String playlName = playlistTable.get(i).getText();
            playListNames.add(playlName);

            Assert.assertNotEquals(playListNames.get(i - 2), name);

        }
        System.out.println(playListNames);
        Assert.assertFalse(playListNames.contains(name));
    }
}
