package com.netMusic.utils;

import com.google.gson.Gson;
import com.netMusic.entity.*;
import com.netMusic.entity.custom.Album;
import com.netMusic.entity.custom.Artists;
import com.netMusic.entity.custom.Msg;
import com.netMusic.entity.custom.Songs;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 网址：https://www.xunmzy.com/tool/fm/
 * 该网站的请求工具（目前该网站貌似已崩溃，不能使用）
 */
public class XunMengUtil {


    public static Msg spiderMusic(String url,String offset,String songName){

        Map<String,Object> map = new HashMap<>();
        String charest = "utf-8";
        //post请求的参数
        map.put("types","CloudMusic");
        map.put("SongName",songName);
        //偏移量数据
        map.put("OffSet",offset);
        //增加请求头信息
        List<Header> headerList = new ArrayList<>();
        headerList.add(new BasicHeader("origin","https://www.xunmzy.com"));
        headerList.add(new BasicHeader("referer","https://www.xunmzy.com/tool/fm/"));
        headerList.add(new BasicHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64)" +
                " AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"));
        //模拟post请求
        String resJson = HttpClientUtil.doPost(url,map,charest,headerList);
        Gson gson = new Gson();
        Msg msg = null;
        if(resJson!=null && !resJson.contains("html")){
            msg =  gson.fromJson(resJson,Msg.class);
        }

        return msg;



    }



    public static List<List<Songs>> getResultList(String songName){

        String url = "https://www.xunmzy.com/tool/fm/music/index.php";
        List<List<Songs>> listAll = new ArrayList<>();
        //一次爬600首
        for(int i=0;i<20;i++){
            Msg msg =  spiderMusic(url,i*30+"",songName);
            System.out.println(msg);
            //要判空
            if(msg!=null){
                List<Songs> list = msg.getResult().getSongs();
                listAll.add(list);
            }
        }
        return listAll;



    }

    public static Singer saveSinger(Songs songs) {
        Singer singer = new Singer();
        List<Artists> artists = songs.getArtists();
        for(Artists artist:artists){
            singer.setId(artist.getId());
            singer.setName(artist.getName());
            singer.setPicUrl(artist.getPicUrl());

        }
        return singer;
    }

    public static Record saveRecord(Songs songs) {
        Record record = new Record();
        Album album = songs.getAlbum();
        record.setId(album.getId());
        record.setCommentThreadId(album.getCommentThreadId());
        record.setCompany(album.getCompany());
        record.setIntro(album.getDescription());
        record.setName(album.getName());
        record.setPicUrl(album.getPicUrl());
        record.setSingerId(album.getArtist().getId());

        return record;
    }

    ////用自定义javaBean保存数据
    public static Song saveSong(Songs songs) {
        Song song =  new Song();
        song.setId(songs.getId());
        song.setName(songs.getName());
        song.setCommentThreadId(songs.getCommentThreadId());
        song.setRecordId(songs.getAlbum().getId());
        song.setMp3url(songs.getMp3Url());

        return song;

    }

    //保存key
    public static List<SingerSong> saveSingerSong(Songs songs){

        List<SingerSong> singerSongList = new ArrayList<>();
        List<Artists> artistsList = songs.getArtists();
        if(artistsList!=null){
            for(Artists artists:artistsList){
                SingerSong key = new SingerSong();
                key.setSingerId(artists.getId());
                key.setSongId((int)songs.getId());
                singerSongList.add(key);
            }
        }


        return singerSongList;

    }



}
