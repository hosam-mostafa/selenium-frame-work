package com.qacart.todo.API;

import com.qacart.todo.Config.EndPoints;
import com.qacart.todo.Objects.User;
import com.qacart.todo.Utils.UserUtils;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.List;

public class RegisterApi {
    private List<Cookie> restAssuredCookies;
    private String accessTokens;
    private String userId;
    private String firstName;
    public String getToken(){
        return this.accessTokens;
    }
    public List<Cookie> getCookies(){
        return this.restAssuredCookies;
    }
    public String getUserId(){
        return this.userId;
    }
    public String getFirstName(){
        return this.firstName;
    }

    public void register() {
        User newUser = UserUtils.generateRandomUser();
        // Given -> Request
        // When -> Type of request & End Points
        // Then -> Response
        Response response = RestAssured
                .given()
                .baseUri("http://qacart-todo.herokuapp.com")
                .header("Content-Type", "application/json")
                .body(newUser).log().all()
                .when()
                .post(EndPoints.REGISTER_API_END_POINT)
                .then().log().all().extract().response();
        if (response.statusCode() != 201){
            throw new RuntimeException("some thing went wrong with this request");
        };
        restAssuredCookies = response.detailedCookies().asList();
        accessTokens = response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");
    }

}
