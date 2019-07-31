package com.elpisor.hq.tests.ui_tests;

import com.elpisor.hq.model.User;
import com.elpisor.hq.pages.Header;
import com.elpisor.hq.pages.RegistrationPage;
import com.elpisor.hq.tests.StaticProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class RegistrationTest extends UiTestBase {

    RegistrationPage registrationPage;

    @BeforeMethod
    public void initPageObjects() {
        registrationPage=app.getHeader().openHeader().clickRegistration();
    }

    @Test(dataProvider = "registrationWithValidData", dataProviderClass = StaticProvider.class)
    public void testRegistrationWithValidData(User user) {
        registrationPage.fillRegistrationForm(user);
        List<String> errors = registrationPage.getListOfErrors();
//        registrationPage.clickSubmit();
        assertTrue(errors.size() == 0);
        assertTrue(registrationPage.isSubmitActive());
    }

    @Test(dataProvider = "registrationWithoutMandatoryFields", dataProviderClass = StaticProvider.class)
    public void testRegistrationWithoutMandatoryFields(User user) {
        registrationPage.fillRegistrationForm(user);
        List<String> errors = registrationPage.getListOfErrors();
        int errorsNumber = 0;
        if (user.getUsername() == null) {
            assertTrue(errors.contains("Enter username"));
            errorsNumber++;
        }
        if (user.getEmail() == null) {
            assertTrue(errors.contains("Enter email"));
            errorsNumber++;
        }
        if (user.getPassword() == null) {
            assertTrue(errors.contains("Enter password"));
            errorsNumber++;
        }
        if (user.getPassword_confirmation() == null) {
            assertTrue(errors.contains("Enter password confirmation"));
            errorsNumber++;
        }
        assertTrue(errors.size() == errorsNumber);
        assertFalse(registrationPage.isSubmitActive());
    }

    @Test(dataProvider = "registrationWithWrongEmail", dataProviderClass = StaticProvider.class)
    public void testRegistrationWithWrongEmail(User user) {
        registrationPage.fillRegistrationForm(user);
        List<String> errors = registrationPage.getListOfErrors();
        assertTrue(errors.size() == 1);
        assertTrue(errors.contains("Wrong email pattern"));
        assertFalse(registrationPage.isSubmitActive());
    }

    @Test(dataProvider = "registrationWithWrongPassword", dataProviderClass = StaticProvider.class)
    public void testRegistrationWithWrongPassword(User user) {
        registrationPage.fillRegistrationForm(user);
        List<String> errors = registrationPage.getListOfErrors();
        assertTrue(errors.size() == 1);
        assertTrue(errors.contains("Password must at least 8 character length and must include at least one upper case letter, one down case letter, one digit and one symbol"));
        assertFalse(registrationPage.isSubmitActive());
    }

    @Test(dataProvider = "registrationWithWrongPasswordConfirm", dataProviderClass = StaticProvider.class)
    public void testRegistrationWithWrongPasswordConfirm(User user) {
        registrationPage.fillRegistrationForm(user);
        List<String> errors = registrationPage.getListOfErrors();
        assertTrue(errors.size() == 1);
        assertTrue(errors.contains("Wrong confirmation"));
        assertFalse(registrationPage.isSubmitActive());
    }

}
