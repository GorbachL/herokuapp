import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HerokuappHoversTest {

    /*
    Сделать цепочку из действий: наведение на профиль,
    проверка имени, клик по ссылке, проверка 404 ошибки.
    Повторить для каждого из профилей. Использовать класс Actions
     */

    @Test
    public void verifyHovers() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/hovers");

        Actions action = new Actions(driver);

        List<WebElement> webElements = driver.findElements(By.xpath("//div[@class='figure']"));
        webElements.get(0).click();
        assertEquals(webElements.get(0).getText(), "name: user1\n" + "View profile", "Not performed");

        action.moveToElement(driver.findElement(By.xpath("//a[text()='View profile']"))).click().build().perform();

        driver.getCurrentUrl();
        String string = driver.findElement(By.xpath("//*[text()='Not Found']")).getText();
        assertEquals(string, "Not Found", "Not performed 2");

        driver.navigate().back();

        List<WebElement> webElements2 = driver.findElements(By.xpath("//div[@class='figure']"));
        webElements2.get(1).click();
        assertEquals(webElements2.get(1).getText(), "name: user2\n" + "View profile", "Not performed");

        List<WebElement> webElementList = driver.findElements(By.xpath("//a[text()='View profile']"));
        webElementList.get(1).click();

        driver.getCurrentUrl();
        String string2 = driver.findElement(By.xpath("//*[text()='Not Found']")).getText();
        assertEquals(string2, "Not Found", "Not performed 2");

        driver.navigate().back();

        List<WebElement> webElements3 = driver.findElements(By.xpath("//div[@class='figure']"));
        webElements3.get(2).click();
        assertEquals(webElements3.get(2).getText(), "name: user3\n" + "View profile", "Not performed");

        List<WebElement> webElementList2 = driver.findElements(By.xpath("//a[text()='View profile']"));
        webElementList2.get(2).click();

        driver.getCurrentUrl();
        String string3 = driver.findElement(By.xpath("//*[text()='Not Found']")).getText();
        assertEquals(string2, "Not Found", "Not performed 2");

        driver.navigate().back();

        driver.quit();
    }
}

