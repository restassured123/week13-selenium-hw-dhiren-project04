package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        String actual = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        String expected = "Products";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']"));
        System.out.println("Number of items : " + items.size());


    }

    @After
    public void TearDown() {

        closeBrowser();
    }


}