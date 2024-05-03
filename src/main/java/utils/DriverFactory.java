package src.main.java.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("Webdriver.chrome.driver", "C://chromedriver");
            return new ChromeDriver();
        } else if(browser.equals("firefox")) {
            System.setProperty("Webdriver.firefox.driver", "C://geckodriver");
            return new FirefoxDriver();
        }
        return null;
    }
}
