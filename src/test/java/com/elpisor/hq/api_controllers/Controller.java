package com.elpisor.hq.api_controllers;

/*import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;*/

import com.elpisor.hq.app.ApplicationManager;
import io.restassured.RestAssured;

public class Controller {

    private ApplicationManager app;

    public static final String BASE_URI = "https://ht-users.herokuapp.com";
    public static final String REGISTRATION_USER = "/";
    public static final String GET_USER_BY = "/user/profile";

    public Specifications specification=new Specifications();


    public Controller(ApplicationManager app) {
        this.app=app;
        RestAssured.requestSpecification=specification.requestSpecification;
        //RestAssured.responseSpecification=responseSpecification;
    }

 }
