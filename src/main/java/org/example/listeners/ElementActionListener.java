package src.main.java.org.example.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utils.ScreenshotUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.IClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;

public class ElementActionListener implements WebDriverListener {

    private static final Logger LOGGER = LogManager.getLogger(ElementActionListener.class);
    @Override
    public void afterGet(WebDriver driver, String url) {
        LOGGER.info(url + " was opened");
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        LOGGER.info("element was found by locator " + locator);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        LOGGER.info("elements was found by locator " + locator);
    }

    @Override
    public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {
        LOGGER.info(script + " was executed");
    }

    @Override
    public void afterClick(WebElement element) {
        LOGGER.info("element found was clicked");
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        LOGGER.info("text of element found: " + result);
    }
}