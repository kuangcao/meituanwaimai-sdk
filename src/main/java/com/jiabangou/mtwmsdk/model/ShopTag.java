package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

public class ShopTag implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ShopTag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
