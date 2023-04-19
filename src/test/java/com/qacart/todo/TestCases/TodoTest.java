package com.qacart.todo.TestCases;

import com.qacart.todo.API.RegisterApi;
import com.qacart.todo.API.TaskApi;
import com.qacart.todo.Base.BaseTest;
import com.qacart.todo.Factory.DriverFactory;
import com.qacart.todo.Pages.LoginPage;
import com.qacart.todo.Pages.NewTodoPage;
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
@Feature("TODO Feature")
public class TodoTest extends BaseTest {
    @Story("Add Todo")
    @Description("")
    @Test(description = "Should Be Able add a new Todo Correctly")
    public void shouldBeAbleToAddNewTodo(){
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TodoPage todoPage  = new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        String actualResult = todoPage
                .load()
                .clickOnPlusButton()
                .addNewTodo("selenium")
                .getTodoText();

        Assert.assertEquals(actualResult,"selenium");
    }
    @Story("Delete Todo")
    @Description("")
    @Test (description = "Should be able to delete Todo Correctly")
    public void shouldBeAbleToDeleteTodo(){
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TaskApi taskApi = new TaskApi();
        taskApi.addTask(registerApi.getToken());

        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());

        boolean isNoTodoMsgIsDisplayed = todoPage
                .load()
                .clickOnDeleteButton()
                .isNoTodosMessageDisplayed();

        Assert.assertTrue(isNoTodoMsgIsDisplayed);
    }
}
