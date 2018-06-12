package com.netMusic.thread;

import com.netMusic.entity.Singer;
import com.netMusic.service.ISingerService;
import com.netMusic.spider.NetMusicGrab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class SpiderSingerRunnable implements Runnable {

    private ISingerService singerService;
    private List<Integer> listId;
    private final static Logger logger = LoggerFactory.getLogger(SpiderSingerRunnable.class);

    public SpiderSingerRunnable(ISingerService singerService, List<Integer> listId) {
        this.singerService = singerService;
        this.listId = listId;
    }

    @Override
    public void run() {
        logger.info(new Date()+Thread.currentThread().getName()+":..........线程开启");
        System.out.println("---------------");
        //插入音乐
        insertSinger();
        logger.info(new Date()+Thread.currentThread().getName()+":....。。。..线程结束");

    }

    private void insertSinger() {
        if(listId!=null){
            for(Integer id:listId){
                String url = "https://music.163.com/artist/desc?id="+id;
                String charest = "utf-8";
                Singer singer = NetMusicGrab.getSinger(url,charest);
                if(singer!=null){
                    Singer singer1 = singerService.selectEntityById(id);
                    if(singer1==null){
                        singer.setId(id);
                        singerService.insertEntity(singer);
                    }
                }
            }
        }

    }
}
