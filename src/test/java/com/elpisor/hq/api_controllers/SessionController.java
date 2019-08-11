package com.elpisor.hq.api_controllers;

import com.elpisor.hq.app.ApplicationManager;
import com.elpisor.hq.model.ui_model.UserCreds;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.with;

public class SessionController extends Controller {

    public String login (UserCreds userCreds){
        responseSpecification=null;
        return with().body(userCreds).post(LOGIN_URI).then().log().all().extract().body().path("idToken");
    }
}
