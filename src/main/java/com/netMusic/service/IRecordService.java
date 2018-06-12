package com.netMusic.service;

import com.netMusic.entity.Record;

public interface IRecordService extends IBaseService<Record>{

    public Record selectEntityById(Integer id);


}
