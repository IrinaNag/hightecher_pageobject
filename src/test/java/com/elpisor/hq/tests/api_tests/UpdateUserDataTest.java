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
    UserBy userBy;

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

        userBy=UserBy
                .builder()
                .uid(testUser.getUid())
                .build();
    }


    @Test
    public void testUpdateNameAndSurnameWithValidData() {
        String name=TestData.createValidName();
        String surname=TestData.createValidSurname();
        UserData testUserData=UserData
                .builder()
                .name(name)
                .surname(surname)
                .build();
        UserData responseUserData=app.getUserDataController()
                .updateUserData(testUserData, token,UserDataResponse.class, Errors.NO_ERRORS).getUserData();
        assertThat(responseUserData,equalTo(testUserData));

        User updateUser=app.getUserController()
                .getUserBy(userBy, UserResponse.class,Errors.NO_ERRORS).getUser();
        updateUser.setPassword(testUser.getPassword());
        testUser.setName(name);
        testUser.setSurname(surname);
        assertThat(updateUser,equalTo(testUser));
    }

    @Test
    public void testUpdateNameAndSurnameWithWrongNameLength() {

    }

    @Test
    public void testUpdateNameAndSurnameWithWrongSurnameLength() {

    }

    @Test
    public void testUpdateNameAndSurnameIfAccountDisabled() {

    }

    @Test
    public void testUpdateEmailWithValidData() {
        String email=TestData.createValidEmail();
        UserData userData=UserData
                .builder()
                .email(email)
                .build();
        UserData responseUserData=app.getUserDataController()
                .updateUserData(userData,token,UserDataResponse.class,Errors.NO_ERRORS).getUserData();
        assertThat(responseUserData,equalTo(userData));

        User updateUser=app.getUserController()
                .getUserBy(userBy,UserResponse.class,Errors.NO_ERRORS).getUser();
        updateUser.setPassword(testUser.getPassword());
        testUser.setEmail(email);
        assertThat(updateUser,equalTo(testUser));
    }

    @Test
    public void testUpdateEmailWithWrongData() {

    }
    @Test
    public void testUpdateEmailIfAccountDisabled() {

    }

    @Test
    public void testUpdatePhoneWithValidData() {

    }

    @Test
    public void testUpdatePhoneWithWrongData() {

    }
    @Test
    public void testUpdatePhoneIfAccountDisabled() {

    }
}
