package com.elpisor.hq.api_controllers;

import com.elpisor.hq.app.ApplicationManager;
import com.elpisor.hq.model.api_model.User;
import com.elpisor.hq.model.api_response_model.UserResponse;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;

import static io.restassured.RestAssured.responseSpecification;

public class Controller {

    //private ApplicationManager app;

    public static final String BASE_URI = "https://ht-users.herokuapp.com";
    public static final String REGISTRATION_USER = "/";
    public static final String GET_USER_BY = "/user/profile";
    public static final String UPDATE_NAME_AND_SURNAME = "/user-data/name";


    public static final String LOGIN_URI =
            "https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyPassword?key=AIzaSyBp4YWndShpxXVeYDJjZ16rDgnSWQuV9k4";

    //public Specifications specification;


    public Controller() {
        //specification=new Specifications();
        RestAssured.requestSpecification=Specifications.requestSpecification;
        //RestAssured.responseSpecification=responseSpecification;
    }

    protected void setResponseSpecification(Errors error) {
        if(error.equals(Errors.NO_ERRORS))
            responseSpecification=Specifications.successfullResponseSpecification;
        if(error.equals(Errors.PHONE_ALREADY_EXISTS))
            responseSpecification=Specifications.phoneAlreadyExistsResponseSpecification;
        if(error.equals(Errors.ID_NOT_REGISTERED))
            responseSpecification=Specifications.idNotRegisteredResponseSpecification;
        if(error.equals(Errors.EMAIL_NOT_REGISTERED))
            responseSpecification=Specifications.emailNotRegisteredResponseSpecification;
        if(error.equals(Errors.PHONE__NOT_REGISTERED))
            responseSpecification=Specifications.phoneNotRegisteredResponseSpecification;
    }


}
