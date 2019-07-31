package com.elpisor.hq.tests;

import com.elpisor.hq.model.User;
import com.elpisor.hq.model.UserCreds;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Collectors;

public class StaticProvider {

    private final static String RESOURCES_URL = "src/test/resources/";
    private final static String LOGIN_WITH_POSITIVE_DATA_FILE = "loginWithPositiveData.csv";
    private final static String LOGIN_WITHOUT_CREDS_FILE = "loginWithoutCreds.csv";
    private final static String LOGIN_WITH_WRONG_EMAIL_FILE = "loginWithWrongEmail.csv";
    private final static String REGISTRATION_WITH_VALID_DATA_FILE = "registrationWithValidData.csv";
    private final static String REGISTRATION_WITHOUT_MANDATORY_FIELDS_FILE = "registrationWithoutMandatoryFields.csv";
    private final static String REGISTRATION_WITH_WRONG_USERNAME_FILE = "registrationWithWrongUsername.csv";
    private final static String REGISTRATION_WITH_WRONG_NAME_FILE = "registrationWithWrongName.csv";
    private final static String REGISTRATION_WITH_WRONG_SURNAME_FILE = "registrationWithWrongSurname.csv";
    private final static String REGISTRATION_WITH_WRONG_EMAIL_FILE = "registrationWithWrongEmail.csv";
    private final static String REGISTRATION_WITH_WRONG_PHONE_FILE = "registrationWithWrongPhone.csv";
    private final static String REGISTRATION_WITH_WRONG_PASSWORD_FILE = "registrationWithWrongPassword.csv";
    private final static String REGISTRATION_WITH_WRONG_PASSWORD_CONFIRM_FILE = "registrationWithWrongPasswordConfirm.csv";

    @DataProvider
    public static Iterator<Object[]> loginWithPositiveData() throws IOException {
        return getUserCredsFromFile(RESOURCES_URL + LOGIN_WITH_POSITIVE_DATA_FILE);
    }

    @DataProvider
    public static Iterator<Object[]> loginWithoutCreds() throws IOException {
        return getUserCredsFromFile(RESOURCES_URL + LOGIN_WITHOUT_CREDS_FILE);
    }

    @DataProvider
    public static Iterator<Object[]> loginWithWrongEmail() throws IOException {
        return getUserCredsFromFile(RESOURCES_URL + LOGIN_WITH_WRONG_EMAIL_FILE);
    }

    @DataProvider
    public static Iterator<Object[]> registrationWithValidData() throws IOException {
        return getUsersFromFile(RESOURCES_URL + REGISTRATION_WITH_VALID_DATA_FILE);
    }

    @DataProvider
    public static Iterator<Object[]> registrationWithoutMandatoryFields() throws IOException {
        return getUsersFromFile(RESOURCES_URL + REGISTRATION_WITHOUT_MANDATORY_FIELDS_FILE);
    }

    @DataProvider
    public static Iterator<Object[]> registrationWithWrongEmail() throws IOException {
        return getUsersFromFile(RESOURCES_URL + REGISTRATION_WITH_WRONG_EMAIL_FILE);
    }

    @DataProvider
    public static Iterator<Object[]> registrationWithWrongPassword() throws IOException {
        return getUsersFromFile(RESOURCES_URL + REGISTRATION_WITH_WRONG_PASSWORD_FILE);
    }

    @DataProvider
    public static Iterator<Object[]> registrationWithWrongPasswordConfirm() throws IOException {
        return getUsersFromFile(RESOURCES_URL + REGISTRATION_WITH_WRONG_PASSWORD_CONFIRM_FILE);
    }


    public static Iterator<Object[]> getUserCredsFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines().map(line -> line.split(";"))
                    .map(split -> new Object[]{new UserCreds(split[0].equals("null") ? null : split[0], split[1].equals("null") ? null : split[1])})
                    .collect(Collectors.toList()).iterator();
        }
    }

    public static Iterator<Object[]> getUsersFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines().map(line -> line.split(";"))
                    .map(split -> new Object[]{new User(split[0].equals("null") ? null : split[0]
                            , split[1].equals("null") ? null : split[1], split[2].equals("null") ? null : split[2]
                            , split[3].equals("null") ? null : split[3], split[4].equals("null") ? null : split[4]
                            , split[5].equals("null") ? null : split[5], split[6].equals("null") ? null : split[6])})
                    .collect(Collectors.toList()).iterator();
        }
    }
}