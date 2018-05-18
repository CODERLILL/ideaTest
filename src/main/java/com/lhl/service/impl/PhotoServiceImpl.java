package com.lhl.service.impl;

import com.lhl.bean.Photo;
import com.lhl.mapper.PhotoMapper;
import com.lhl.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {


    @Autowired
    private PhotoMapper photoMapper;
    /**
     * 根据id查询
     * */
    @Override
    public Photo selectById(int ID) {
        return photoMapper.selectById(ID);
    }
    /**
     * 修改
     * */
    @Override
    public int edit(Photo photo) {
        return photoMapper.edit(photo);
    }
    /**
     * 批量删除
     * */
    @Override
    public int batchDelete(Integer[] ids) {
        return photoMapper.batchDelete(ids);
    }


}
