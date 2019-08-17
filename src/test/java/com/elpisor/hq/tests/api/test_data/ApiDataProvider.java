package com.elpisor.hq.tests.api.test_data;

import com.elpisor.hq.web.api.model.UserData;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class ApiDataProvider {

    @DataProvider
    public static Object[] updateNameAndSurnameWithWrongNameLength(){
        String shortName= ApiDataCreator.createShortName();
        String longName= ApiDataCreator.createLongName();
        String surname= ApiDataCreator.createValidSurname();
        return new Object[]{UserData.builder().name(shortName).surname(surname).build(),
        UserData.builder().name(longName).surname(surname).build()};
    }

    @DataProvider
    public static Object[] updateNameAndSurnameWithWrongSurnameLength(){
        String shortSurname= ApiDataCreator.createShortSurname();
        String longSurname= ApiDataCreator.createLongSurname();
        String name= ApiDataCreator.createValidName();
        return new Object[]{UserData.builder().name(name).surname(shortSurname).build(),
                UserData.builder().name(name).surname(longSurname).build()};
    }

    @DataProvider
    public static Object[] updateEmailWithWrongData(){
        String wrongEmail_1= RandomStringUtils.randomAlphanumeric(10);
        String wrongEmail_2= RandomStringUtils.randomAlphanumeric(5)+"@"+RandomStringUtils.randomAlphanumeric(5);
        return new Object[]{UserData.builder().email(wrongEmail_1).build(),
                UserData.builder().email(wrongEmail_2).build()};
    }

    @DataProvider
    public static Object[] updatePhoneWithWrongData(){
        String wrongPhone_1= RandomStringUtils.randomNumeric(10);
        String wrongPhone_2="05"+RandomStringUtils.randomNumeric(5);
        String wrongPhone_3="05"+RandomStringUtils.randomNumeric(10);
        return new Object[]{UserData.builder().phone(wrongPhone_1).build(),
                UserData.builder().phone(wrongPhone_2).build(),
                UserData.builder().phone(wrongPhone_3).build()};
    }


}
