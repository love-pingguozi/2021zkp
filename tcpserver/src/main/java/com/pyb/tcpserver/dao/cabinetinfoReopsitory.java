package com.pyb.tcpserver.dao;

import com.pyb.tcpserver.entities.cabinetinfo;
import com.pyb.tcpserver.entities.station;
import com.pyb.tcpserver.entities.stationroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author pyb
 * @date 2021年05月22日 16:07
 */
public interface cabinetinfoReopsitory extends JpaRepository<cabinetinfo,Integer> {
    List<cabinetinfo> findByRid(Integer id);//
}
