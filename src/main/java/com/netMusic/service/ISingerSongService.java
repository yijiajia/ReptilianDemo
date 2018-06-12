package com.netMusic.service;

import com.netMusic.entity.SingerSong;
import com.netMusic.entity.SingerSongKey;

public interface ISingerSongService extends IBaseService<SingerSong> {

    public SingerSong selectEntityById(SingerSongKey singerSongKey);
}
