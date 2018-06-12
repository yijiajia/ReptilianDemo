package com.netMusic.listener;

import com.netMusic.service.IRecordService;
import com.netMusic.service.ISingerService;
import com.netMusic.service.ISingerSongService;
import com.netMusic.service.ISongService;
import com.netMusic.service.impl.SongService;
import com.netMusic.thread.SpiderRecordRunnable;
import com.netMusic.thread.SpiderSingerRunnable;
import com.netMusic.thread.SpiderSongRunnnable;
import com.netMusic.utils.BaseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;
import java.util.List;

//获取spring容器内的上下文，拿到BaseService的Bean
//        baseService = WebApplicationContextUtils
//                .getWebApplicationContext(servletContextEvent.getServletContext()).getBean(XunMengService.class);


//启动添加数据的线程
//        for(int i=0;i<20;i++){
//            for(int j=1;j<3;j++){
//                XunMengRunnable xunMengRunnable = new XunMengRunnable(CharacterUtils.getRandomString(j),xunMengService);
//                Thread thread = new Thread(xunMengRunnable);
//                thread.start();
//            }
//
//        }
@WebListener
@Component
public class SaveDataListener implements ServletContextListener {

//    @Autowired
//    private XunMengService xunMengService;

    @Autowired
    private  ISongService songService;
    @Autowired
    private ISingerSongService singerSongService;
    @Autowired
    private ISingerService singerService;
    @Autowired
    private IRecordService recordService;

    private final static Logger logger = LoggerFactory.getLogger(SaveDataListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info(new Date()+"自定义监听器启动。。。");
        System.out.println("自定义监听器启动。。。");

        //获取spring容器内的上下文，拿到BaseService的Bean
        songService = WebApplicationContextUtils
                         .getWebApplicationContext(servletContextEvent.getServletContext()).getBean(SongService.class);


        for(int i=0;i<10;i++){
            List<Integer> listId = BaseUtil.getRandomNumber(1000,10000,1000);
            //song线程
            SpiderSongRunnnable spiderSongRunnnable = new SpiderSongRunnnable(songService,
                                singerSongService,listId);

            Thread songThread = new Thread(spiderSongRunnnable);
            songThread.start();
            //singer线程
            logger.info(new Date()+"singer线程开启-------");
            SpiderSingerRunnable spiderSingerRunnable = new SpiderSingerRunnable(singerService,listId);
            Thread singerThread = new Thread(spiderSingerRunnable);
            singerThread.start();
            //record线程
            logger.info("record线程开启-------");
            SpiderRecordRunnable spiderRecordRunnable = new SpiderRecordRunnable(recordService,listId);
            Thread recordThread = new Thread(spiderRecordRunnable);
            recordThread.start();
        }

    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("自定义监听器销毁。。。");
        System.out.println("自定义监听器销毁。。。");

    }
}
