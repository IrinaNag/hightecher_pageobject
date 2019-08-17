package com.elpisor.hq.web.api.controllers;

import com.elpisor.hq.web.api.general.Errors;
import com.elpisor.hq.web.api.model.UserData;

import static io.restassured.RestAssured.*;

public class UserDataController extends Controller {


    public <T>T updateNameAndSurname(UserData userData, String token, Class<T> clazz, Errors error) {
        requestSpecification.header("X-Firebase-Auth",token);
        setResponseSpecification(error);
        return with().body(userData).post(UPDATE_NAME_AND_SURNAME).then().log().all().extract().body().as(clazz);
    }

    public <T>T updateEmail(UserData userData, String token, Class<T> clazz, Errors error) {
        requestSpecification.header("X-Firebase-Auth",token);
        setResponseSpecification(error);
        return with().body(userData).post(UPDATE_EMAIL).then().log().all().extract().body().as(clazz);
    }

    public <T>T updatePhone(UserData userData, String token, Class<T> clazz, Errors error) {
        requestSpecification.header("X-Firebase-Auth",token);
        setResponseSpecification(error);
        return with().body(userData).post(UPDATE_PHONE).then().log().all().extract().body().as(clazz);
    }
}
