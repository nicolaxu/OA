package com.lanshui.oa.view.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class User implements Serializable{

    int id;
    String gUid;
    String username;
    String password;
    String realName;
    int sex;
    int comId;
    int depId;
    String depName;
    int roleId;
    Date birthday;
    String QQ;
    String email;
    String tel;
    String phone;
    String photo;
    String ldInfo1;
    String ldInfo2;
    int isLock;
    String regFromIp;
    String regTime;
    String lastLoginIp;
    String notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getgUid() {
        return gUid;
    }

    public void setgUid(String gUid) {
        this.gUid = gUid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLdInfo1() {
        return ldInfo1;
    }

    public void setLdInfo1(String ldInfo1) {
        this.ldInfo1 = ldInfo1;
    }

    public String getLdInfo2() {
        return ldInfo2;
    }

    public void setLdInfo2(String ldInfo2) {
        this.ldInfo2 = ldInfo2;
    }

    public int getIsLock() {
        return isLock;
    }

    public void setIsLock(int isLock) {
        this.isLock = isLock;
    }

    public String getRegFromIp() {
        return regFromIp;
    }

    public void setRegFromIp(String regFromIp) {
        this.regFromIp = regFromIp;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
