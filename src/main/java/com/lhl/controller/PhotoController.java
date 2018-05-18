package com.lhl.controller;

import com.lhl.base.BaseController;
import com.lhl.base.ResponseHttpStatus;
import com.lhl.base.response.ResponseHead;
import com.lhl.bean.Photo;
import com.lhl.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 照片相关控制类
 **/
@Controller
@RequestMapping(value = "/photo")
public class PhotoController extends BaseController {
    private int status = 0;
    @Autowired
    private PhotoService photoService;

    /**
     * 根据id查询一条数据
     * */
    @RequestMapping(value = "selectOne",method = RequestMethod.GET)
    @ResponseBody
    public ResponseHead showOne(HttpServletResponse response, int ID){
        ResponseHead responseHead = createResponse();
         status = response.getStatus();
         if (status==200){
           Photo photo = photoService.selectById(ID);
            if(photo==null || "".equals(photo)){
                return ResponseHttpStatus.errorRequest(responseHead,"数据不存在-.-!");
            }else{
                return ResponseHttpStatus.successRequest(responseHead,photo);
            }
         }else {
            return ResponseHttpStatus.responseStatus(responseHead,status);
         }
    }

    /**
     *根据pId修改
     * */
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    @ResponseBody
    public ResponseHead edit(HttpServletResponse response,Photo photo){
        ResponseHead responseHead = createResponse();
        status = response.getStatus();
        if(status==200){
            int a = photoService.edit(photo);
            if(a==1){
                return ResponseHttpStatus.successRequest(responseHead,"修改成功");
            }else {
                return ResponseHttpStatus.errorRequest(responseHead,"修改失败");
            }
        }else {
            return ResponseHttpStatus.responseStatus(responseHead,status);
        }
    }
    /**
     * 批量删除
     * */
    @RequestMapping(value = "/batchDelete",method = RequestMethod.GET)
    @ResponseBody
    public ResponseHead batchDelete(HttpServletResponse response,Integer[] ids){
        ResponseHead responseHead = createResponse();
        status = response.getStatus();
        if (status==200){
            int i = photoService.batchDelete(ids);
            if(i==1){
                return ResponseHttpStatus.successRequest(responseHead,"批量删除成功:)!!");
            }else {
                return ResponseHttpStatus.errorRequest(responseHead,"批量删除失败:(!!");
            }
        }else {
            return ResponseHttpStatus.responseStatus(responseHead,status);
        }

    }
}
