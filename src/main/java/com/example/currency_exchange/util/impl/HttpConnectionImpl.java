package com.example.currency_exchange.util.impl;

import com.example.currency_exchange.exceptions.DataException;
import com.example.currency_exchange.util.CustomHttpConnection;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

@Component
public class HttpConnectionImpl implements CustomHttpConnection {
    @Override
    public String sendGet(String url) throws IOException {
        String result = "";
        try (CloseableHttpClient httpClient = HttpClients.createDefault();) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request);) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity);
                }
            } catch (IOException e) {
                throw new DataException("Something wrong while getting response", e);
            }
        } catch (IOException e) {
            throw new DataException("Something wrong while http connection", e);
        }
        return result;
    }
}
