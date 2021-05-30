package com.pyb.tcpserver.entities;

import javax.persistence.*;

/**
 * @author pyb
 * @date 2021年05月22日 16:02
 */
@Entity
public class users {
    @Id//表示是声明主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//配置主键的生成策略
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String uname;
    private String password;
    private Integer level;

    @Override
    public String toString() {
        return "users{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", level=" + level +
                '}';
    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
