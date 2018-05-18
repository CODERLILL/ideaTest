package com.lhl.mapper;

import com.lhl.bean.Build;
import com.lhl.bean.SearchBuild;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BuildMapper {
    /**
     * 展示所有
     */
    List<Build> findAll();
    /**
     * 根据条件查询
     * */
    List<Build> search(SearchBuild searchBuild);
    /**
     * 分页
     */
    List<Build> findByPage(Map<String,Object> map);
    /**
     * 查询记录总数
     * */
    int selectCount();
    /**
     * 根据id删除
     * */
    int deleteByBuildId(int ID);
}
