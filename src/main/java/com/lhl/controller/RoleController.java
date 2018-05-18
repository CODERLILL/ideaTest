package com.lhl.controller;

import com.lhl.base.BaseController;
import com.lhl.base.ResponseHttpStatus;
import com.lhl.base.response.ResponseHead;
import com.lhl.bean.Role;
import com.lhl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;
    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    @ResponseBody
    public ResponseHead getRoleInfo(HttpServletResponse response,int sId){
        int status = response.getStatus();
        ResponseHead responseHead = createResponse();
        //try {
            if (status==200){
               Role role = roleService.getRoleInfo(sId);
               if (role==null||"".equals(role)){
                   return ResponseHttpStatus.errorRequest(responseHead,"没有此条数据-。-b");
               }else {
                   return ResponseHttpStatus.successRequest(responseHead,role);
               }
            }else {
               return ResponseHttpStatus.responseStatus(responseHead,status);
            }
       // } catch (Exception e) {
            //e.printStackTrace();
           // return ResponseHttpStatus.errorRequest(responseHead,e);
        //}

    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> test(int sId){
        Role role = roleService.getRoleInfo(sId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("role", role);
        return map;
    }

}
