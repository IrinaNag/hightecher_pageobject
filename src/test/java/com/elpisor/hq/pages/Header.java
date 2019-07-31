package com.elpisor.hq.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends Page {
    String url;

    RegistrationPage registrationPage;
    LoginPage loginPage;

    private By registration = By.linkText("Registration");
    private By login = By.linkText("Login");

    public Header(WebDriver driver, String url) {
        super(driver);
        this.url = url;
    }

    public Header openHeader() {
        driver.get(url);
        return this;
    }

    public LoginPage clickLogin() {
        if (!isThisTheLoginPage()) {
            LoginPage newLoginPage = new LoginPage(driver);
            loginPage = newLoginPage;
        }
        click(login);
        return this.loginPage;
    }

    public RegistrationPage clickRegistration() {
        if (!isThisTheRegistrationPage()) {
            RegistrationPage newRegistrationPage = new RegistrationPage(driver);
            registrationPage = newRegistrationPage;
        }
        click(registration);
        return this.registrationPage;
    }

    public boolean isThisTheLoginPage() {
        return getCurrentUrl().contains("/login");
    }

    public boolean isThisTheRegistrationPage() {
        return getCurrentUrl().contains("/registration");
    }

}
