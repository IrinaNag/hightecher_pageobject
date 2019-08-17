package com.elpisor.hq.web.gui.pages;

import com.elpisor.hq.web.gui.model.UserGui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class RegistrationPage extends Page {

    private By username = By.cssSelector("input#username");
    private By name = By.cssSelector("input#name");
    private By surname = By.cssSelector("input#surname");
    private By email = By.cssSelector("input#email");
    private By phone = By.cssSelector("input#phone");
    private By password = By.cssSelector("input#password");
    private By password_confirmation = By.cssSelector("input#password_confirmation");
    private By errors = By.xpath("//div[@class='alert alert-danger']");
    private By body = By.xpath("//body//form");
    private By submit = By.xpath("//body//form//button");
    private By fieldNames = By.cssSelector("label");


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage fillRegistrationForm(UserGui userGui) {
        type(username, userGui.getUsername());
        type(name, userGui.getName());
        type(surname, userGui.getSurname());
        type(email, userGui.getEmail());
        type(phone, userGui.getPhone());
        type(password, userGui.getPassword());
        type(password_confirmation, userGui.getPassword_confirmation());
        click(body);
        return this;
    }

    public void clickSubmit() {
        click(submit);
    }

    public boolean isSubmitActive() {
        return isElementActive(submit);
    }

    public List<String> getListOfErrors() {
        return getListOfElements(errors);
    }

}
