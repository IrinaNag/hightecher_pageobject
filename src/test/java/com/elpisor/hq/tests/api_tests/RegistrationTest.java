package com.elpisor.hq.tests.api_tests;

import com.elpisor.hq.model.UserUi;
import com.elpisor.hq.tests.StaticProvider;
import com.elpisor.hq.tests.TestBase;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.testng.AssertJUnit.assertFalse;

public class RegistrationTest extends TestBase {

    private static final String PATH = "/";


    @Test(dataProvider = "registrationWithoutMandatoryFields", dataProviderClass = StaticProvider.class)
    public void testRegistration(UserUi userUi) throws URISyntaxException, IOException {
//        String url = app.getBaseUrl() + "/";
        CloseableHttpResponse response = app.getApiHelper().postExecute(userUi, PATH);
        int code = response.getStatusLine().getStatusCode();
        assertFalse(code == 200);
    }

}
