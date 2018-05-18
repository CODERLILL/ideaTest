package com.lhl.controller;

import com.lhl.base.BaseController;
import com.lhl.base.ResponseHttpStatus;
import com.lhl.base.response.ResponseHead;
import com.lhl.bean.Build;
import com.lhl.bean.SearchBuild;
import com.lhl.service.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/build")
public class BuildController extends BaseController {
    @Autowired
    private BuildService buildService;

    private int status = 0;

    //查询所有
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ResponseBody
    public ResponseHead findAll(HttpServletResponse response){
        status = response.getStatus();
        ResponseHead responseHead = createResponse();
        if(status==200){
            List<Build> build=buildService.findAll();
            return ResponseHttpStatus.successRequest(responseHead,build);
        }else {
            return ResponseHttpStatus.responseStatus(responseHead,status);
        }
    }

    //多条件查询
    @RequestMapping(value = "/search",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public List<Build> searchByCondition(SearchBuild searchBuild){
        //ModelAndView modelAndView = new ModelAndView();
        List<Build> list = buildService.searchByCondition(searchBuild);
        //modelAndView.addObject("searchBuild",list);
        System.out.println(list);
        return list;
    }
    //根据id删除
    @RequestMapping(value = "/deleteBuild",method = RequestMethod.GET)
    @ResponseBody
    public ResponseHead deleteByUserId(HttpServletResponse response,@RequestParam("ID") Integer ID) {
        ResponseHead responseHead = createResponse();
        status = response.getStatus();
        if (status == 200) {
            int a = buildService.deleteByBuildId(ID);
            System.out.println(a);
            if (a==1) {
                return ResponseHttpStatus.successRequest(responseHead, "删除成功");
            } else {
                ResponseHttpStatus.errorRequest(responseHead, "删除失败");
            }
        }
        return ResponseHttpStatus.responseStatus(responseHead, status);
    }
    //test
    @RequestMapping(value = "/test",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String test(){
        return "已认证！！！";
    }
}

