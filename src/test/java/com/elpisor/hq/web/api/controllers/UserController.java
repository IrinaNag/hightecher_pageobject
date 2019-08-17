package com.elpisor.hq.web.api.controllers;

import com.elpisor.hq.web.api.general.Errors;
import com.elpisor.hq.web.api.model.User;
import com.elpisor.hq.web.api.model.UserBy;

import static io.restassured.RestAssured.*;

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
