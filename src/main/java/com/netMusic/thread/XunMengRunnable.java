package com.netMusic.thread;

import com.netMusic.service.impl.XunMengService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class XunMengRunnable implements Runnable {

    private XunMengService xunMengService;

    private final static Logger logger = LoggerFactory.getLogger(XunMengRunnable.class);

    private String name;

    public XunMengRunnable(String name, XunMengService xunMengService) {
        this.name = name;
        this.xunMengService = xunMengService;
    }

    @Override
    public void run() {
            String songName = name;
            synchronized (songName){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                logger.info(new Date()+":"+name+"..........线程开启");
                System.out.println("---------------");
                xunMengService.saveAllBySongName(songName);
                logger.info(new Date()+":"+name+"....。。。..线程结束");
            }


    }

}
