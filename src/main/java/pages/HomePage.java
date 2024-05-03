package src.main.java.pages;
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

    @FindBy(xpath = "//*[@class='sc-1h98xa9-1 fMOJZp']/button")
    private WebElement openCartBtn;

    @FindBy(css = ".sc-124al1g-4.eeXMBo")
    private List<WebElement> items;

    @FindBy(xpath = "//main[@class = 'sc-ebmerl-4 iliWeY']/p")
    private WebElement amountOfItems;

    @FindBy(xpath = "//span[text() = 'S']")
    private WebElement sSize;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void openUrl() {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }

    public String nameOfFirstItem() {
        String nameOfFirstItem = item.getText();
        return nameOfFirstItem;
    }

    public List<String> listOfItems() {
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
    public void filterItemsBySSize() {
        sSize.click();
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElements(items));
    }
    public CartPage clickAddToCartBtn() {
        addToCartBtn.click();
        return new CartPage(driver);
    }
}
