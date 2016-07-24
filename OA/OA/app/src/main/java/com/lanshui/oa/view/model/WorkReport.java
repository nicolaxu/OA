package com.lanshui.oa.view.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/7/20 0020.
 */
public class WorkReport implements Serializable{

    int id;
    int comId;
    Date nReportDate;
    String nTitle;
    String nContent;
    Date nCreateTime;
    int nCreateUid;
    String filePath;
    String mShareUsers;
    String nameList;

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getnReportDate() {
        return nReportDate;
    }

    public void setnReportDate(Date nReportDate) {
        this.nReportDate = nReportDate;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public String getnContent() {
        return nContent;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    public Date getnCreateTime() {
        return nCreateTime;
    }

    public void setnCreateTime(Date nCreateTime) {
        this.nCreateTime = nCreateTime;
    }

    public int getnCreateUid() {
        return nCreateUid;
    }

    public void setnCreateUid(int nCreateUid) {
        this.nCreateUid = nCreateUid;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getmShareUsers() {
        return mShareUsers;
    }

    public void setmShareUsers(String mShareUsers) {
        this.mShareUsers = mShareUsers;
    }

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }
}
