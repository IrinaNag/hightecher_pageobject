package com.elpisor.hq.tests.api;

import com.elpisor.hq.tests.api.test_data.ApiDataCreator;
import com.elpisor.hq.web.api.general.Errors;
import com.elpisor.hq.web.api.model.User;
import com.elpisor.hq.web.api.model.UserBy;
import com.elpisor.hq.web.api.model.response_model.UserResponse;
import com.elpisor.hq.tests.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetUserProfileByPositiveTest extends TestBase {
    User testUser;


    @BeforeClass
    public void preconditions() {
        User user = ApiDataCreator.createTestUserForGetUserProfile();
        testUser = app.getUserController()
                .registrationUser(user, UserResponse.class, Errors.NO_ERRORS)
                .getUser();
    }

    @Test
    public void testGetUserProfileByIdWithValidData() {
        UserBy userBy = UserBy.builder().uid(testUser.getUid()).build();
        User responseUser = app.getUserController().getUserBy(userBy, UserResponse.class, Errors.NO_ERRORS).getUser();
        assertThat(responseUser, equalTo(testUser));
    }


    @Test
    public void testGetUserProfileByEmailWithValidData() {
        UserBy userBy = UserBy.builder().email(testUser.getEmail()).build();
        User responseUser = app.getUserController().getUserBy(userBy, UserResponse.class, Errors.NO_ERRORS).getUser();
        assertThat(responseUser, equalTo(testUser));
    }


    @Test
    public void testGetUserProfileByPhoneWithValidData() {
        UserBy userBy = UserBy.builder().phone(testUser.getPhone()).build();
        User responseUser = app.getUserController().getUserBy(userBy, UserResponse.class, Errors.NO_ERRORS).getUser();
        assertThat(responseUser, equalTo(testUser));
    }


}
