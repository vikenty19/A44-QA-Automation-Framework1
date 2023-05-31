import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist(){
        String playlistName =  generateRandomPlaylistName();
        login("vicplach123@gmail.com", "MEGAdelta06@");


        //create playlist
        WebElement plusPlaylistbtn = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[title='Create a new playlist']")));
        plusPlaylistbtn.click();
        WebElement newPlaylistbtn = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[data-testid='playlist-context-menu-create-simple']")));
        newPlaylistbtn.click();
        WebElement inputNewPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));

        inputNewPlaylist.click();
        inputNewPlaylist.clear();
        inputNewPlaylist.sendKeys(playlistName);
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();
        System.out.println(playlistName);
       //check playlist name

        WebElement newPlaylistConfirm = driver.findElement(By.cssSelector("section#playlistWrapper h1"));

        wait.until(ExpectedConditions.textToBePresentInElement(newPlaylistConfirm, playlistName));
        // check the playlist creation
        System.out.println(newPlaylistConfirm.getText());
        Assert.assertEquals(newPlaylistConfirm.getText(), playlistName);

        //rename playlist



    }



}