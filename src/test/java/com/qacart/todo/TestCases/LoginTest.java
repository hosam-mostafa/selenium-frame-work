package com.qacart.todo.TestCases;

import com.qacart.todo.Base.BaseTest;
import com.qacart.todo.Factory.DriverFactory;
import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.Pages.TodoPage;
import com.qacart.todo.Utils.ConfigUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Feature("Auth Feature")
public class LoginTest extends BaseTest {
    @Story("Login With Email And Password")
    @Description("It will login by filling the email and password and navigate to Todo Page")
    @Test(description = "Test the login Functionality")
    public void shouldBeAbleToLoginWithEmailAndPassword(){

        LoginPage loginPage = new LoginPage(getDriver());

        boolean isWelcomeMessageDisplayed = loginPage
                .load()
                .login(ConfigUtil.getInstance().getEmail(),ConfigUtil.getInstance().getPassword())
                .isWelcomeMessageDisplayed();

        Assert.assertTrue(isWelcomeMessageDisplayed);
    }


}

