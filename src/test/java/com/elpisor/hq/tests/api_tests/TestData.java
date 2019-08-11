package com.elpisor.hq.tests.api_tests;

import com.elpisor.hq.model.api_model.User;
import com.elpisor.hq.model.api_model.User.UserBuilder;
import org.apache.commons.lang3.RandomStringUtils;

public class TestData {


    public static User createTestUserForGetUserProfile() {
        UserBuilder userBuilder = createUserBuilderWithMinFields();
        String phone = "05" + RandomStringUtils.randomNumeric(8);
        User user = userBuilder
                .phone(phone)
                .build();
        return user;
    }

    public static User createTestUserForUpdateUserData() {
        UserBuilder userBuilder = createUserBuilderWithMinFields();
        String phone = "05" + RandomStringUtils.randomNumeric(8);
        String name = "Name" + System.currentTimeMillis();
        String surname = "Surname" + System.currentTimeMillis();
        User user = userBuilder
                .phone(phone)
                .name(name)
                .surname(surname)
                .build();
        return user;
    }

    private static UserBuilder createUserBuilderWithMinFields() {
        String username = "User" + System.currentTimeMillis();
        String email = "user" + System.currentTimeMillis() + "@domain.com";
        String password = RandomStringUtils.randomNumeric(1) + RandomStringUtils.randomAlphabetic(6);
        return User.builder()
                .username(username)
                .email(email)
                .password(password);
    }


}
