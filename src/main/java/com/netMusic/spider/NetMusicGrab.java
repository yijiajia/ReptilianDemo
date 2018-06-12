package com.netMusic.spider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.netMusic.entity.Record;
import com.netMusic.entity.Singer;
import com.netMusic.entity.custom2.SongMsg;
import com.netMusic.utils.CharacterUtils;
import com.netMusic.utils.HttpClientUtil;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 歌曲爬取类
 */
public class NetMusicGrab {

    private final static Logger logger = LoggerFactory.getLogger(NetMusicGrab.class);

    public static List<SongMsg> getSongList(String url,String charest) {
        Document document = getDocument(url, charest);
        if(document!=null){
            Elements elements = document.select("#song-list-pre-data");
            System.out.println("json数据如下");
            String resJson = elements.text();
//            logger.info(resJson);
            Gson gson = new Gson();
            Type listType = new TypeToken<List<SongMsg>>() {}.getType();
            if(resJson!=null && !resJson.contains("html"));
            List<SongMsg> msgList = gson.fromJson(resJson, listType);
            return msgList;
        }
       return null;
    }


    public static Singer getSinger(String url,String charest){

        Document document = getDocument(url,charest);
        if(document!=null){
            Elements singerName = document.select("#artist-name");
            System.out.println("歌手名字："+singerName.text());
            Elements singerAlias = document.select("#artist-alias");
            String name="";
            if(singerAlias!=null && !"".equals(singerAlias.text())){
                System.out.println("歌手别名："+singerAlias.text());
                name = singerName.text()+"/"+singerAlias.text();
            }else{
                name = singerName.text();
            }

            Elements desc = document.select("body > div.g-bd4.f-cb > div.g-mn4 > div > div > div:nth-child(3) > div > p:nth-child(2)");
            Elements image = document.select("body > div.g-bd4.f-cb > div.g-mn4 > div > div > div.n-artist.f-cb > img");
            String intro = desc.text();
            String picUrl = image.attr("src");
            Singer singer = new Singer();
            singer.setName(name);
            if(intro.length()>=255 || "".equals(intro)){
                intro = "暂无介绍";
            }
            singer.setIntro(intro);
            singer.setPicUrl(picUrl);
            return singer;
        }

        return null;
    }

    public static List<Record> getRecordList(String url,String charest){

        List<Record> recordList = new ArrayList<>();
        String publishTime = null;
        String company = null;

        Document document  = getDocument(url,charest);
        if(document!=null){
            Elements elements = document.select("#m-song-module");
            for(Element element :elements){
                //专辑链接
                Elements urlElement = element.select("#m-song-module > li:nth-child(1) > div > a.msk");
                String albumUrl = urlElement.select(".msk").attr("href");
                if(!albumUrl.contains("https://")){
                    albumUrl = "https://music.163.com"+albumUrl;
                }
                Elements elementsAlbumId = element.select("#m-song-module > li:nth-child(1) > div > a.icon-play.f-alpha");
                String albumId = elementsAlbumId.attr("data-res-id");
                try {
                    Document albumDec = Jsoup.connect(albumUrl).
                            userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                            .get();

                    Elements main = albumDec.select("body > div.g-bd4.f-cb.p-share > div.g-mn4 > div > div > div.m-info.f-cb > div.cnt > div > div.topblk");


                    Elements elementsName = main.select("div > div > h2");
                    String albumName = elementsName.text();
                    Elements elementsPublishTime = main.select("p:nth-child(3)");
                    if(elementsPublishTime!=null && !"".equals(elementsPublishTime.text()) ){
                       publishTime = elementsPublishTime.text().substring(5);
                    }
                    Elements elementsCompany = main.select("p:nth-child(4)");

                    if(elementsCompany!=null && !"".equals(elementsCompany.text()) ){
                        company = elementsCompany.text().substring(5);
                    }
                    //如果包含中文，则说明该字段为company
                    if(CharacterUtils.isContainChinese(publishTime)){
                        company = publishTime;
                        publishTime = null;
                    }

                    Elements elementsCommentId = albumDec.select("#cnt_comment_count");
                    String commentId = elementsCommentId.text();
                    if(CharacterUtils.isContainChinese(commentId)){
                        commentId = null;
                    }
                    Elements elementsImg = albumDec.select("body > div.g-bd4.f-cb.p-share > div.g-mn4 > div > div > div.m-info.f-cb > div.cover.u-cover.u-cover-alb > img");
                    String picUrl = elementsImg.attr("data-src");
                    Elements elementsIntro = albumDec.select("#album-desc-dot");
                    String intro = elementsIntro.text();
                    if(intro.length()>=255 || intro.length()<=1){
                        intro = "暂无介绍";
                    }
                    Record record = new Record();
                    record.setId(Integer.valueOf(albumId));
                    record.setIntro(intro);
                    record.setPicUrl(picUrl);
                    record.setName(albumName);
                    record.setCompany(company);
                    record.setCommentThreadId(commentId);
                    if(publishTime!=null){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = sdf.parse(publishTime);
                        record.setPublishTime(date);
                    }else{
                        record.setPublishTime(null);
                    }
                    recordList.add(record);

                } catch (IOException e) {
                    e.printStackTrace();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }

        return recordList;
    }




    private static Document getDocument(String url, String charest) {
        List<Header> headerList = new ArrayList<>();
        headerList.add(new BasicHeader("Host", "music.163.com"));
        headerList.add(new BasicHeader("Referer", "https://music.163.com/"));
        headerList.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36"));

        String result = HttpClientUtil.doGet(url, headerList, charest);
        if(result!=null && !result.contains("n-for404")){
            return Jsoup.parse(result);
        }
        return null;
    }


    public static void main(String[] args) throws ParseException {
//        测试获取歌手信息
//        List<Integer> listId = BaseUtil.getRandomNumber(1000,10000,
//        }
        //测试专辑信息100);
        ////        for(Integer id:listId){
        ////            Singer singer = getSinger("https://music.163.com/artist/desc?id="+id,"utf-8");
        ////            System.out.println(singer);
//        getRecordList("https://music.163.com/artist/album?id=3684&limit=100&offset=0","utf-8");

        //测试字符串转时间
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse("2017-12-12");
//        System.out.println(date);

    }
}