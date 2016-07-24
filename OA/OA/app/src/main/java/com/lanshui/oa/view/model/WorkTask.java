package com.lanshui.oa.view.model;

/**
 * Created by Administrator on 2016/7/22 0022.
 */
public class WorkTask {
    int id;
    int comId;
    String TaskName;
    int typeId;
    String important;
    int status;
    int isOtherSee;
    int onceSubmit;
    int creatorId;
    String creatorRealName;
    String creatorDepName;
    String manageUserList;
    String manageNameList;
    String executeUserList;
    String executeNameList;
    String addTime;
    String expectTime;
    String notes;
    int isComplete;
    String filePath;
    String records;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getImportant() {
        return important;
    }

    public void setImportant(String important) {
        this.important = important;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsOtherSee() {
        return isOtherSee;
    }

    public void setIsOtherSee(int isOtherSee) {
        this.isOtherSee = isOtherSee;
    }

    public int getOnceSubmit() {
        return onceSubmit;
    }

    public void setOnceSubmit(int onceSubmit) {
        this.onceSubmit = onceSubmit;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorRealName() {
        return creatorRealName;
    }

    public void setCreatorRealName(String creatorRealName) {
        this.creatorRealName = creatorRealName;
    }

    public String getCreatorDepName() {
        return creatorDepName;
    }

    public void setCreatorDepName(String creatorDepName) {
        this.creatorDepName = creatorDepName;
    }

    public String getManageUserList() {
        return manageUserList;
    }

    public void setManageUserList(String manageUserList) {
        this.manageUserList = manageUserList;
    }

    public String getManageNameList() {
        return manageNameList;
    }

    public void setManageNameList(String manageNameList) {
        this.manageNameList = manageNameList;
    }

    public String getExecuteUserList() {
        return executeUserList;
    }

    public void setExecuteUserList(String executeUserList) {
        this.executeUserList = executeUserList;
    }

    public String getExecuteNameList() {
        return executeNameList;
    }

    public void setExecuteNameList(String executeNameList) {
        this.executeNameList = executeNameList;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(String expectTime) {
        this.expectTime = expectTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(int isComplete) {
        this.isComplete = isComplete;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }
}
