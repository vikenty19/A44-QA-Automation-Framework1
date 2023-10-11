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

    By plusBtn = By.cssSelector(".fa-plus-circle");
    By pListLocator = By.cssSelector(".playlist:nth-child(3)>a");

    By pListNameField = By.cssSelector("input[name='name']");

    By createPlaylistLocator = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");

    By header = By.cssSelector("#playlistWrapper h1");



    By deletePlayList = By
            .cssSelector(".btn-delete-playlist");

    By playListsLocator = By.cssSelector(".playlist.playlist>a");
    public void choosePlayListToDelete() {
        WebElement pListNameToDelete = wait.until(ExpectedConditions
                .visibilityOfElementLocated(pListLocator));
        System.out.println(pListNameToDelete.getText());
        new Actions(driver)
                .doubleClick(pListNameToDelete)
                .perform();

    }

    public void enterPlaylistName(String name) {
        WebElement playlistInputField = waitUntilClickable(pListNameField);
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public void plusBtnClick() {
        WebElement plusButton = waitUntilVisible(plusBtn);
        plusButton.click();
    }

    public void goToPlayListField() {
        WebElement newPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(createPlaylistLocator));
        newPlaylist.click();

    }

    public void createNewPlaylist(String name) {
        WebElement enterField = wait.until(ExpectedConditions
                .elementToBeClickable(pListNameField));
        enterField.click();
        enterField.clear();
//    enterField.sendKeys(playlistName);

        new Actions(driver).sendKeys(name)
                .keyDown(Keys.ENTER)
                .perform();
    }

    public void checkPlayListName(String name) {
        WebElement playListHeader = waitUntilVisible((header));
        wait.until(ExpectedConditions.textToBePresentInElement(playListHeader, name));
        Assert.assertEquals(playListHeader.getText(), name);
    }



    public void deleteCreatedPlaylist() {
        WebElement deletePlistBtn = waitUntilClickable(deletePlayList);
        deletePlistBtn.click();
    }

    public void isPlayListDeleted(String name) {
        List<WebElement> playlistTable = driver.findElements(playListsLocator);
         List<String> playListNames = new ArrayList<>();
        for (int i = 2; i < playlistTable.size(); i++) {  // i=2 to not include favorites,recently tabs
            String playlName = playlistTable.get(i).getText();
            playListNames.add(playlName);

            Assert.assertNotEquals(playListNames.get(i - 2), name);

        }
        System.out.println(playListNames);
        Assert.assertFalse(playListNames.contains(name));
    }
    public String getPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions
                .visibilityOfElementLocated(pListLocator));
        String name = playlistInputField.getText();
        return name;
    }

}
