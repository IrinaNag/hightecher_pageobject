package com.elpisor.hq.tests.api_tests;

import com.elpisor.hq.model.api_model.User;
import com.elpisor.hq.model.api_model.User.UserBuilder;
import org.apache.commons.lang3.RandomStringUtils;

public class TestData {


    public static User createTestUserForGetUserProfile() {
        UserBuilder userBuilder = createUserBuilderWithMinFields();
        User user = userBuilder
                .phone(createValidPhone())
                .build();
        return user;
    }

    public static User createTestUserForUpdateUserData() {
        UserBuilder userBuilder = createUserBuilderWithMinFields();
        User user = userBuilder
                .phone(createValidPhone())
                .name(createValidName())
                .surname(createValidSurname())
                .build();
        return user;
    }

    private static UserBuilder createUserBuilderWithMinFields() {
        return User.builder()
                .username(createValidUsername())
                .email(createValidEmail())
                .password(createValidPassword());
    }

    public static String createValidUsername() {
        return "User" + System.currentTimeMillis();
    }

    public static String createValidEmail() {
        return "user" + System.currentTimeMillis() + "@domain.com";
    }

    public static String createValidPassword() {
        return RandomStringUtils.randomNumeric(1) + RandomStringUtils.randomAlphabetic(6);
    }

    public static String createValidPhone() {
        return "05" + RandomStringUtils.randomNumeric(8);
    }

    public static String createValidName() {
        return "Name" + System.currentTimeMillis();
    }

    public static String createValidSurname() {
        return "Surname" + System.currentTimeMillis();
    }

}
