package com.pyb.tcpserver.controller;

import com.pyb.tcpserver.interAnno.LoginToken;
import com.pyb.tcpserver.utils.startAccept;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pyb
 * @date 2021年05月21日 15:56
 */

@RestController
@RequestMapping("/cd")
public class firstController {
    @LoginToken
    @RequestMapping(value = "/pybtest",method = RequestMethod.GET)
    public String testMothod(String con){
        System.out.println("hhhhhhh");
        new startAccept.PrintOutThread("192.168.1.122",con);
        return  "发送成功";
    }
}
