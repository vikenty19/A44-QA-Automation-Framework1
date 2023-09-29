import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongs extends BaseTest {

    @Test
    public void playSong()  {

        login("vicplach123@gmail.com", "MEGAdelta06@");
        // all songs
        goToAllSongsTub();
        // Play the song
        playSongWithPlayBtn();
// assert is equalizer displayed
        isEqualizerDisplayed();
// is pause btn displayed
        isPauseBtnDisplayed();
    }

    @Test
    public void playSongOverPlayBtn() {
        login("vicplach123@gmail.com", "MEGAdelta06@");
        goToAllSongsTub();
        //choose the song from the allSongs list
        WebElement selectedSong = waitUntilClickable(By.cssSelector("tr:nth-child(6) .title"));
        selectedSong.click();
        playSongWithPlayBtn();
        isEqualizerDisplayed();

    }
    private void isPauseBtnDisplayed() {
        WebElement pauseBtn = driver.findElement(By.cssSelector("span[role='button'] > .fa.fa-pause"));
        new Actions(driver)
                .moveToElement(pauseBtn)
                .perform();
        pauseBtn.click();
        Assert.assertTrue(pauseBtn.isDisplayed());
        System.out.println("Is pause btn displayed?  "+ pauseBtn.isDisplayed());
    }

    private void isEqualizerDisplayed() {
        WebElement equalizer = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".bars")));
        Assert.assertTrue(equalizer.isDisplayed());
        System.out.println("Is equalizer displyed  "+ equalizer.isDisplayed());
    }

    private void playSongWithPlayBtn() {
        WebElement plyBtn = driver.findElement(By.cssSelector("span.play .fa"));
        new Actions(driver)
                .moveToElement(plyBtn)
                .perform();
        plyBtn.click();
    }

    private void goToAllSongsTub() {
        WebElement allSongs = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".songs")));
        allSongs.click();
    }
}