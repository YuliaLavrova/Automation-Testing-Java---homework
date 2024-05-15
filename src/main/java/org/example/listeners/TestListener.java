package src.main.java.org.example.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IClass;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class TestListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(TestListener.class);
    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("========= Test started =========");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("========= Test success =========");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.error("========= Test failed =========");
    }
}