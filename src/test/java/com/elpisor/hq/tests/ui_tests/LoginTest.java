package com.elpisor.hq.tests.ui_tests;

import com.elpisor.hq.model.UserCreds;
import com.elpisor.hq.pages.LoginPage;
import com.elpisor.hq.tests.StaticProvider;
import com.elpisor.hq.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTest extends TestBase {

    LoginPage loginPage;

    @BeforeMethod
    public void initPageObjects() {
        loginPage=app.getHeader().openHeader().clickLogin();
    }

    @Test(dataProvider = "loginWithoutCreds", dataProviderClass = StaticProvider.class)
    public void testLoginWithoutCreds(UserCreds userCreds) {
        loginPage.fillLoginForm(userCreds);
        List<String> errors = loginPage.getListOfErrors();
        int errorsNumber = 0;
        if (userCreds.getEmail() == null) {
            assertTrue(errors.contains("Enter email"));
            errorsNumber++;
        }
        if (userCreds.getPassword() == null) {
            assertTrue(errors.contains("Enter password"));
            errorsNumber++;
        }
        assertTrue(errors.size() == errorsNumber);
        assertFalse(loginPage.isSubmitActive());
    }

    @Test(dataProvider = "loginWithWrongEmail", dataProviderClass = StaticProvider.class)
    public void testLoginWithWrongEmail(UserCreds userCreds) {
        loginPage.fillLoginForm(userCreds);
        List<String> errors = loginPage.getListOfErrors();
        assertTrue(errors.size() == 1);
        assertTrue(errors.contains("Wrong email pattern"));
        assertFalse(loginPage.isSubmitActive());
    }

    @Test(enabled = false)
    public void testLoginWithWrongPassword() {
        loginPage.fillLoginForm(UserCreds.builder().email("a@a").password("1").build());
        List<String> errors = loginPage.getListOfErrors();
        assertTrue(errors.size() == 1);
        assertTrue(errors.contains("Wrong password pattern"));
        assertFalse(loginPage.isSubmitActive());
    }

    @Test(dataProvider = "loginWithPositiveData", dataProviderClass = StaticProvider.class)
    public void testLoginWithValidCreds(UserCreds userCreds) {
        loginPage.fillLoginForm(userCreds);
        List<String> errors = loginPage.getListOfErrors();
        assertTrue(errors.size() == 0);
//        loginPage.clickSubmit();
        assertTrue(loginPage.isSubmitActive());
    }
}
