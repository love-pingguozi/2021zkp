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
public class cabinetinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//配置主键的生成策略
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer rid;
    private String rname;


    private String cname;
    private Integer fdoor_statu;
    private Integer adoor_statu;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getCname() {
        return cname;
    }

    @Override
    public String toString() {
        return "cabinetinfo{" +
                "id=" + id +
                ", rid=" + rid +
                ", rname='" + rname + '\'' +
                ", cname='" + cname + '\'' +
                ", fdoor_statu=" + fdoor_statu +
                ", adoor_statu=" + adoor_statu +
                '}';
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getFdoor_statu() {
        return fdoor_statu;
    }

    public void setFdoor_statu(Integer fdoor_statu) {
        this.fdoor_statu = fdoor_statu;
    }

    public Integer getAdoor_statu() {
        return adoor_statu;
    }

    public void setAdoor_statu(Integer adoor_statu) {
        this.adoor_statu = adoor_statu;
    }
}
