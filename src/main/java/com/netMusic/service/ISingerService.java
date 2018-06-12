package com.netMusic.service;

import com.netMusic.entity.Singer;

public interface ISingerService extends IBaseService<Singer> {


    Singer selectEntityById(Integer id);
}
