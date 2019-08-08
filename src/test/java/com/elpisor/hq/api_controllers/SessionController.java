package com.elpisor.hq.api_controllers;

import com.elpisor.hq.app.ApplicationManager;
import com.elpisor.hq.model.ui_model.UserCreds;

import static io.restassured.RestAssured.with;

public class SessionController extends Controller {

    public SessionController(ApplicationManager app) {
        super(app);
    }

    public String login (UserCreds userCreds){
        //TODO
        return with().body(userCreds)
                .param("key","AIzaSyBp4YWndShpxXVeYDJjZ16rDgnSWQuV9k4")
                .post("https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyPassword")
                .body().path("idToken");

    }
}
