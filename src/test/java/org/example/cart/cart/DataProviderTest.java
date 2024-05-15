package src.test.java.org.example.cart.cart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(DataProviderTest.class);

    @DataProvider(name = "test")
    public Object[][] createData() {
        return new Object[][] {
                { "Ann", "Cedric", " ", "gtrd123", 1, "1", "1990", "This is required." },
                { "Ann", "Cedric", "1", "gtrd123", 1, "1", "1990", "That email address is too short, please use a longer one."},
                { "Ann", "Cedric", "12345", "gtrd123", 1, "1", "1990", "Please use at least one letter in your username."},
        };
    }
    @Test(dataProvider = "test")
    public void test(String firstName, String lastName, String email, String password, int month, String day, String year, String errorMessage) throws InterruptedException {
        driver.get("https://login.yahoo.com/account/create");
        Thread.sleep(5000);
        WebElement firstNameField = driver.findElement(By.id("usernamereg-firstName"));
        firstNameField.click();
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = driver.findElement(By.id("usernamereg-lastName"));
        lastNameField.click();
        lastNameField.sendKeys(lastName);
        WebElement emailField = driver.findElement(By.id("usernamereg-userId"));
        emailField.click();
        emailField.sendKeys(email);
        LOGGER.info(email + " was typed into Email text field");
        Select monthSelect = new Select(driver.findElement(By.id("usernamereg-month")));
        monthSelect.selectByIndex(month);
        WebElement dayField = driver.findElement(By.id("usernamereg-day"));
        dayField.click();
        dayField.sendKeys(day);
        WebElement yearField = driver.findElement(By.id("usernamereg-year"));
        yearField.click();
        yearField.sendKeys(year);
        WebElement passwordField = driver.findElement(By.id("usernamereg-password"));
        passwordField.click();
        passwordField.sendKeys(password);
        driver.findElement(By.id("reg-submit-button")).click();
        Assert.assertEquals(driver.findElement(By.id("reg-error-userId")).getText(), errorMessage);
    }

}
