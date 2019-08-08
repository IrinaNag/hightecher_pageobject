package com.elpisor.hq.api_controllers;

import com.elpisor.hq.app.ApplicationManager;
import com.elpisor.hq.model.api_model.User;
import com.elpisor.hq.model.api_model.UserBy;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class UserController extends Controller {

    public UserController(ApplicationManager app) {
        super(app);
    }

    public <T>T registrationUser(User user, Class<T> clazz,int code) {
        requestSpecification.basePath(REGISTRATION_USER);
        if(code==200)
            RestAssured.responseSpecification=specification.successfullResponseSpecification;
        return with()
                .body(user)
                .post()
                .as(clazz);
    }

    public <T>T getUserWithValidData(UserBy userBy,Class<T> clazz) {
        //with().body(userBy).post(GET_USER_BY).as(UserResponse.class);
        return  given()
                .body(userBy)
        .when()
                .post(GET_USER_BY)
        .then()
                .log().all()
                .spec(specification.successfullResponseSpecification)
                //.statusCode(200)
                //.assertThat()
                //.body("data",equalTo(userFromDb));
                .extract().response().as(clazz);
                //.body("data.uid", equalTo(userBy.getUid()));
    }

    public <T>T getUserWithWrongData(UserBy userBy, Class<T> clazz) {
        return  with().body(userBy)
                .post(GET_USER_BY)
                .as(clazz);
    }

}
