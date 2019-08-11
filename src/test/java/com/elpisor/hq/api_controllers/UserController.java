package com.elpisor.hq.api_controllers;

import com.elpisor.hq.app.ApplicationManager;
import com.elpisor.hq.model.api_model.User;
import com.elpisor.hq.model.api_model.UserBy;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class UserController extends Controller {

    public <T> T registrationUser(User user, Class<T> clazz, Errors error) {
        setResponseSpecification(error);
        return with().body(user).post(REGISTRATION_USER).then().log().all().extract().body().as(clazz);
    }


    public <T> T getUserBy(UserBy userBy, Class<T> clazz, Errors error) {
        setResponseSpecification(error);
        return with().body(userBy).post(GET_USER_BY).then().log().all().extract().body().as(clazz);
    }


}
