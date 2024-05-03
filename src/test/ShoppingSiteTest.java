package src.test;

import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.example.utils.ScreenshotUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

@Test
public class ShoppingSiteTest extends BaseTest{

    @Test
    public void addToCartTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        String nameOfItem = homePage.nameOfFirstItem();
        ScreenshotUtils.takeScreenshot(driver);
        CartPage cartPage = homePage.clickAddToCartBtn();;
        String itemInCart = cartPage.nameOfItemInCart();
        ScreenshotUtils.takeScreenshot(driver);
        Assert.assertEquals(itemInCart, nameOfItem);
    }

    @Test
    public void listAllItemsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        List<String> namesStr = homePage.listOfItems();
        ScreenshotUtils.takeScreenshot(driver);
        CartPage cartPage = homePage.clickAllAddToCartBtn();
        List<String> namesItemsInCart = cartPage.nameOfAllItemsInCart();
        ScreenshotUtils.takeScreenshot(driver);
        Assert.assertEquals(namesItemsInCart, namesStr);
    }

    @Test
    public void filterItemsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        long quantityBeforeFilter = homePage.listOfItems().size();
        ScreenshotUtils.takeScreenshot(driver);
        homePage.filterItemsBySSize();
        long quantityAfterFilter = homePage.listOfItems().size();
        ScreenshotUtils.takeScreenshot(driver);
        Assert.assertTrue(quantityBeforeFilter > quantityAfterFilter, "Filter isn't working correctly");
    }

    @Test
    public void countItemsAfterFilterTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        ScreenshotUtils.takeScreenshot(driver);
        int first = homePage.countItemsDisplayed();
        homePage.filterItemsBySSize();
        ScreenshotUtils.takeScreenshot(driver);
        int second = homePage.countItemsDisplayed();
        Assert.assertTrue(first > second, "Filter isn't working correctly");
    }

}
