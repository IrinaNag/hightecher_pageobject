package com.elpisor.hq.app;

import com.elpisor.hq.api_controllers.SessionController;
import com.elpisor.hq.api_controllers.UserController;
import com.elpisor.hq.pages.Header;
import com.elpisor.hq.pages.LoginPage;
import com.elpisor.hq.pages.RegistrationPage;
import com.fasterxml.jackson.databind.ObjectMapper;
/*import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;*/
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
    private String baseUrl;
    private WebDriver driver;
//    private CloseableHttpClient httpClient;
    private ObjectMapper objectMapper;

    private Header header;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

    private UserController userController;
    private SessionController sessionController;


    public ApplicationManager() {
        properties = new Properties();
    }

    public void start() throws IOException {
        String target = System.getProperty("target", "general");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        baseUrl=properties.getProperty("web.baseUrl");
    }


    public void stop() throws IOException {
        if (driver != null)
            driver.quit();
        /*if (httpClient!=null)
            httpClient.close();*/
    }

    public WebDriver getDriver() {
        if (driver == null) {
            browser = System.getProperty("browser", BrowserType.CHROME);
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
            header = new Header(getDriver(), baseUrl);
        return header;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null)
            loginPage = new LoginPage(getDriver());
        return loginPage;
    }

    public RegistrationPage getRegistrationPage() {
        if (registrationPage == null)
            registrationPage = new RegistrationPage(getDriver());
        return registrationPage;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    /*public CloseableHttpClient getHttpClient() {
        if (httpClient==null)
            httpClient= HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
        return httpClient;
    }*/

    public ObjectMapper getObjectMapper() {
        if(objectMapper==null)
            objectMapper=new ObjectMapper();
        return objectMapper;
    }

    public UserController getUserController() {
        if(userController ==null)
            userController =new UserController(this);
        return userController;
    }

    public SessionController getSessionController() {
        if(sessionController==null)
            sessionController=new SessionController(this);
        return sessionController;
    }
}

