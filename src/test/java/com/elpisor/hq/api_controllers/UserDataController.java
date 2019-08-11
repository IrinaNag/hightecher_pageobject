package com.elpisor.hq.api_controllers;

import com.elpisor.hq.app.ApplicationManager;
import com.elpisor.hq.model.api_model.UserData;
import com.elpisor.hq.model.api_response_model.UserDataResponse;

import static io.restassured.RestAssured.*;

public class UserDataController extends Controller {


    public <T>T updateUserData(UserData userData, String token, Class<T> clazz, Errors error) {
        requestSpecification.header("X-Firebase-Auth",token);
        setResponseSpecification(error);
        return with().body(userData).post(UPDATE_NAME_AND_SURNAME).then().log().all().extract().body().as(clazz);
    }
}
