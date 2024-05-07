package src.main.java.org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {
        URL url;
        try {
            url = new URL("http://localhost:4444");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        if (browser.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            return new RemoteWebDriver(url,chromeOptions);
        } else if(browser.equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            return new RemoteWebDriver(url, firefoxOptions);
        }
        return null;
    }
}
