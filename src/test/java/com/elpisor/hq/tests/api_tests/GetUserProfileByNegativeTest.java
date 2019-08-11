package com.elpisor.hq.tests.api_tests;

import com.elpisor.hq.api_controllers.Errors;
import com.elpisor.hq.model.api_model.UserBy;
import com.elpisor.hq.model.api_response_model.UnsuccessfulResponse;
import com.elpisor.hq.tests.TestBase;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;


public class GetUserProfileByNegativeTest extends TestBase {

    @Test
    public void testGetUserProfileByIdWithWrongData() {
        String id = RandomStringUtils.randomAlphanumeric(28);
        UserBy userBy = UserBy.builder().uid(id).build();
        app.getUserController().getUserBy(userBy, UnsuccessfulResponse.class, Errors.ID_NOT_REGISTERED);
    }

    @Test
    public void testGetUserProfileByEmailWithWrongData() {
        String email = "user" + System.currentTimeMillis() + "@domain.com";
        UserBy userBy = UserBy.builder().email(email).build();
        app.getUserController().getUserBy(userBy, UnsuccessfulResponse.class, Errors.EMAIL_NOT_REGISTERED);
    }

    @Test
    public void testGetUserProfileByPhoneWithWrongData() {
        String phone = "05" + RandomStringUtils.randomNumeric(8);
        UserBy userBy = UserBy.builder().phone(phone).build();
        app.getUserController().getUserBy(userBy, UnsuccessfulResponse.class, Errors.PHONE__NOT_REGISTERED);
    }

}
