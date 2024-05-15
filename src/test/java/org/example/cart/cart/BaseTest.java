package src.test.java.org.example.cart.cart;

import org.example.enums.Capability;
import org.example.listeners.ElementActionListener;
import org.example.listeners.TestListener;
import org.example.utils.DriverFactory;
import org.example.utils.DriverManager;
import org.example.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.*;
import org.example.listeners.TestListener;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void quit(){
        DriverManager.quitDriver();
    }
}
