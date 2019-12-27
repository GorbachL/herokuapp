import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HerokuappDropdownListTest {

    /*
    Взять все элементы дроп-дауна и проверить их наличие.
    Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что он выбран
     */

    @Test
    public void verifyDropdownList() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");

        List<WebElement> options = driver.findElements(By.tagName("option"));

        assertEquals(options.get(0).isSelected(), true, "Option 'Please select an option' is not selected");

        System.out.println(options.get(0).getText());

        new Select(driver.findElement(By.id("dropdown"))).selectByVisibleText("Option 1");

        assertEquals(options.get(1).isSelected(), true, "Option1 is not selected");

        System.out.println(options.get(1).getText());

        new Select(driver.findElement(By.id("dropdown"))).selectByVisibleText("Option 2");

        assertEquals(options.get(2).isSelected(), true, "Option2 is not selected");

        System.out.println(options.get(2).getText());
    }
}
