package com.qacart.todo.Pages;

import com.qacart.todo.Base.BasePage;
import com.qacart.todo.Config.EndPoints;
import com.qacart.todo.Utils.ConfigUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[data-testid=\"welcome\"]")
    WebElement welcomeMessage;
    @FindBy(css = "[data-testid=\"add\"]")
    WebElement addButton;
    @FindBy(css = "[data-testid=\"todo-item\"]")
    WebElement todoItem;
    @FindBy(css = "[data-testid=\"delete\"]")
    WebElement deleteButton;
    @FindBy(css = "[data-testid=\"no-todos\"]")
    WebElement noTodosMessage;
    @Step
    public boolean isWelcomeMessageDisplayed(){

        return welcomeMessage.isDisplayed();
    }
    @Step
    public NewTodoPage clickOnPlusButton(){

        addButton.click();
        return new NewTodoPage(driver);
    }
    @Step
    public String getTodoText(){

        return todoItem.getText();
    }
    @Step
    public TodoPage clickOnDeleteButton() {

        deleteButton.click();
        return this;
    }
    @Step
    public boolean isNoTodosMessageDisplayed(){

        return noTodosMessage.isDisplayed();
    }
    @Step
    public TodoPage load(){
        driver.get(ConfigUtil.getInstance().getBaseUrl());
        return this;
    }
}
