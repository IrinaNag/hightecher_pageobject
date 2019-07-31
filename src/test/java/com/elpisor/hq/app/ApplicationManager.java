package com.elpisor.hq.app;

import com.elpisor.hq.pages.Header;
import com.elpisor.hq.pages.LoginPage;
import com.elpisor.hq.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    private String browser;
    private WebDriver driver;
    private Header header;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;


    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void start() throws IOException {
        String target = System.getProperty("target", "general");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    }


    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            if (browser.equals(BrowserType.CHROME))
                driver = new ChromeDriver();
            else if (browser.equals(BrowserType.FIREFOX))
                driver = new FirefoxDriver();
            else if (browser.equals(BrowserType.IE))
                driver = new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public Header getHeader() {
        if (header == null)
            header = new Header(getDriver(), properties.getProperty("web.baseUrl"));
        return header;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null)
            loginPage = new LoginPage(driver);
        return loginPage;
    }

    public RegistrationPage getRegistrationPage() {
        if (registrationPage == null)
            registrationPage = new RegistrationPage(driver);
        return registrationPage;
    }

}

