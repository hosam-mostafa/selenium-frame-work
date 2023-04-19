package com.qacart.todo.Utils;

import com.github.javafaker.Faker;
import com.qacart.todo.Objects.User;

public class UserUtils {
    public static User generateRandomUser(){
        //Make faker java generate random data
        String firstName = new Faker().name().firstName(); // random name
        String lastName = new Faker().name().lastName();
        String email = new Faker().internet().emailAddress();
        String password = "Hosam123";
        User user = new User(firstName,lastName,email,password);
        return user;
    }
}
