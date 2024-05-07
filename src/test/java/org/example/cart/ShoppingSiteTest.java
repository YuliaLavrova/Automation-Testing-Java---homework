package src.test.java.org.example.cart;

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
        String itemOnHomePage = homePage.nameOfItem(0);
        CartPage cartPage = homePage.clickAddToCartFirstBtn();
        String itemInCart = cartPage.nameOfItemInCart();
        Assert.assertEquals(itemInCart, itemOnHomePage);
    }

    @Test
    public void listAllItemsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        List<String> namesStr = homePage.namesOfAllItems();
        CartPage cartPage = homePage.clickAllAddToCartBtn();
        List<String> namesItemsInCart = cartPage.nameOfAllItemsInCart();
        Assert.assertEquals(namesItemsInCart, namesStr);
    }

    @Test
    public void filterItemsTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        long quantityBeforeFilter = homePage.namesOfAllItems().size();
        homePage.filterItemsBySSize();
        long quantityAfterFilter = homePage.namesOfAllItems().size();
        Assert.assertTrue(quantityBeforeFilter > quantityAfterFilter, "Filter isn't working correctly");
    }

    @Test
    public void countItemsAfterFilterTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        int first = homePage.countItemsDisplayed();
        homePage.filterItemsBySSize();
        int second = homePage.countItemsDisplayed();
        Assert.assertTrue(first > second, "Filter isn't working correctly");
    }

}
