package com.elpisor.hq.api_controllers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static com.elpisor.hq.api_controllers.Controller.BASE_URI;
import static org.hamcrest.CoreMatchers.equalTo;

public class Specifications {

    public RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
    public ResponseSpecification successfullResponseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody("message", equalTo("ok"))
            .build();

}
