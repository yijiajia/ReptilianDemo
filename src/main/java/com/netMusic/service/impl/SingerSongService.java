package com.netMusic.service.impl;

import com.netMusic.dao.SingerSongMapper;
import com.netMusic.entity.SingerSong;
import com.netMusic.entity.SingerSongKey;
import com.netMusic.service.ISingerSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingerSongService implements ISingerSongService {

    @Autowired
    private SingerSongMapper singerSongMapper;

    @Override
    public void insertEntity(SingerSong entity) {
        if(entity!=null){
            singerSongMapper.insert(entity);
        }
    }


    @Override
    public SingerSong selectEntityById(SingerSongKey singerSongKey) {
        if(singerSongKey!=null){
            return singerSongMapper.selectBySingerId(singerSongKey);
        }

        return null;
    }

    @Override
    public void updateEntityById(SingerSong entity) {

    }
}
