import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HerokuappInputTest {

    /*
    Проверить на возможность ввести различные цифровые и нецифровые значения,
    используя Keys.ARROW_UP  И Keys.ARROW_DOWN
     */

    @Test
    public void verifyInput() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/inputs");

        WebElement webElement = driver.findElement(By.tagName("input"));
        webElement.sendKeys(Keys.ENTER);

        webElement.sendKeys(Keys.ARROW_DOWN);
        assertEquals(webElement.getAttribute("value"), "-1", "smth went wrong..");
        webElement.sendKeys(Keys.ARROW_DOWN);
        assertEquals(webElement.getAttribute("value"), "-2", "smth went wrong..");
        webElement.sendKeys(Keys.ARROW_DOWN);
        assertEquals(webElement.getAttribute("value"), "-3", "smth went wrong..");
        webElement.sendKeys(Keys.ARROW_UP);
        assertEquals(webElement.getAttribute("value"), "-2", "smth went wrong..");
        webElement.sendKeys(Keys.ARROW_UP);
        assertEquals(webElement.getAttribute("value"), "-1", "smth went wrong..");
        webElement.sendKeys(Keys.ARROW_UP);
        assertEquals(webElement.getAttribute("value"), "0", "smth went wrong..");

        webElement.sendKeys("234");
        assertEquals(webElement.getAttribute("value"), "0234", "smth went wrong..");

        webElement.clear();
        webElement.sendKeys("-456");
        assertEquals(webElement.getAttribute("value"), "-456", "smth went wrong..");

        driver.quit();
    }
}
