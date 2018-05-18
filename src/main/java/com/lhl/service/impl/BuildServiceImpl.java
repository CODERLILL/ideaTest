package com.lhl.service.impl;

import com.lhl.bean.Build;
import com.lhl.bean.PageBean;
import com.lhl.bean.SearchBuild;
import com.lhl.mapper.BuildMapper;
import com.lhl.service.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuildServiceImpl implements BuildService {
    @Autowired
    private BuildMapper buildMapper;

    @Override
    public List<Build> findAll() {
        return buildMapper.findAll();
    }

    @Override
    public List<Build> searchByCondition(SearchBuild searchBuild) {

        return buildMapper.search(searchBuild);
    }

    @Override
    public PageBean<Build> findByPage(int currentPage) {
        Map<String,Object> map = new HashMap<String, Object>();
        PageBean<Build> pageBean = new PageBean<Build>();
        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //每页显示的数据
        int pageSize=3;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = buildMapper.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<Build> lists = buildMapper.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }
    //查询总数
    @Override
    public int selectCount() {
        return buildMapper.selectCount();
    }
    @Override
    //根据id删除
    public int deleteByBuildId(int ID){
        return buildMapper.deleteByBuildId(ID);
    }
}
