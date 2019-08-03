package com.elpisor.hq.tests.ui_tests;

import com.elpisor.hq.pages.Header;
import com.elpisor.hq.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HeaderTest extends TestBase {

    Header header;

    @BeforeMethod
    public void initPageObjects() {
        header=app.getHeader().openHeader();
//        header.openHeader();
    }

    @Test
    public void testGotoLoginPageFromMainPage() {
        header.clickLogin();
        assertTrue(header.isThisTheLoginPage());
    }

    @Test
    public void testGotoLoginPageFromRegistrationPage() {
        header.clickRegistration();
        header.clickLogin();
        assertTrue(header.isThisTheLoginPage());
    }

    @Test
    public void testGotoLoginPageFromLoginPage() {
        header.clickLogin();
        header.clickLogin();
        assertTrue(header.isThisTheLoginPage());
    }

    @Test
    public void testGotoRegistrationPageFromMainPage() {
        header.clickRegistration();
        assertTrue(header.isThisTheRegistrationPage());
    }

    @Test
    public void testGotoRegistrationPageFromRegistrationPage() {
        header.clickRegistration();
        header.clickRegistration();
        assertTrue(header.isThisTheRegistrationPage());
    }

    @Test
    public void testGotoRegistrationPageFromLoginPage() {
        header.clickLogin();
        header.clickRegistration();
        assertTrue(header.isThisTheRegistrationPage());
    }

}
