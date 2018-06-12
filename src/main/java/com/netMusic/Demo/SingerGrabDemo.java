package com.netMusic.Demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.netMusic.entity.Song;
import com.netMusic.entity.custom2.SongMsg;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 抓取网易云歌手歌曲信息
 */
public class SingerGrabDemo {


    public static String doGet(String url){

        HttpClient httpClient = null;
        HttpGet httpGet = null;
        String result = null;
        try {
            httpClient = HttpClients.createDefault();
            httpGet = new HttpGet(url);
            //设置请求头
            httpGet.setHeader("Host","music.163.com");
            httpGet.setHeader("Referer","https://music.163.com/");
            httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");

            HttpResponse httpResponse = httpClient.execute(httpGet);
            if(httpResponse!=null){
                HttpEntity httpEntity = httpResponse.getEntity();
                if(httpEntity!=null){
                    result = EntityUtils.toString(httpEntity);
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return result;

    }




    public static void main(String[] args){

        String result = doGet("https://music.163.com/artist?id=2116");
//        System.out.println(result);
        Document document = Jsoup.parse(result);
        Elements elements = document.select("#song-list-pre-data");
        System.out.println("json数据如下");
        String resJson  = elements.text();
        System.out.println(resJson);
        Gson gson = new Gson();
        Type listType  = new TypeToken<List<SongMsg>>(){}.getType();
        List<SongMsg> list = gson.fromJson(resJson,listType);
        for(SongMsg songMsg:list){
            Song song = new Song();
            song.setId(songMsg.getId());
            song.setName(songMsg.getName());
            song.setCommentThreadId(songMsg.getCommentThreadId());
            song.setRecordId((int)songMsg.getAlbum().getId());
            System.out.println(song.toString());
        }



    }




}
