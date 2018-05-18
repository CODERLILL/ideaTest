package com.lhl.service;

import com.lhl.bean.Build;
import com.lhl.bean.PageBean;
import com.lhl.bean.SearchBuild;

import java.util.List;

public interface BuildService {
     /**
      *查询所有
      * */
     List<Build> findAll();
     /**
      *多条件查询
      * */
     List<Build> searchByCondition(SearchBuild searchBuild);
     /**
      *分页
      * */
     PageBean<Build> findByPage(int currentPage);
     /**
      *记录总数
      * */
     int selectCount();
     /**
      *根据id删除
      * */
     int deleteByBuildId(int ID);
}
