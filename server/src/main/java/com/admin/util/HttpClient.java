package com.admin.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClient {

    private static int httpRequestTimeout = 100000;

    public static String executeBody(String url, String requestBody) {
        CloseableHttpClient httpclient = null;
        String result = null;
        try {

            HttpEntity entity = new StringEntity(requestBody, "utf-8");
            Builder builder = RequestConfig.custom();
            builder.setConnectTimeout(30000);
            builder.setConnectionRequestTimeout(HttpClient.httpRequestTimeout);
            RequestConfig requestConfig = builder.setSocketTimeout(30000).build();

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            httpPost.setConfig(requestConfig);

            httpclient = HttpClients.createDefault();
            CloseableHttpResponse response = httpclient.execute(httpPost);

            result = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
//			log.error(FunctionUtil.getCurrFunctionName(), e);
        } finally {
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (Exception e) {
                }
            }
        }
        return result;

    }

    public static String executeForm(String url, Map<String, String> paramterMap) {

        String result = null;
        CloseableHttpClient httpclient = null;
        try {

            List<NameValuePair> params = new ArrayList<>();

            paramterMap.forEach((k, v) -> {
                params.add(new BasicNameValuePair(k, v));
            });

            HttpEntity entity = new UrlEncodedFormEntity(params, "utf-8");
            Builder builder = RequestConfig.custom();
            builder.setConnectTimeout(10000);
            builder.setConnectionRequestTimeout(HttpClient.httpRequestTimeout);
            RequestConfig requestConfig = builder.setSocketTimeout(10000).build();

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            httpPost.setConfig(requestConfig);

            httpclient = HttpClients.createDefault();
            CloseableHttpResponse response = httpclient.execute(httpPost);

            result = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
//			log.error(FunctionUtil.getCurrFunctionName(), e);
        } finally {
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (Exception e) {
                }
            }
        }
        return result;
    }


}
