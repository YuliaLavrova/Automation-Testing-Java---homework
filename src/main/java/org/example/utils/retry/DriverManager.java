package src.main.java.org.example.utils.retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.enums.Capability;
import org.example.listeners.ElementActionListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class DriverManager {
    static WebDriver driver;
    static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

    private static Logger LOGGER = LogManager.getLogger(DriverManager.class);

    public static WebDriver getDriver() {
        if (localDriver.get() == null) {
            driver = DriverFactory.createDriver(PropertyReader.getConfigProperty(Capability.BROWSER));
            LOGGER.info("Driver is " + driver);
            EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator(new ElementActionListener());
            driver = decorator.decorate(driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            localDriver.set(driver);
            return driver;
        } else {
            return localDriver.get();
        }
    }

    public static void quitDriver() {
        localDriver.get().quit();
        localDriver.set(null);
    }

}
