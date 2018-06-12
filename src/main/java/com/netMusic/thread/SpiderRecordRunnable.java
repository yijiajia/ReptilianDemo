package com.netMusic.thread;

import com.netMusic.entity.Record;
import com.netMusic.service.IRecordService;
import com.netMusic.spider.NetMusicGrab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class SpiderRecordRunnable implements Runnable {

    private IRecordService recordService;
    private List<Integer> listId;
    private final static Logger logger = LoggerFactory.getLogger(SpiderRecordRunnable.class);

    public SpiderRecordRunnable(IRecordService recordService, List<Integer> listId) {
        this.recordService = recordService;
        this.listId = listId;
    }


    @Override
    public void run() {
        logger.info(new Date()+Thread.currentThread().getName()+":..........线程开启");
        System.out.println("---------------");
        //插入音乐
        insertRecord();
        logger.info(new Date()+Thread.currentThread().getName()+":....。。。..线程结束");
    }

    /**
     * 插入专辑
     */
    private void insertRecord() {

        if(listId!=null){
            for(Integer singerId:listId){
                String url = "https://music.163.com/artist/album?id="+singerId+"&limit=100&offset=0";
                String charest = "utf-8";
                List<Record> list = NetMusicGrab.getRecordList(url,charest);
                if(list!=null && list.size()>0){
                    for(Record record:list){
                        if(record!=null && record.getId()!=null){
                            Record record1 = recordService.selectEntityById(record.getId());
                            if (record1 == null) {
                                record.setSingerId(singerId);
                                recordService.insertEntity(record);
                            }

                        }
                    }

                }


            }
        }



    }
}
