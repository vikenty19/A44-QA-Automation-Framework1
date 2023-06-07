package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class PlayListPage extends Basepage {
    public PlayListPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By clickPlusLocator = By.cssSelector("[data-testid='sidebar-create-playlist-btn']");
    private By successBanner = By.cssSelector(".success");

    private By newPlistNameLocator = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");

    private By inputNamePlist = By.cssSelector(".create input");

    private By newPlistNamewithSong = By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']");

    private By addPlistBtn = By.cssSelector("[data-test='add-to-btn']");

    private By matchHeader = By.cssSelector("#playlistWrapper h1");
    private By delPlistlocator = By.cssSelector(".btn-delete-playlist");

    private By allPlist = By.cssSelector("#playlists a");

    public void clickPlusPlaylistBtn() {
        WebElement plusBtn = waitUntilVisible(clickPlusLocator);
        plusBtn.click();

    }

    public void createNewPlaylistName(String playlist) {
        wait.until(ExpectedConditions
                        .elementToBeClickable(newPlistNameLocator))
                .click();
        WebElement inputPlaylistName = wait.until(ExpectedConditions
                .visibilityOfElementLocated(inputNamePlist));
        inputPlaylistName.click();
        inputPlaylistName.clear();
        inputPlaylistName.sendKeys(playlist);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }


    public WebElement verifySuccessBanner() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successBanner));
    }

    public void createNewPlaylistWhileAddingSong(String playlistName) {
        WebElement newPlaylistNameInput = driver.findElement(newPlistNamewithSong);
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
    }

    public void clickAddToPlaylistBtn() {
        WebElement addToBtn = driver.findElement(addPlistBtn);
        addToBtn.click();
    }

    public boolean isPlistNameInHeader(String playlist) {
        WebElement playlistHeader = driver.findElement(matchHeader);
        return wait.until(ExpectedConditions
                .textToBePresentInElement(playlistHeader, playlist));

    }

    public void clickToDeletePlist() {
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions
                .elementToBeClickable(delPlistlocator));
        deletePlaylistBtn.click();

    }

    public List<String> getPlaylistNames() {
        List<WebElement> playlists = driver.findElements(allPlist);
        // get playlist names from playlist elements
        List<String> playlistNames = new ArrayList<>();

        for (int i = 0; i < playlists.size(); i++) {
            String playlistName = playlists.get(i).getText();
            playlistNames.add(playlistName);
        }
        System.out.println(playlistNames);
        return playlistNames;
    }
}





