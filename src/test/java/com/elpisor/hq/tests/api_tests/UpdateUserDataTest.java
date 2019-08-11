package com.elpisor.hq.tests.api_tests;

import com.elpisor.hq.api_controllers.Errors;
import com.elpisor.hq.model.api_model.User;
import com.elpisor.hq.model.api_model.UserBy;
import com.elpisor.hq.model.api_model.UserData;
import com.elpisor.hq.model.api_response_model.UserDataResponse;
import com.elpisor.hq.model.api_response_model.UserResponse;
import com.elpisor.hq.model.ui_model.UserCreds;
import com.elpisor.hq.tests.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateUserDataTest extends TestBase{

    User testUser;
    String token;

    @BeforeClass
    public void preconditions() {
        User user=TestData.createTestUserForUpdateUserData();
        testUser=app.getUserController()
                .registrationUser(user, UserResponse.class, Errors.NO_ERRORS)
                .getUser();
        testUser.setPassword(user.getPassword());
        UserCreds userCreds=UserCreds.builder()
                .email(testUser.getEmail())
                .password(testUser.getPassword())
                .returnSecureToken(true)
                .build();
        token=app.getSessionController().login(userCreds);
    }


    @Test
    public void testUpdateNameAndSurnameWithValidData() {
        String name="Name"+System.currentTimeMillis();;
        String surname="Surname"+System.currentTimeMillis();;
        UserData testUserData=UserData
                .builder()
                .name(name)
                .surname(surname)
                .build();
        UserData responseUserData=app.getUserDataController()
                .updateUserData(testUserData, token,UserDataResponse.class, Errors.NO_ERRORS).getUserData();
        assertThat(responseUserData,equalTo(testUserData));

        UserBy userBy=UserBy
                .builder()
                .uid(testUser.getUid())
                .build();
        User updateUser=app.getUserController()
                .getUserBy(userBy, UserResponse.class,Errors.NO_ERRORS).getUser();
        updateUser.setPassword(testUser.getPassword());
        assertThat(updateUser,equalTo(testUser));
    }
}
