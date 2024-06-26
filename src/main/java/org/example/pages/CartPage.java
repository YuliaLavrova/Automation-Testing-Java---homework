package src.main.java.org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(css = ".sc-1h98xa9-0.gFkyvN")
    private WebElement closeCartBtn;

    @FindBy(css = ".sc-11uohgb-2.elbkhN")
    private WebElement itemInCart;

    @FindBy(css = ".sc-11uohgb-2.elbkhN")
    private List<WebElement> allItemsInCart;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String nameOfItemInCart() {
        String nameOfItemInCart = itemInCart.getText();
        return nameOfItemInCart;
    }

    public List<String> nameOfAllItemsInCart() {
        List<WebElement> itemsInCart = allItemsInCart;
        List<String> nameOfAllItemsInCart = itemsInCart.stream().map(x->x.getText()).toList();
        return nameOfAllItemsInCart;
    }

    public void closeCartBtn() {
        closeCartBtn.click();
    }
}
