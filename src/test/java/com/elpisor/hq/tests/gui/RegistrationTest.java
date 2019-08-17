package com.elpisor.hq.tests.gui;

import com.elpisor.hq.tests.gui.test_data.GuiDataProvider;
import com.elpisor.hq.web.gui.model.UserGui;
import com.elpisor.hq.web.gui.pages.RegistrationPage;
import com.elpisor.hq.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class RegistrationTest extends TestBase {

    RegistrationPage registrationPage;

    @BeforeMethod
    public void initPageObjects() {
        registrationPage=app.getHeader().openHeader().clickRegistration();
    }

    @Test(dataProvider = "registrationWithValidData", dataProviderClass = GuiDataProvider.class)
    public void testRegistrationWithValidData(UserGui userGui) {
        List<String> errors = registrationPage.fillRegistrationForm(userGui).getListOfErrors();
//        registrationPage.clickSubmit();
        assertTrue(errors.size() == 0);
        assertTrue(registrationPage.isSubmitActive());
     }

    @Test(dataProvider = "registrationWithoutMandatoryFields", dataProviderClass = GuiDataProvider.class)
    public void testRegistrationWithoutMandatoryFields(UserGui userGui){
        List<String> errors = registrationPage.fillRegistrationForm(userGui).getListOfErrors();
        int errorsNumber = 0;
        if (userGui.getUsername() == null) {
            assertTrue(errors.contains("Enter username"));
            errorsNumber++;
        }
        if (userGui.getEmail() == null) {
            assertTrue(errors.contains("Enter email"));
            errorsNumber++;
        }
        if (userGui.getPassword() == null) {
            assertTrue(errors.contains("Enter password"));
            errorsNumber++;
        }
        if (userGui.getPassword_confirmation() == null) {
            assertTrue(errors.contains("Enter password confirmation"));
            errorsNumber++;
        }
        assertTrue(errors.size() == errorsNumber);
        assertFalse(registrationPage.isSubmitActive());
    }

    @Test(dataProvider = "registrationWithWrongEmail", dataProviderClass = GuiDataProvider.class)
    public void testRegistrationWithWrongEmail(UserGui userGui) {
        List<String> errors = registrationPage.fillRegistrationForm(userGui).getListOfErrors();
        assertTrue(errors.size() == 1);
        assertTrue(errors.contains("Wrong email pattern"));
        assertFalse(registrationPage.isSubmitActive());
    }

    @Test(dataProvider = "registrationWithWrongPassword", dataProviderClass = GuiDataProvider.class)
    public void testRegistrationWithWrongPassword(UserGui userGui) {
        List<String> errors = registrationPage.fillRegistrationForm(userGui).getListOfErrors();
        assertTrue(errors.size() == 1);
        assertTrue(errors.contains("Password must at least 8 character length and must include at least one upper case letter, one down case letter, one digit and one symbol"));
        assertFalse(registrationPage.isSubmitActive());
    }

    @Test(dataProvider = "registrationWithWrongPasswordConfirm", dataProviderClass = GuiDataProvider.class)
    public void testRegistrationWithWrongPasswordConfirm(UserGui userGui) {
        List<String> errors = registrationPage.fillRegistrationForm(userGui).getListOfErrors();
        assertTrue(errors.size() == 1);
        assertTrue(errors.contains("Wrong confirmation"));
        assertFalse(registrationPage.isSubmitActive());
    }

}
