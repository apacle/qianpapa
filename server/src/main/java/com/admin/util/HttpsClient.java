package com.admin.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpsClient {

    private static int httpRequestTimeout = 20000;

    public static String executeBody(String url, String requestBody) {

        CloseableHttpClient httpclient = null;
        String result = null;
        try {

            HttpEntity entity = new StringEntity(requestBody, "utf-8");
            Builder builder = RequestConfig.custom();
            builder.setConnectTimeout(10000);
            builder.setConnectionRequestTimeout(HttpsClient.httpRequestTimeout);
            RequestConfig requestConfig = builder.setSocketTimeout(10000).build();

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            httpPost.setConfig(requestConfig);

            httpclient = HttpsClient.wrapClient();
            HttpResponse response = httpclient.execute(httpPost);

            result = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
//            log.error(FunctionUtil.getCurrFunctionName(), e);
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
            Builder builder = RequestConfig.custom();
            builder.setConnectTimeout(3000);
            builder.setConnectionRequestTimeout(HttpsClient.httpRequestTimeout);
            RequestConfig requestConfig = builder.setSocketTimeout(3000).build();

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            httpPost.setConfig(requestConfig);

            httpclient = HttpsClient.wrapClient();
            HttpResponse response = httpclient.execute(httpPost);

            result = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
//            log.error(FunctionUtil.getCurrFunctionName(), e);
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
        String HTTP = "http";
        String HTTPS = "https";
        SSLConnectionSocketFactory sslsf = null;
        PoolingHttpClientConnectionManager cm = null;
        SSLContextBuilder builder = null;
        CloseableHttpClient httpClient = null;
        try {
            builder = new SSLContextBuilder();

//			builder.loadTrustMaterial(null, new TrustStrategy() {
//				@Override
//				public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
//					return true;
//				}
//			});

            sslsf = new SSLConnectionSocketFactory(builder.build(),
                    new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTP, new PlainConnectionSocketFactory()).register(HTTPS, sslsf).build();
            cm = new PoolingHttpClientConnectionManager(registry);
            httpClient = HttpClients.custom()
                    .setSSLSocketFactory(sslsf)
                    .setConnectionManager(cm)
                    .setConnectionManagerShared(true)
                    .build();
        } catch (Exception e) {
//            log.error(FunctionUtil.getCurrFunctionName(), e);
        }
        return httpClient;
    }

    public static void main(String[] args) {
        String url = "https://testseashop.seatelgroup.com:8092/communication/consumer/queryUserBalance";
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("language", "chs");
        parameterMap.put("phone", "0189418008");
        parameterMap.put("countryCode", "855");
        parameterMap.put("token", "5fa77562cdf94bacaf58c69b24591818");
        long time = System.currentTimeMillis();
        String result = HttpsClient.executeForm(url, parameterMap);
        System.out.println(System.currentTimeMillis() - time);
        System.out.println(result);

    }

}
