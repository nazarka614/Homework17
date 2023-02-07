package rest;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RestGet {
    public static String GetExchange(String url){
        CloseableHttpClient httpClient= HttpClientBuilder.create().build();
        String entity;
        HttpResponse response;
        try {
            response = httpClient.execute(new HttpGet(url));
            entity= EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response.getStatusLine().getStatusCode());
        StringBuilder stringBuilder=new StringBuilder();
        if(entity.charAt(0)=='['){
            stringBuilder.append(entity.substring(1,entity.length()-1));
        }else {
            return entity;
        }
        return stringBuilder.toString();
    }
}