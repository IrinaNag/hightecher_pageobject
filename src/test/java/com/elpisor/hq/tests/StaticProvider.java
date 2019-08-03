package com.elpisor.hq.tests;

import com.elpisor.hq.model.UserCreds;
import com.elpisor.hq.model.UserUi;
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
        return getDataFromFile(RESOURCES_URL + LOGIN_WITH_POSITIVE_DATA_FILE, UserCreds.class);
    }

    @DataProvider
    public static Iterator<Object[]> loginWithoutCreds() throws IOException {
        return getDataFromFile(RESOURCES_URL + LOGIN_WITHOUT_CREDS_FILE, UserCreds.class);
    }

    @DataProvider
    public static Iterator<Object[]> loginWithWrongEmail() throws IOException {
        return getDataFromFile(RESOURCES_URL + LOGIN_WITH_WRONG_EMAIL_FILE, UserCreds.class);
    }

    @DataProvider
    public static Iterator<Object[]> registrationWithValidData() throws IOException {
        return getDataFromFile(RESOURCES_URL + REGISTRATION_WITH_VALID_DATA_FILE, UserUi.class);
    }

    @DataProvider
    public static Iterator<Object[]> registrationWithoutMandatoryFields() throws IOException {
        return getDataFromFile(RESOURCES_URL + REGISTRATION_WITHOUT_MANDATORY_FIELDS_FILE, UserUi.class);
    }

    @DataProvider
    public static Iterator<Object[]> registrationWithWrongEmail() throws IOException {
        return getDataFromFile(RESOURCES_URL + REGISTRATION_WITH_WRONG_EMAIL_FILE, UserUi.class);
    }

    @DataProvider
    public static Iterator<Object[]> registrationWithWrongPassword() throws IOException {
        return getDataFromFile(RESOURCES_URL + REGISTRATION_WITH_WRONG_PASSWORD_FILE, UserUi.class);
    }

    @DataProvider
    public static Iterator<Object[]> registrationWithWrongPasswordConfirm() throws IOException {
        return getDataFromFile(RESOURCES_URL + REGISTRATION_WITH_WRONG_PASSWORD_CONFIRM_FILE, UserUi.class);
    }


    public static Iterator<Object[]> getDataFromFile(String fileName, Class clazz) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .map(line -> line.split(";"))
                    .map(split -> checkNull(split))
                    .map(split -> createObject(split, clazz))
                    .collect(Collectors.toList())
                    .iterator();
        }
    }

    private static String[] checkNull(String[] arr) {
        for (String str : arr)
            str = str.equals("null") ? null : str;
        return arr;
    }

    private static <T> T[] createObject(String[] arr, Class clazz) {
        if (clazz == UserUi.class)
            return (T[]) new Object[]{new UserUi(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6])};
        if (clazz == UserCreds.class)
            return (T[]) new Object[]{new UserCreds(arr[0], arr[1])};
        return null;
    }
}