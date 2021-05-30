package com.pyb.tcpserver.dao;

import com.pyb.tcpserver.entities.users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pyb
 * @date 2021年05月22日 16:07
 */
public interface usersReopsitory extends JpaRepository<users,Integer> {
    users findByUname(String name);
}
