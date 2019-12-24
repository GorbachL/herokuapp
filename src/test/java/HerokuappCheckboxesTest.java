import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HerokuappCheckboxesTest {

    /*
    проверить, что первый чекбокс unchecked,
    отметить первый чекбокс,
    проверить что он checked.
    Проверить, что второй чекбокс checked,
    сделать unheck, проверить, что он unchecked
     */

    @Test
    public void Checkboxes() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        assertEquals(checkboxes.get(0).isSelected(), false, "First checkbox is selected");
        checkboxes.get(0).click();
        assertEquals(checkboxes.get(0).isSelected(), true, "First checkbox is NOT selected");

        assertEquals(checkboxes.get(1).isSelected(), true, "Second checkbox is NOT selected");
        checkboxes.get(1).click();
        assertEquals(checkboxes.get(1).isSelected(), false, "Second checkbox is selected");

        driver.quit();

    }
}
