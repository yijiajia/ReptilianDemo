package com.netMusic.Demo;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.util.List;

/**
 * 爬取网易云热门推荐页面
 * Request URL:
 *      https://music.163.com/discover/playlist/?order=hot&cat=%E5%85%A8%E9%83%A8&limit=35&offset=70
 *      其中，cat的值由"全部"转码而成
 *   拿到网页，需对html进行解析，采用Jsoup解析
 */
public class NetMusicDemo {

    /**
     * 模拟Get请求
     * @param url：请求Url
     * @param paramsList:参数列表
     */
    public static void doGet(String url, List<String> paramsList){

        HttpClient httpClient = null;
        HttpGet httpGet = null;
        String result = null;

        try{
            httpClient = HttpClients.createDefault();
            httpGet = new HttpGet(url);
            //设置请求头
            httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
            httpGet.setHeader("Referer","https://music.163.com/");
            httpGet.setHeader("Host","music.163.com");
            //设置请求参数



        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
