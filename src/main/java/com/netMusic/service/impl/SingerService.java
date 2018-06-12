package com.netMusic.service.impl;

import com.netMusic.dao.SingerMapper;
import com.netMusic.entity.Singer;
import com.netMusic.service.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingerService implements ISingerService {

    @Autowired
    private SingerMapper singerMapper;

    @Override
    public void insertEntity(Singer entity) {
        if(entity!=null && entity.getId()!=null){
            singerMapper.insert(entity);
        }
    }


    public Singer selectEntityById(Integer id) {

        if(id!=null){
           return singerMapper.selectByPrimaryKey(id);
        }

        return null;
    }

    @Override
    public void updateEntityById(Singer entity) {

    }
}
