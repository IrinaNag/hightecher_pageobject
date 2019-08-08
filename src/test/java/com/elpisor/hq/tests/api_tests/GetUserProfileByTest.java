package com.elpisor.hq.tests.api_tests;

import com.elpisor.hq.model.api_model.User;
import com.elpisor.hq.model.api_model.UserBy;
import com.elpisor.hq.model.api_response_model.UnsuccessfulResponse;
import com.elpisor.hq.model.api_response_model.UserResponse;
import com.elpisor.hq.model.ui_model.UserCreds;
import com.elpisor.hq.tests.TestBase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

import static io.restassured.RestAssured.*;

public class GetUserProfileByTest extends TestBase {



/*    @BeforeClass
    public void preconditions(){
        User testUser=User.builder().username().email().phone().password().build();
        registrationUser(testUser, UserResponse.class);
    }*/

    @Test
    public void testGetUserProfileByIdWithValidData() {
        UserBy userBy=UserBy.builder().uid("yO9iLzHsasOMVJ9JWe8eduvWw603").build();
        UserResponse userResponse=app.getUserController().getUserWithValidData(userBy,UserResponse.class);
        System.out.println(userResponse);
    }



    @Test
    public void testGetUserProfileByIdWithWrongData () {
        UserBy userBy=UserBy.builder().uid("yO9iLzHsasOMVJ9JWe8eduvWw").build();
        UnsuccessfulResponse unsuccessfulResponse=app.getUserController().getUserWithWrongData(userBy, UnsuccessfulResponse.class);
        System.out.println(unsuccessfulResponse);
    }

    @Test
    public void testGetUserProfileByEmailWithValidData() {

    }

    @Test
    public void testGetUserProfileByEmailWithWrongData() {

    }

    @Test
    public void testGetUserProfileByPhoneWithValidData() {

    }

    @Test
    public void testGetUserProfileByPhoneWithWrongData() {

    }

    @Test
    public void testLogin() {
        UserCreds userCreds=UserCreds.builder().email("jiqezaddex-1403@yopmail.com").password("AAaa123456").build();
        System.out.println(app.getSessionController().login(userCreds));

    }


}
