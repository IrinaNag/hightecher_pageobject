package com.elpisor.hq.tests.api;

import com.elpisor.hq.web.api.general.Errors;
import com.elpisor.hq.web.api.model.User;
import com.elpisor.hq.web.api.model.response_model.UserResponse;
import com.elpisor.hq.tests.TestBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class RegistrationTest extends TestBase {

    @Test
    public void testRegistrationUserWithValidData() {
        String username="User"+System.currentTimeMillis();
        String email="user"+System.currentTimeMillis()+"@domain.com";
        String phone="05"+ RandomStringUtils.randomNumeric(8);
        String password=RandomStringUtils.randomNumeric(1)+RandomStringUtils.randomAlphabetic(6);
        User testUser = User.builder()
                .username(username)
                .email(email)
                .phone(phone)
                .password(password)
                .build();
        User responseUser=app.getUserController().registrationUser(testUser, UserResponse.class, Errors.NO_ERRORS).getUser();
        testUser.setPassword(null);
        testUser.setActive(true);
        responseUser.setUid(null);
        assertThat(responseUser,equalTo(testUser));
    }

    @Test
    public void testRegistrationUserWith() {

    }

   /* @Test
    public void testLogin() {
        UserCredsApi userCreds=UserCredsApi.builder().email("jiqezaddex-1403@yopmail.com").password("AAaa123456").build();
        System.out.println(app.getSessionController().login(userCreds));

    }*/
}
