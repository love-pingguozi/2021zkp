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
public class station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//配置主键的生成策略
    private Integer sid;
    private String sname;
    private String saddress;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    @Override
    public String toString() {
        return "Station{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", saddress='" + saddress + '\'' +
                '}';
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }
}
