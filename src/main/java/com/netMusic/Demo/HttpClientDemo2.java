//package com.netMusic.Demo;
//
//import com.google.gson.Gson;
//import com.netMusic.entity.Record;
//import com.netMusic.entity.Singer;
//import com.netMusic.entity.Song;
//import com.netMusic.entity.custom.*;
//import com.netMusic.repository.RecordRepository;
//import com.netMusic.repository.SingerRepository;
//import com.netMusic.repository.SongRepository;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.*;
//
///**
// * 模拟post请求，获取返回数据
// */
//@Component
//public class HttpClientDemo2 {
//
//    @Autowired
//    private  RecordRepository recordRepository;
//    @Autowired
//    private SingerRepository singerRepository;
//    @Autowired
//    private SongRepository songRepository;
//
//
//    //拿到音乐的json数据
//    public static String doPost(String url, Map<String, Object> map, String charest) {
//
//        HttpClient httpClient = null;
//        HttpPost httpPost = null;
//        String result = null;
//        try {
//            httpClient = HttpClients.createDefault();
//            httpPost = new HttpPost(url);
//            //设置请求头，反反盗链
//            httpPost.setHeader("origin","https://www.xunmzy.com");
//            httpPost.setHeader("referer","https://www.xunmzy.com/tool/fm/");
//            httpPost.setHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
//            //设置参数
//            List<NameValuePair> list = new ArrayList<>();
//            Iterator iterator = map.entrySet().iterator();
//            while (iterator.hasNext()) {
//                Map.Entry<String, Object> elem = (Map.Entry<String, Object>) iterator.next();
//                list.add(new BasicNameValuePair(elem.getKey(), (String) elem.getValue()));
//            }
//            if (list.size() > 0) {
//                //封装实体
//                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charest);
//                httpPost.setEntity(entity);
//            }
//            //拿到返回结果
//            HttpResponse response = httpClient.execute(httpPost);
//            if (response != null) {
//                HttpEntity resEntity = response.getEntity();
//                if (resEntity != null) {
//                    result = EntityUtils.toString(resEntity, charest);
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return result;
//
//    }
//
//
//    public static Msg spiderMusic(String url,String offset,String songName){
//
//        Map<String,Object> map = new HashMap<>();
//        String charest = "utf-8";
//        //post请求的参数
//        map.put("types","CloudMusic");
//        map.put("SongName",songName);
//        //偏移量数据
//        map.put("OffSet",offset);
//        //模拟post请求
//        String resJson = doPost(url,map,charest);
//        //利用Gson转化为javaBean
//        Gson gson = new Gson();
////        Type type = new TypeToken<Map<String, Object>>() {}.getType();
////        Map<String,Object> creatMap = gson.fromJson(resJson,type);
////        Iterator iterator = creatMap.entrySet().iterator();
////        if(iterator.hasNext()){
////            Map.Entry<String, Object> elem = (Map.Entry<String, Object>) iterator.next();
////            System.out.println(elem.getKey()+":"+elem.getValue());
////        }
//        //转为msg
//
//        Msg msg = gson.fromJson(resJson.toString(),Msg.class);
//
//        return msg;
//
//
//
//    }
//
//
//    public static void main(String[] args){
//
//        HttpClientDemo2 httpClientDemo2 = new HttpClientDemo2();
//
//        String url = "https://www.xunmzy.com/tool/fm/music/index.php";
//        for(int i=0;i<20;i++){
//           Msg msg =  spiderMusic(url,i*30+"","陈奕迅");
//           System.out.println(msg);
//
//           List<Songs> list = msg.getResult().getSongs();
//
//            System.out.println(list.size());
//
//            for(Songs songs:list){
//                //用自定义javaBean保存数据
//                httpClientDemo2.saveSong(songs);
//                //保存唱片
//                httpClientDemo2.saveRecord(songs);
//                //保存歌手
//                httpClientDemo2.saveSinger(songs);
//            }
//
//        }
//
//
//
//    }
//
//    private void saveSinger(Songs songs) {
//        Singer singer = new Singer();
//        List<Artists> artists = songs.getArtists();
//        for(Artists artist:artists){
//            singer.setId(artist.getId());
//            singer.setName(artist.getName());
//            singer.setAlbumSize(artist.getAlbumSize());
//            singer.setImg1v1Id(artist.getImg1v1Id());
//            singer.setMusicSize(artist.getMusicSize());
//            singer.setPicId(artist.getPicId());
//            singer.setPicUrl(artist.getPicUrl());
//            singer.setImg1v1Url(artist.getImg1v1Url());
//            //save操作。。。
//            Singer singerTemp = singerRepository.getOne(singer.getId());
//            if(singerTemp.getId()==null){
//                singerRepository.save(singer);
//            }
//
//
//        }
//    }
//
//    private void saveRecord(Songs songs) {
//        Record record = new Record();
//        Album album = songs.getAlbum();
//        record.setId(album.getId());
//        record.setCommentThreadId(album.getCommentThreadId());
//        record.setCompany(album.getCompany());
//        record.setDescription(album.getDescription());
//        record.setName(album.getName());
//        record.setPicUrl(album.getPicUrl());
//        record.setSingerId(album.getArtist().getId());
//        record.setTags(album.getTags());
//        record.setType(album.getType());
//
//        //save操作。。
//        Record recordTemp = recordRepository.getOne(record.getId());
//        if(recordTemp.getId()==null){
//            recordRepository.save(record);
//        }
//
//    }
//
//    ////用自定义javaBean保存数据
//    private void saveSong(Songs songs) {
//        Song song =  new Song();
//        song.setId(songs.getId());
//        song.setName(songs.getName());
//        song.setCommentThreadId(songs.getCommentThreadId());
//        song.setMp3Url(songs.getMp3Url());
//        song.setMvid(songs.getMvid());
//        song.setRecordId(songs.getAlbum().getId());
//        //保存song。。。
//        songRepository.save(song);
//
//    }
//
//
//}
