package org.example.cart;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

@Test
public class AddToCart {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("Webdriver.chromedriver", "C://chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }

    @Test
    public void addToCart() {

        WebElement firstItem = driver.findElement(By.cssSelector(".sc-124al1g-4.eeXMBo"));
        String nameOfFirstItem = firstItem.getText();
        driver.findElement(By.xpath("//div[@class = 'sc-124al1g-2 dwOYCh']/button")).click();
        WebElement itemInCart = driver.findElement(By.cssSelector(".sc-11uohgb-2.elbkhN"));
        Assert.assertEquals(itemInCart.getText(), nameOfFirstItem);
    }


    public void listAllItems() throws InterruptedException {
        List<WebElement> items = driver.findElements(By.cssSelector(".sc-124al1g-4.eeXMBo"));
        List<String> namesStr = items.stream().map(x->x.getText()).toList();
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[text() = 'Add to cart']"));
        for (WebElement button: addToCartButtons) {
            button.click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(".sc-1h98xa9-0.gFkyvN")).click();
            Thread.sleep(1000);
        }
        driver.findElement(By.xpath("//button[@class = 'sc-1h98xa9-0 gFkyvN']")).click();
        List<WebElement> itemsInCart = driver.findElements(By.cssSelector(".sc-11uohgb-2.elbkhN"));
        List<String> namesItemsInCart = itemsInCart.stream().map(x->x.getText()).toList();
        Assert.assertEquals(namesItemsInCart, namesStr);
    }

    @Test
    public void filterItems() throws InterruptedException {
        List<WebElement> items = driver.findElements(By.cssSelector(".sc-124al1g-4.eeXMBo"));
        long quantityBeforeFilter = items.stream().count();
        driver.findElement(By.xpath("//span[text() = 'S']")).click();
        Thread.sleep(5000);
        List<WebElement> itemsAfterFilter = driver.findElements(By.cssSelector(".sc-124al1g-4.eeXMBo"));
        long quantityAfterFilter = itemsAfterFilter.stream().count();
        Assert.assertTrue(quantityBeforeFilter > quantityAfterFilter, "filter isn't working correctly");
    }

    @Test
    public void countItemsAfterFilter() throws InterruptedException {
        boolean result = false;
        WebElement quantityBeforeFilter = driver.findElement(By.xpath("//main[@class = 'sc-ebmerl-4 iliWeY']/p"));
        String quantityBeforeFilterStr = quantityBeforeFilter.getText();
        String[] str1 = quantityBeforeFilterStr.split(" ");
        driver.findElement(By.xpath("//span[text() = 'S']")).click();
        Thread.sleep(5000);
        WebElement quantityAfterFilter = driver.findElement(By.xpath("//main[@class = 'sc-ebmerl-4 iliWeY']/p"));
        String quantityAfterFilterStr = quantityAfterFilter.getText();
        String[] str2 = quantityAfterFilterStr.split(" ");
        int first = Integer. parseInt(str1[0]);
        int second = Integer. parseInt(str2[0]);
        Assert.assertTrue(first > second, "filter isn't working correctly");

    }

    @AfterTest
    public void closeSession() {
        driver.quit();
    }
}
