package com.elpisor.hq.app;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.IOException;

public class ApiHelper {

    private ApplicationManager app;

    public ApiHelper(ApplicationManager app) {
        this.app=app;
    }

    public CloseableHttpResponse postExecute(Object obj, String path) throws IOException {
        String url = app.getBaseUrl()+path;

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(1000).setConnectTimeout(1000).setSocketTimeout(1000).build();

        HttpPost request = new HttpPost(url);

        request.setConfig(requestConfig);

        String jsonStr = app.getObjectMapper().writeValueAsString(obj);
        StringEntity entity = new StringEntity(jsonStr);
        request.setEntity(entity);
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        return app.getHttpClient().execute(request);
    }
}
