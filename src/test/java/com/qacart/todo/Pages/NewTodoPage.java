package com.qacart.todo.Pages;

import com.qacart.todo.Base.BasePage;
import com.qacart.todo.Config.EndPoints;
import com.qacart.todo.Utils.ConfigUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {


    public NewTodoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement newTodoInput;
    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement newTodoSubmit;

    @Step
    public TodoPage addNewTodo(String item){
        newTodoInput.sendKeys(item);
        newTodoSubmit.click();
        return new TodoPage(driver);
    }

    @Step
    public NewTodoPage load(){
        driver.get(ConfigUtil.getInstance().getBaseUrl() + EndPoints.NEW_TODO_API_END_POINT);
        return this;
    }
}
