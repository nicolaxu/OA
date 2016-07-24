package com.lanshui.oa.view.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21 0021.
 * 接收者类
 */
public class Recipient implements Serializable{
    int id;
    String gUid;    //用户唯一标识
    String name;
    String dep;

    public String getgUid() {
        return gUid;
    }

    public void setgUid(String gUid) {
        this.gUid = gUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
