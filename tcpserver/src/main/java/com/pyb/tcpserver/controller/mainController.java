package com.pyb.tcpserver.controller;

import com.pyb.tcpserver.dao.usersReopsitory;
import com.pyb.tcpserver.entities.User;
import com.pyb.tcpserver.entities.users;
import com.pyb.tcpserver.interAnno.LoginToken;
import com.pyb.tcpserver.interAnno.PassToken;
import com.pyb.tcpserver.server.TokenService;
import com.pyb.tcpserver.server.UserService;
import com.pyb.tcpserver.utils.MD5;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pyb
 * @date 2021年05月22日 17:41
 */
@RestController
@RequestMapping("/cdmain")
public class mainController {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @PassToken
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Object login(String username, String password){
        JSONObject jsonObject=new JSONObject();
        User user=userService.getUser(username, password);
        if(user==null){
            jsonObject.put("message","登录失败！");
            return jsonObject;
        }else {
            String token = tokenService.getToken(user);
            jsonObject.put("token", token);
            jsonObject.put("user", user);
            return jsonObject;
        }
    }
}
