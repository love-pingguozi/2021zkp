package com.pyb.tcpserver.controller;

import com.pyb.tcpserver.dao.cabinetinfoReopsitory;
import com.pyb.tcpserver.dao.stationReopsitory;
import com.pyb.tcpserver.dao.stationRoomReopsitory;
import com.pyb.tcpserver.dao.usersReopsitory;
import com.pyb.tcpserver.entities.cabinetinfo;
import com.pyb.tcpserver.entities.station;
import com.pyb.tcpserver.entities.stationroom;
import com.pyb.tcpserver.interAnno.LoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pyb
 * @date 2021年05月22日 15:20
 */

@RestController
@RequestMapping("/cdStation")
public class secondController {
    @Autowired
    private stationReopsitory stationReopsitory;
    @Autowired
    private stationRoomReopsitory stationRoomReopsitory;
    @Autowired
    private cabinetinfoReopsitory cabinetinfoReopsitory;

    @LoginToken
    @RequestMapping(value = "/getStation",method = RequestMethod.GET)
    public List<String> getStation(){
        List list=new ArrayList();
        List<station> all = stationReopsitory.findAll();
        for (com.pyb.tcpserver.entities.station station:all) {
            list.add(station.getSname());
        }
        return list;
    }
    @LoginToken
    @RequestMapping(value = "/getStationRoom",method = RequestMethod.GET)
    public List<stationroom> getStationRoom(Integer Sid){
        List<stationroom> all = stationRoomReopsitory.findBySrid(Sid);
        return all;
    }
    @LoginToken
    @RequestMapping(value = "/getCabinet",method = RequestMethod.GET)
    public List<cabinetinfo> getCabinet(Integer id){
        List<cabinetinfo> all = cabinetinfoReopsitory.findByRid(id);
        return all;
    }
}
