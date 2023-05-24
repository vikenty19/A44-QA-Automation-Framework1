import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() {
       // String text = "Dark Days";
       // String playlistName = generateRandomPlaylistName();
        // login
        openUrl();
        login("vicplach123@gmail.com", "MEGAdelta06@");