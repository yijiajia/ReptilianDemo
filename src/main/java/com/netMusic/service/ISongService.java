package com.netMusic.service;

import com.netMusic.entity.Song;

public interface ISongService extends IBaseService<Song>{

    public Song selectEntityById(Long id);



}
