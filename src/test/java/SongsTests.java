import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;

public class SongsTests extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String text = "Episode 2";
        String playlistName = generateRandomPlaylistName();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        searchSongInSearchField(text);
        clickAllViewButtn();
        Thread.sleep(500);
        clickFirstSongInResult();
        System.out.println(clickFirstSongInResult());
        clickAddToBtn();
        createNewPlaylistWhileAddingSong(playlistName);
        isSuccessBannerDisplayed();
        Assert.assertEquals(text, getSongText());
        System.out.println(text + " " + getSongText());


    }

    private void searchSongInSearchField(String text) {
        WebElement searchInput = waitUntilClickable(By.cssSelector("[type='search']"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);
    }

    private String getSongText() {
        WebElement songName = driver.findElement(By.cssSelector("#playlistWrapper .song-item .title"));
        String songText = songName.getText();
        return songText;
    }

    private void isSuccessBannerDisplayed() {
        WebElement successBanner = waitUntilVisible(By.cssSelector(".success"));
        Assert.assertTrue(successBanner.isDisplayed());
    }

    public void createNewPlaylistWhileAddingSong(String playlistName) {
        WebElement newPlaylistNameInput = waitUntilVisible(By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']"));
        newPlaylistNameInput.click();
        newPlaylistNameInput.clear();
        newPlaylistNameInput.sendKeys(playlistName);
        // click Enter
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();

    }

    private String clickFirstSongInResult() {
        List<WebElement> songsInResults = driver
                .findElements(By.cssSelector(".search-results .song-item .title"));


        songsInResults.get(0).click();
        return songsInResults.get(0).getText();
    }

    private void clickAddToBtn() {

        WebElement addToButtn = driver.findElement(By.cssSelector(".btn-add-to"));
        addToButtn.click();
    }

    private void clickAllViewButtn() {
        WebElement viewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//button[@data-test='view-all-songs-btn']")));
        viewAll.click();
    }
}