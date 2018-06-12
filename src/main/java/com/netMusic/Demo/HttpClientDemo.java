package com.netMusic.Demo;


import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientDemo {

    public static void main(String[] args){

        //模拟客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //模拟输入url请求
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        //添加头部信息模拟浏览器访问
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml," +
                "application/xml;q=0.9,image/webp,*/*;q=0.8");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate, sdch, br");
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36" +
                " (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
        try {
            // 客户端执行get请求返回响应
            CloseableHttpResponse response  = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            String strResult = EntityUtils.toString(httpEntity);
            System.out.println(strResult);
            System.out.println("excuting request:"+httpGet.getURI());

            System.out.println("-------------");
            System.out.println(response.getStatusLine().toString());
            Header[] headers = response.getAllHeaders();
            for (Header h:headers) {
                System.out.println(h.getName()+":"+h.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
