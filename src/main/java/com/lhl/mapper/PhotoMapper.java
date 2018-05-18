package com.lhl.mapper;

import com.lhl.bean.Photo;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoMapper {
    /**
    * 据id查询
    * */
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
