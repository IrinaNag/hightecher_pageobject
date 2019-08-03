package com.elpisor.hq.tests.api_tests;

import com.elpisor.hq.model.UserBy;
import com.elpisor.hq.tests.TestBase;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class GetUserProfileTest extends TestBase {

    private static final String PATH = "/user/profile";

    @Test
    public void testGetUserProfileByIdWithWrongData () throws IOException {
        UserBy userBy=UserBy.builder().uid("jhkjhkjhkhj").build();
        CloseableHttpResponse response = app.getApiHelper().postExecute(userBy, PATH);
        int code = response.getStatusLine().getStatusCode();
        assertTrue(code == 404);
        String bodyAsString = EntityUtils.toString(response.getEntity());
        System.out.println(bodyAsString);
        assertTrue(bodyAsString.contains("Not Found"));
        System.out.println(response.toString());
        System.out.println("______________________________________________");
        System.out.println((response.getEntity().toString()));
        


    }

}
