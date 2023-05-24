import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException{
        // String playlistName = generateRandomPlaylistName();
        // login
        openUrl();
        login("vicplach123@gmail.com", "MEGAdelta06@");

        // all songs
        WebElement allSongs = driver.findElement(By.cssSelector(".songs"));
        allSongs.click();


        // Play the song
       WebElement hoverable = driver.findElement(By.cssSelector("span[role='button'] > .fa.fa-play"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();
        Thread.sleep(5000);
       /* WebElement clickable = driver.findElement(By.id("clickable"));
        new Actions(driver)
                .doubleClick(clickable)
                .perform();*/

       // WebElement playBtn = driver.findElement(By.cssSelector("span[title='Play or resume']"));
        //playBtn.click();
    }
}