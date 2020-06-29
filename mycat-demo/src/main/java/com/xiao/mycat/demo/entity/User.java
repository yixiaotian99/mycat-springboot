package com.xiao.mycat.demo.entity;

import java.io.Serializable;

/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2020-06-29 11:03:08
 */
public class User implements Serializable {
    private static final long serialVersionUID = 414161428507259387L;
    
    private Long id;
    
    private String username;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}