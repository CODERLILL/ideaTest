package com.lhl.service;

import com.lhl.bean.Photo;

public interface PhotoService {
    /**
     * 根据id查询
     **/
    Photo selectById(int ID);

    /**
     * 修改
     * */
    int edit(Photo photo);
    /**
     * 批量删除
     * */
    int batchDelete(Integer[] ids);
}
