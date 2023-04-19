package com.qacart.todo.Base;

import com.qacart.todo.Factory.DriverFactory;
import com.qacart.todo.Utils.CookieUtils;
import io.qameta.allure.Allure;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BaseTest {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    public WebDriver getDriver(){
        return this.driver.get();
    }
    @BeforeMethod

    public void setUp(){

        WebDriver driver = new DriverFactory().initializeDriver();
        setDriver(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        String testCaseName = result.getMethod().getMethodName();
        File destFile = new File("target" + File.separator + "ScreenShots" + File.separator + testCaseName + ".png");
        takeScreenSHot(destFile);
        getDriver().quit();

    }
    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies){
        List<org.openqa.selenium.Cookie> seleniumCookies = CookieUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
        for (org.openqa.selenium.Cookie cookie: seleniumCookies){
            getDriver().manage().addCookie(cookie);
        }
    }

    public void takeScreenSHot(File destinationOfFile){
        File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, destinationOfFile);
            InputStream inputStream = new FileInputStream(destinationOfFile);
            Allure.addAttachment("Screen Shot" ,inputStream );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
