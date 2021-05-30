package com.pyb.tcpserver.server;

import com.pyb.tcpserver.dao.usersReopsitory;
import com.pyb.tcpserver.entities.User;
import com.pyb.tcpserver.entities.users;
import com.pyb.tcpserver.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pyb
 * @date 2021年05月22日 18:02
 */
@Service
public class UserService {
    @Autowired
    private usersReopsitory usersReopsitory;
    public User getUser(String name, String password){
        users user = usersReopsitory.findByUname(name);
        if (user != null) {
            String pwd = MD5.encrypt(password);
            if (user.getPassword().equals(pwd)) {
                User use=new User();
                use.setUserID(user.getId());
                use.setUserName(user.getUname());
                use.setPassWord(user.getPassword());
                System.out.println(use);
                return use;
            }else {
                return null;
            }

        }
        return null;

    }

    public User getUser(Integer id){
        users user = usersReopsitory.findById(id).get();
        if (user != null){
            User use=new User();
            use.setUserID(user.getId());
            use.setUserName(user.getUname());
            use.setPassWord(user.getPassword());
            return use;
        }
        else{
            return null;
        }
    }
}
