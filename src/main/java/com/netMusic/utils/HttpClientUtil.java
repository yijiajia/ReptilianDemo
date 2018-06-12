package com.netMusic.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * HttpClient工具类
 */
@Component
public class HttpClientUtil {


    /**
     * 模拟post请求，获取返回数据
     * @param url
     * @param map
     * @param charest
     * @param headerList
     * @return
     */
    public static String doPost(String url, Map<String, Object> map, String charest, List<Header> headerList) {

        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            //设置请求头，反反盗链
            for(Header header:headerList){
//                httpPost.setHeader(header.getName(),header.getValue());
                httpPost.setHeader(header);
            }
            //设置参数
            List<NameValuePair> list = new ArrayList<>();
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> elem = (Map.Entry<String, Object>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), (String) elem.getValue()));
            }
            if (list.size() > 0) {
                //封装实体
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charest);
                httpPost.setEntity(entity);
            }
            //拿到返回结果
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charest);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }


    /**
     * 模拟get请求
     * @param url
     * @param headerList
     * @param charest
     * @return
     */
    public static String doGet(String url,List<Header> headerList,String charest){

        HttpClient httpClient = null;
        HttpGet httpGet = null;
        String result = null;
        try {
            httpClient = HttpClients.createDefault();
            httpGet = new HttpGet(url);
            //设置请求头
            for(Header header:headerList){
                httpGet.setHeader(header);
            }

            HttpResponse httpResponse = httpClient.execute(httpGet);
            if(httpResponse!=null){
                HttpEntity httpEntity = httpResponse.getEntity();
                if(httpEntity!=null){
                    result = EntityUtils.toString(httpEntity,charest);
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return result;

    }






}
