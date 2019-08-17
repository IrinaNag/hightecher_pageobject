package com.elpisor.hq.tests.api.test_data;

import com.elpisor.hq.web.api.model.User;
import com.elpisor.hq.web.api.model.User.UserBuilder;
import com.elpisor.hq.web.api.model.UserData;
import org.apache.commons.lang3.RandomStringUtils;

public class ApiDataCreator {


    public static User createTestUserForGetUserProfile() {
        UserBuilder userBuilder = createUserBuilderWithMinFields();
        return userBuilder
                .phone(createValidPhone())
                .build();
    }

    public static User createTestUserForUpdateUserData() {
        UserBuilder userBuilder = createUserBuilderWithMinFields();
        return userBuilder
                .phone(createValidPhone())
                .name(createValidName())
                .surname(createValidSurname())
                .build();
    }

    private static UserBuilder createUserBuilderWithMinFields() {
        return User.builder()
                .username(createValidUsername())
                .email(createValidEmail())
                .password(createValidPassword());
    }

    public static UserData createUserDataWithValidNameAndSurname() {
        return UserData
                .builder()
                .name(ApiDataCreator.createValidName())
                .surname(ApiDataCreator.createValidSurname())
                .build();
    }

    public static UserData createUserDataWithValidEmail() {
        return UserData
                .builder()
                .email(ApiDataCreator.createValidEmail())
                .build();
    }

    public static UserData createUserDataWithValidPhone() {
        return UserData
                .builder()
                .phone(ApiDataCreator.createValidPhone())
                .build();
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

    public static String createShortName() {
        return RandomStringUtils.randomAlphanumeric(1);
    }

    public static String createLongName() {
        return "Name_" +RandomStringUtils.randomAlphanumeric(20);
    }

    public static String createShortSurname() {
        return RandomStringUtils.randomAlphanumeric(1);
    }

    public static String createLongSurname() {
        return "Surname_" +RandomStringUtils.randomAlphanumeric(20);
    }
}
