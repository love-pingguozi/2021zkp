package com.pyb.tcpserver.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author pyb
 * @date 2021年05月22日 16:14
 */
@Entity
public class stationroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//配置主键的生成策略
    private Integer id;
    private String sname;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "stationroom{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", rname='" + rname + '\'' +
                ", srid=" + srid +
                ", rIP='" + rIP + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Integer getSrid() {
        return srid;
    }

    public void setSrid(Integer srid) {
        this.srid = srid;
    }

    public String getrIP() {
        return rIP;
    }

    public void setrIP(String rIP) {
        this.rIP = rIP;
    }

    private String rname;
    private Integer srid;
    private String rIP;


}
