import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongs extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        // String playlistName = generateRandomPlaylistName();
        // login
        openUrl();
        login("vicplach123@gmail.com", "MEGAdelta06@");

        // all songs
        WebElement allSongs = driver.findElement(By.cssSelector(".songs"));
        allSongs.click();


        // Play the song
        WebElement plyBtn = driver.findElement(By.cssSelector("span.play .fa"));
        new Actions(driver)
                .moveToElement(plyBtn)
                .perform();
        plyBtn.click();
        Thread.sleep(3000);


// assert is equalizer displayed
        WebElement equalizer = driver.findElement(By.cssSelector(".bars"));
        Assert.assertTrue(equalizer.isDisplayed());
// is pause btn displayed
        WebElement pauseBtn = driver.findElement(By.cssSelector("span[role='button'] > .fa.fa-pause"));
        new Actions(driver)
                .moveToElement(pauseBtn)
                .perform();
        pauseBtn.click();
        Assert.assertTrue(pauseBtn.isDisplayed());
    }
}