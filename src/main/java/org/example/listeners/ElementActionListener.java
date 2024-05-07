package src.main.java.org.example.listeners;
import org.example.utils.ScreenshotUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.List;

public class ElementActionListener implements WebDriverListener {
    @Override
    public void afterGet(WebDriver driver, String url) {
        System.out.println(url + " was opened");
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.println("element was found by locator " + locator);
        ScreenshotUtils.takeScreenshot(driver);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        System.out.println("elements was found by locator " + locator);
        ScreenshotUtils.takeScreenshot(driver);
    }

    @Override
    public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {
        System.out.println(script + " was executed");
    }

    @Override
    public void afterClick(WebElement element) {
        System.out.println("element found was clicked");
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        System.out.println("text of element found: " + result);
    }
}
