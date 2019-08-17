package com.elpisor.hq.tests.api;

import com.elpisor.hq.tests.TestBase;
import com.elpisor.hq.tests.api.test_data.ApiDataCreator;
import com.elpisor.hq.tests.api.test_data.ApiDataProvider;
import com.elpisor.hq.web.api.general.Errors;
import com.elpisor.hq.web.api.model.User;
import com.elpisor.hq.web.api.model.UserBy;
import com.elpisor.hq.web.api.model.UserCredsApi;
import com.elpisor.hq.web.api.model.UserData;
import com.elpisor.hq.web.api.model.response_model.UnsuccessfulResponse;
import com.elpisor.hq.web.api.model.response_model.UserDataResponse;
import com.elpisor.hq.web.api.model.response_model.UserResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateUserDataTest extends TestBase {

    User testUser;
    String token;
    UserBy userBy;

    @BeforeClass
    public void preconditions() {
        User user = ApiDataCreator.createTestUserForUpdateUserData();
        testUser = app.getUserController()
                .registrationUser(user, UserResponse.class, Errors.NO_ERRORS)
                .getUser();
        testUser.setPassword(user.getPassword());
        UserCredsApi userCredsApi = UserCredsApi.builder()
                .email(testUser.getEmail())
                .password(testUser.getPassword())
                .returnSecureToken(true)
                .build();
        token = app.getSessionController().login(userCredsApi);

        userBy = UserBy
                .builder()
                .uid(testUser.getUid())
                .build();
    }


    @Test
    public void testUpdateNameAndSurnameWithValidData() {
        UserData userData = ApiDataCreator.createUserDataWithValidNameAndSurname();

        UserData responseUserData = app.getUserDataController()
                .updateNameAndSurname(userData, token, UserDataResponse.class, Errors.NO_ERRORS).getUserData();
        assertThat(responseUserData, equalTo(userData));

        User updateUser = app.getUserController()
                .getUserBy(userBy, UserResponse.class, Errors.NO_ERRORS).getUser();
        updateUser.setPassword(testUser.getPassword());
        testUser.setName(userData.getName());
        testUser.setSurname(userData.getSurname());
        assertThat(updateUser, equalTo(testUser));
    }

    @Test(dataProvider = "updateNameAndSurnameWithWrongNameLength", dataProviderClass = ApiDataProvider.class)
    public void testUpdateNameAndSurnameWithWrongNameLength(UserData userData) {
        app.getUserDataController().updateNameAndSurname(userData, token, UnsuccessfulResponse.class, Errors.WRONG_NAME_LENGTH);
    }

    @Test(dataProvider = "updateNameAndSurnameWithWrongSurnameLength", dataProviderClass = ApiDataProvider.class)
    public void testUpdateNameAndSurnameWithWrongSurnameLength(UserData userData) {
        app.getUserDataController().updateNameAndSurname(userData, token, UnsuccessfulResponse.class, Errors.WRONG_SURNAME_LENGTH);
    }

    @Test(enabled = false)
    public void testUpdateNameAndSurnameIfAccountDisabled() {

    }

    @Test
    public void testUpdateEmailWithValidData() {
        UserData userData = ApiDataCreator.createUserDataWithValidEmail();

        UserData responseUserData = app.getUserDataController()
                .updateEmail(userData, token, UserDataResponse.class, Errors.NO_ERRORS).getUserData();
        assertThat(responseUserData, equalTo(userData));

        User updateUser = app.getUserController()
                .getUserBy(userBy, UserResponse.class, Errors.NO_ERRORS).getUser();
        updateUser.setPassword(testUser.getPassword());
        testUser.setEmail(userData.getEmail());
        assertThat(updateUser, equalTo(testUser));
    }

    @Test(dataProvider = "updateEmailWithWrongData", dataProviderClass = ApiDataProvider.class)
    public void testUpdateEmailWithWrongData(UserData userData) {
        app.getUserDataController().updateEmail(userData, token, UnsuccessfulResponse.class, Errors.WRONG_EMAIL);

    }

    @Test(enabled = false)
    public void testUpdateEmailIfAccountDisabled() {

    }

    @Test
    public void testUpdatePhoneWithValidData() {
        UserData userData = ApiDataCreator.createUserDataWithValidPhone();

        UserData responseUserData = app.getUserDataController()
                .updatePhone(userData, token, UserDataResponse.class, Errors.NO_ERRORS).getUserData();
        assertThat(responseUserData, equalTo(userData));

        User updateUser = app.getUserController()
                .getUserBy(userBy, UserResponse.class, Errors.NO_ERRORS).getUser();
        updateUser.setPassword(testUser.getPassword());
        testUser.setPhone(userData.getPhone());
        assertThat(updateUser, equalTo(testUser));

    }

    @Test(dataProvider = "updatePhoneWithWrongData", dataProviderClass = ApiDataProvider.class)
    public void testUpdatePhoneWithWrongData(UserData userData) {
        app.getUserDataController().updatePhone(userData, token, UnsuccessfulResponse.class, Errors.WRONG_PHONE);
    }

    @Test(enabled = false)
    public void testUpdatePhoneIfAccountDisabled() {

    }

}
