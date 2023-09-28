import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;

public class PlayListTests extends BaseTest {

    @Test
    public void deletePlaylistTest() throws InterruptedException {
        String playlistName = "Marazm";


        login("demo@class.com", "te$t$tudent");
   //    WebElement plusBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa-plus-circle")));

        WebElement plusBtn = waitUntilVisible(By.cssSelector(".fa-plus-circle"));

        plusBtn.click();

        WebElement newPlaylist = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));

        newPlaylist.click();
//
        //playlist name Enter

        WebElement enterField = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("input[name='name']")));
        enterField.click();
        enterField.clear();
//    enterField.sendKeys(playlistName);

        new Actions(driver).sendKeys(playlistName)
                            .keyDown(Keys.ENTER)
                             .perform();
        Thread.sleep((5000));
        WebElement playListHeader = waitUntilVisible(By.cssSelector("#playlistWrapper h1"));
        Assert.assertEquals(playListHeader.getText(),playlistName);
        //delete playlist
        WebElement deletePlistBtn = waitUntilClickable(By
                .cssSelector(".btn-delete-playlist"));
        deletePlistBtn.click();

    }
}
