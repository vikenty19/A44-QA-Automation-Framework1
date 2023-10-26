import POM.BasePage;
import POM.LoginPage;
import POM.PlayListPage;
import POM.SongPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class PlayListTests extends BaseTest {

    @Test
    public void deletePlaylistTest() throws InterruptedException {
        String playlistName = generateRandomPlaylistBookName();
        System.out.println(playlistName);
        PlayListPage playListPage = new PlayListPage(driver);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        playListPage.plusBtnClick();
        playListPage.goToPlayListField();
        playListPage.createNewPlaylist(playlistName);
        //Assertions of playlist name
        playListPage.checkPlayListName(playlistName);
        playListPage.isSuccessBannerDisplayed();
        //delete playlist
        playListPage.deleteCreatedPlaylist();
        //Assertions
        Thread.sleep(1000);//left it because of instability
        playListPage.isPlayListDeleted(playlistName);

    }


    @Test
    public void renamePlayList() {
        String newPlayLIstName = "Mermaid";
        PlayListPage playListPage = new PlayListPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");

        playListPage.choosePlayListToDelete();
        playListPage.enterPlaylistName(newPlayLIstName);
        System.out.println(newPlayLIstName);
        System.out.println(playListPage.getPlaylistName());
        Assert.assertEquals(newPlayLIstName, playListPage.getPlaylistName());
    }

    @Test
    public void renamePlistWithEditBtn() {
        String newName = "Sausage Dog";
        PlayListPage playListPage = new PlayListPage(driver);
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        playListPage.rightClickToEditPlistName();
        playListPage.enterPlaylistName(newName);
        basePage.isSuccessBannerDisplayed();
        Assert.assertEquals(newName, playListPage.getPlaylistName());
        System.out.println(newName+ "  "+ playListPage.getPlaylistName());

    }
    @Test
    public void addSongsInPlaylistByDragging() throws InterruptedException {
       // String playlistName = generateRandomPlaylistBookName();
        String playlistName ="00000000";
        System.out.println(playlistName);
//create playlist
        PlayListPage playListPage = new PlayListPage(driver);
        BasePage basePage = new BasePage(driver);
        SongPage songPage = new SongPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        playListPage.plusBtnClick();
        playListPage.goToPlayListField();
        playListPage.createNewPlaylist(playlistName);
        playListPage.isSuccessBannerDisplayed();
        songPage.goToAllSongsTub();
//add song to playlist with dragging it from allsongs
        WebElement song = loginPage.waitUntilClickable(By
                .cssSelector(".all-songs .song-item:nth-of-type(1) .title"));
       String songInAllSong =  song.getText();
        System.out.println(songInAllSong);
        WebElement playlist = loginPage.waitUntilClickable(By
                .cssSelector("#playlists li:nth-child(3)"));
        //drag song to created playlist
          Thread.sleep((1000));

                new Actions(driver)
                        .dragAndDrop(song, playlist)
                        .perform();
           Thread.sleep(3000);
           playlist.click();
           WebElement addedSong = loginPage.waitUntilVisible(By
                   .cssSelector(".playlist .item-container .items tr.song-item:nth-child(1) .title"));
           addedSong.click();
          String songInPlaylist =  addedSong.getText();
        System.out.println(songInPlaylist);
           Assert.assertEquals(songInAllSong,songInPlaylist);
           playListPage.isSuccessBannerDisplayed();
           //delete playlist
           Thread.sleep(3000);
       basePage.refreshDriver();
      playListPage.deleteCreatedPlaylist();


      WebElement deleteOK = basePage.waitUntilClickable(By.cssSelector("div:nth-of-type(3) nav > .ok"));
        new Actions(driver)
                .moveToElement(deleteOK)
                .perform();
        //Assertions
        Thread.sleep(1000);//left it because of instability
        new Actions(driver)
                .moveToElement(deleteOK)
                .perform();
        playListPage.isPlayListDeleted(playlistName);



    }
}
//#playlists li:nth-child(3)