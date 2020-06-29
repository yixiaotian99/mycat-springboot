package com.xiao.mycat.orders.entity;

import java.io.Serializable;

/**
 * (TOrder)实体类
 *
 * @author makejava
 * @since 2020-06-29 11:59:32
 */
public class TOrder implements Serializable {
    private static final long serialVersionUID = 222064778127639299L;
    
    private Long id;
    
    private String name;
    /**
    * id
    */
    private Long companyId;


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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

}