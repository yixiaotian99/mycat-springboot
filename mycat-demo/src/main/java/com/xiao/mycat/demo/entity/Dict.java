package com.xiao.mycat.demo.entity;

import java.io.Serializable;

/**
 * (TDict)实体类
 *
 * @author makejava
 * @since 2020-06-29 11:30:24
 */
public class Dict implements Serializable {
    private static final long serialVersionUID = 899952717369451201L;
    
    private Long id;
    
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}