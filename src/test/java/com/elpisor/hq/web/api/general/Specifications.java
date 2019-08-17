package com.elpisor.hq.web.api.general;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.elpisor.hq.web.api.controllers.Controller.BASE_URI;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;

public class Specifications {

    public static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
    public static ResponseSpecification successfullResponseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody("numeric",equalTo(2000))
            .expectBody("message", equalTo("ok"))
            .build();
    public static ResponseSpecification emailAlreadyExistsResponseSpecification=createUnsuccessfullResponseSpecification
            (409,4090,"User with such email is already registered");
    public static ResponseSpecification phoneAlreadyExistsResponseSpecification= createUnsuccessfullResponseSpecification
            (409,4091,"User with such phone is already registered");
    public static ResponseSpecification skillAlreadyExistsResponseSpecification= createUnsuccessfullResponseSpecification
            (409,4092,"User's list of skills already contains skill with such id");
    public static ResponseSpecification regionAlreadyExistsResponseSpecification= createUnsuccessfullResponseSpecification
            (409,4093,"User's list of hiring region already containd such region");
    public static ResponseSpecification wrongEmailResponseSpecification= createUnsuccessfullResponseSpecification
            (400,4000,"Email format is wrong");
    public static ResponseSpecification wrongPhoneFormatResponseSpecification= createUnsuccessfullResponseSpecification
            (400,4001,"Phone number format is wrong");
    public static ResponseSpecification wrongNameLengthSpecification= createUnsuccessfullResponseSpecification
            (400,4002,"Wrong name length");
    public static ResponseSpecification wrongUsernameLengthResponseSpecification= createUnsuccessfullResponseSpecification
            (400,4002,"Wrong username length");
    public static ResponseSpecification wrongSurnameLengthResponseSpecification= createUnsuccessfullResponseSpecification
            (400,4002,"Wrong surname length");
    public static ResponseSpecification idNotRegisteredResponseSpecification= createUnsuccessfullResponseSpecification
            (404,4040,"User with such id not registered");
    public static ResponseSpecification emailNotRegisteredResponseSpecification= createUnsuccessfullResponseSpecification
            (404,4042,"User with such email not registered");
    public static ResponseSpecification phoneNotRegisteredResponseSpecification= createUnsuccessfullResponseSpecification
            (404,4041,"User with such phone number not registered");
//    public ResponseSpecification emailAlreadyExistsResponseSpecification;
//    public ResponseSpecification emailAlreadyExistsResponseSpecification;
//    public ResponseSpecification emailAlreadyExistsResponseSpecification;
//    public ResponseSpecification emailAlreadyExistsResponseSpecification;
//    public ResponseSpecification emailAlreadyExistsResponseSpecification;



    private static ResponseSpecification createUnsuccessfullResponseSpecification(int code, int numeric, String message) {
        return new ResponseSpecBuilder()
                .expectStatusCode(code)
                .expectBody("numeric",equalTo(numeric))
                .expectBody("message", equalTo(message))
                .expectBody("data",nullValue())
                .build();
    }
}
