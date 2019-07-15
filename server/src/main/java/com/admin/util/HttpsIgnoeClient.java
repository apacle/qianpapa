package com.admin.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HttpsIgnoeClient {

    private static final Logger logger = LoggerFactory.getLogger(HttpsClient.class);

    private static int httpRequestTimeout = 20000;

    public static String executeBody(String url, String requestBody, String contentType) {

        CloseableHttpClient httpclient = null;
        String result = null;
        try {

            HttpEntity entity = new StringEntity(requestBody, "utf-8");
            RequestConfig.Builder builder = RequestConfig.custom();
            builder.setConnectTimeout(10000);
            builder.setConnectionRequestTimeout(HttpsIgnoeClient.httpRequestTimeout);
            RequestConfig requestConfig = builder.setSocketTimeout(10000).build();

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            httpPost.setConfig(requestConfig);
            if (null != contentType)
                httpPost.setHeader("Content-type", contentType);

            httpclient = HttpsIgnoeClient.wrapClient();
            HttpResponse response = httpclient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            logger.error("executeBody", e);
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

    public static String executeForm(String url, Map<String, String> parameterMap) {

        CloseableHttpClient httpclient = null;
        String result = null;
        try {

            List<NameValuePair> params = new ArrayList<>();

            parameterMap.forEach((k, v) -> {
                params.add(new BasicNameValuePair(k, v));
            });

            HttpEntity entity = new UrlEncodedFormEntity(params, "utf-8");
            RequestConfig.Builder builder = RequestConfig.custom();
            builder.setConnectTimeout(10000);
            builder.setConnectionRequestTimeout(HttpsIgnoeClient.httpRequestTimeout);
            RequestConfig requestConfig = builder.setSocketTimeout(10000).build();

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            httpPost.setConfig(requestConfig);


            httpclient = HttpsIgnoeClient.wrapClient();
            HttpResponse response = httpclient.execute(httpPost);
            System.out.println("Headers===" + response.getAllHeaders());
            result = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            logger.error("HttpsClient executeForm:", e);
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

    public static CloseableHttpClient wrapClient() {
        CloseableHttpClient httpClient = null;
        try {
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {

                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }

            }).build();

            //创建httpClient
            httpClient = HttpClients.custom().setSSLContext(sslContext).
                    setSSLHostnameVerifier(new NoopHostnameVerifier()).build();

        } catch (Exception e) {
            logger.error("wrapClient", e);
        }
        return httpClient;
    }

}
