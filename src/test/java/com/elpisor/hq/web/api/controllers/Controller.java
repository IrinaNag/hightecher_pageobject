package com.elpisor.hq.web.api.controllers;

import com.elpisor.hq.web.api.general.Errors;
import com.elpisor.hq.web.api.general.Specifications;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.responseSpecification;

public class Controller {

    public static final String BASE_URI = "https://ht-users.herokuapp.com";
    public static final String REGISTRATION_USER = "/";
    public static final String GET_USER_BY = "/user/profile";
    public static final String UPDATE_NAME_AND_SURNAME = "/user-data/name";
    public static final String UPDATE_EMAIL="/user-data/email";
    public static final String UPDATE_PHONE="/user-data/phone";


    public static final String LOGIN_URI =
            "https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyPassword?key=AIzaSyBp4YWndShpxXVeYDJjZ16rDgnSWQuV9k4";


    public Controller() {
        RestAssured.requestSpecification= Specifications.requestSpecification;
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
        if (error.equals(Errors.WRONG_NAME_LENGTH))
            responseSpecification=Specifications.wrongNameLengthSpecification;
        if (error.equals(Errors.WRONG_SURNAME_LENGTH))
            responseSpecification=Specifications.wrongSurnameLengthResponseSpecification;
        if (error.equals(Errors.WRONG_EMAIL))
            responseSpecification=Specifications.wrongEmailResponseSpecification;
        if (error.equals(Errors.WRONG_PHONE))
            responseSpecification=Specifications.wrongPhoneFormatResponseSpecification;
    }

}
