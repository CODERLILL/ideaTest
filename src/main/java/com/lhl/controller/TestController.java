package com.lhl.controller;

import com.lhl.bean.User;
import com.lhl.service.TestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/testRedis")
public class TestController {
    private final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    private TestService testService;
    /**
     * 保存用户
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    @ResponseBody
    public Integer save(){
        User user = new User();
        user.setUid(789);
        user.setUsername("lll7");
        user.setPassword("7489");
        testService.saveUser(user);
        return 1;
    }
    /**
     * 根据用户id获取用户信息
     * @return
     */
    @RequestMapping(value = "/getUserById",method = RequestMethod.GET)
    @ResponseBody
    public Object getUserById(@RequestParam(value="id", defaultValue="0") String id){
        User user = testService.getUserById(Integer.parseInt(id));
        logger.debug(user.toString());
        return user;
    }
}
