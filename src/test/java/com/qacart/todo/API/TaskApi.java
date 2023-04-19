package com.qacart.todo.API;

import com.github.dockerjava.api.model.Endpoint;
import com.qacart.todo.Config.EndPoints;
import com.qacart.todo.Objects.Task;
import com.qacart.todo.Utils.ConfigUtil;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TaskApi {
    public void addTask(String token){
        Task task = new Task(false,"learn Selenium");
        Response response = given().baseUri(ConfigUtil.getInstance().getBaseUrl())
                .header("Content-Type","application/json")
                .body(task)
                .auth().oauth2(token)
        .when()
                .post(EndPoints.TASKS_API_END_POINTS)
        .then()
                .log().all().extract().response();
        if(response.statusCode() != 201){
            throw new RuntimeException("Some thing went wrong when adding TODO");
        }
    }

}
