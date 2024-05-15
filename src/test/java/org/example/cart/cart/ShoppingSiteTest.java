package src.test.java.org.example.cart.cart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class ShoppingSiteTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(ShoppingSiteTest.class);

    @Test(testName = "ShoppingSiteTest")
    public void addToCartTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        String itemOnHomePage = homePage.nameOfItem(17);
        LOGGER.info(itemOnHomePage + " is added to cart");
        CartPage cartPage = homePage.clickAddToCartFirstBtn();
        String itemInCart = cartPage.nameOfItemInCart();
        LOGGER.info(itemInCart + " is in cart");
        Assert.assertEquals(itemInCart, itemOnHomePage);
    }

    @Test
    public void listAllItemsTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        List<String> namesStr = homePage.namesOfAllItems();
        LOGGER.info(namesStr + " are displayed on the home page");
        CartPage cartPage = homePage.clickAllAddToCartBtn();
        List<String> namesItemsInCart = cartPage.nameOfAllItemsInCart();
        LOGGER.info(namesItemsInCart + " are added to cart");
        Assert.assertEquals(namesItemsInCart, namesStr);
    }

    @Test
    public void filterItemsTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        long quantityBeforeFilter = homePage.namesOfAllItems().size();
        LOGGER.info("The amount of items before is " + quantityBeforeFilter);
        homePage.filterItemsBySSize();
        long quantityAfterFilter = homePage.namesOfAllItems().size();
        LOGGER.info("The amount of items after is " + quantityAfterFilter);
        Assert.assertTrue(quantityBeforeFilter > quantityAfterFilter, "Filter isn't working correctly");
    }

    @Test
    public void countItemsAfterFilterTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        int first = homePage.countItemsDisplayed();
        LOGGER.info("The amount of items before is " + first);
        homePage.filterItemsBySSize();
        int second = homePage.countItemsDisplayed();
        LOGGER.info("The amount of items after is " + second);
        Assert.assertTrue(first > second, "Filter isn't working correctly");
    }

}
