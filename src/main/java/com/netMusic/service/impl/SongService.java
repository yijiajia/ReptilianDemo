package com.netMusic.service.impl;

import com.netMusic.dao.SongMapper;
import com.netMusic.entity.Song;
import com.netMusic.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {

    @Autowired
    private SongMapper songMapper;

    @Override
    public void insertEntity(Song song) {

        if(song!=null && song.getId()!=null){
            if(song.getMp3url()==null){
                song.setMp3url("http://music.163.com/song/media/outer/url?id="+song.getId());
            }
            songMapper.insert(song);
        }

    }


    public Song selectEntityById(Long id) {

        if(id!=null){
            Song song = songMapper.selectByPrimaryKey(id);
            return song;
        }
        return null;
    }

    @Override
    public void updateEntityById(Song song) {
       if(song!=null && song.getId()!=null){
           songMapper.updateByPrimaryKey(song);
       }

    }





}
