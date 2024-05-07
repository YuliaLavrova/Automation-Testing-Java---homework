package src.main.java.org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//button[text() = 'Add to cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//button[text() = 'Add to cart']")
    private List<WebElement> addToCartAllBtn;

    @FindBy(css = ".sc-124al1g-4.eeXMBo")
    private WebElement item;

    @FindBy(css = ".sc-124al1g-4.eeXMBo")
    private List<WebElement> items;

    @FindBy(xpath = "//main[@class = 'sc-ebmerl-4 iliWeY']/p")
    private WebElement amountOfItems;

    @FindBy(xpath = "//span[text() = 'S']")
    private WebElement sSize;

    @FindBy(xpath = "//button[@class = 'sc-1h98xa9-0 gFkyvN']")
    private WebElement openCartBtn;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void openUrl() {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }

    public String nameOfItem(int index) {
        String itemText = item.getText();
        return itemText;
    }

    public List<String> namesOfAllItems() {
        List<WebElement> allItems = items;
        List<String> namesStr = allItems.stream().map(x->x.getText()).toList();
        return namesStr;
    }

    public CartPage clickAllAddToCartBtn() {
        List<WebElement> addToCartButtons = new ArrayList<>(addToCartAllBtn);
        for (WebElement button: addToCartButtons) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", button);
        }
        return new CartPage(driver);
    }

    public int countItemsDisplayed() {
        String amountStr = amountOfItems.getText();
        String[] str = amountStr.split(" ");
        int amount = Integer.parseInt(str[0]);
        return amount;
    }
    public void filterItemsBySSize() throws InterruptedException {
        sSize.click();
        Thread.sleep(5000);
//        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfAllElements(items));
    }
    public CartPage clickAddToCartFirstBtn() {
        addToCartBtn.click();
        return new CartPage(driver);
    }

    public CartPage clickAddToCartBtn(int index) {
        ((JavascriptExecutor)driver).executeScript("arguments[index].click();", addToCartAllBtn.get(index));
        return new CartPage(driver);
    }

    public void openCart() {
        openCartBtn.click();
    }

}
