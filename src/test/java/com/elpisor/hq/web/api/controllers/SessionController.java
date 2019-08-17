package com.elpisor.hq.web.api.controllers;

import com.elpisor.hq.web.api.model.UserCredsApi;
import com.elpisor.hq.web.gui.model.UserCredsGui;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.with;

public class SessionController extends Controller {

    public String login (UserCredsApi userCredsApi){
        responseSpecification=null;
        return with().body(userCredsApi).post(LOGIN_URI).then().log().all().extract().body().path("idToken");
    }
}
