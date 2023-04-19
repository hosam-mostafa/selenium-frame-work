package com.qacart.todo.Pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.qacart.todo.Base.BasePage;
import com.qacart.todo.Utils.ConfigUtil;
import com.qacart.todo.Utils.PropertiesUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(css = "[data-testid=\"email\"]")
    private WebElement emailInput;
    @FindBy(css = "[data-testid=\"password\"]")
    private WebElement passwordInput;
    @FindBy(css = "[data-testid=\"submit\"]")
    private WebElement submit;


    @Step("Load The Login Page")
    public LoginPage load (){
        driver.get(ConfigUtil.getInstance().getBaseUrl());
        return this;
    }
    @Step
    public TodoPage login(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submit.click();
        return new TodoPage(driver);

    }

}
