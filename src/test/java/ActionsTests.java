import PageModel.ActionsPage;
import PageModel.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ActionsTests extends BaseTest {
    @Test
    public void playSongTest() {
        ActionsPage actionsPage = new ActionsPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        actionsPage.clickFooterPlayBtn();
        Assert.assertTrue(actionsPage.pauseBtnExists());
        List<WebElement> songs = driver.findElements(By.cssSelector("[data-test='song-card']"));
        int songsNumberBefore = songs.size();
        System.out.println(songsNumberBefore);
        // Just an example: here we would add or delete an element but we didn't
        int songsNumberAfter = songs.size();
        System.out.println(songsNumberAfter);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(songsNumberBefore == songsNumberAfter,
                "=== Songs number before should be equal songs number after ===");
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/#!/home");
        System.out.println("Hello world");
        softAssert.assertAll();
    }

    @Test
    public void renamePlaylist() {
    ActionsPage actionsPage =new ActionsPage(driver);
        String playlistName = "Summer songs";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        actionsPage.doubleClickChoosePlaylist();
        actionsPage.enterPlaylistName(playlistName);
        String newName = actionsPage.getPlaylistName();
        Assert.assertEquals(playlistName, newName, "=== PlaylistNames expected to be equals ===");
    }

    @Test
    public void playSongFromListTest() {
        ActionsPage actionsPage =new ActionsPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        actionsPage.goToAllSongs();
        actionsPage.rightClickOnFirstSong();
       actionsPage.clickPlayBtn();
        Assert.assertTrue(actionsPage.isEqualizerDisplayed());
    }


    @Test
    public void countSongsInPlaylist() {
        ActionsPage actionsPage =new ActionsPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        actionsPage.playListClick();
        List<WebElement> songs = actionsPage.getWebElements();
        int number = songs.size();
        Assert.assertEquals(number, 1); // can fail, depends on current number. This is just an example

    }


}
