package com.lanshui.oa.view.model;

/**
 * Created by xu on 2016/7/24.
 */
public class Gov extends TransFlow{
    int id;
    String guid;
    int comId;
    String flowName;
    int currentStepId;
    String currentStepName;
    String currentStepUserList;
    String hasOperatedUserList;
    int creatorId;
    String creatorRealName;
    String creatorDepName;
    String remark;
    int status;
    String flowFiles;
    String addTime;
    String validTime;
    int isValid;
    String currentDocPath;
    String docNo;
    String secret;
    String modelName;
    String docBody;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public int getCurrentStepId() {
        return currentStepId;
    }

    public void setCurrentStepId(int currentStepId) {
        this.currentStepId = currentStepId;
    }

    public String getCurrentStepName() {
        return currentStepName;
    }

    public void setCurrentStepName(String currentStepName) {
        this.currentStepName = currentStepName;
    }

    public String getCurrentStepUserList() {
        return currentStepUserList;
    }

    public void setCurrentStepUserList(String currentStepUserList) {
        this.currentStepUserList = currentStepUserList;
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

    public String getHasOperatedUserList() {
        return hasOperatedUserList;
    }

    public void setHasOperatedUserList(String hasOperatedUserList) {
        this.hasOperatedUserList = hasOperatedUserList;
    }

    public String getCreatorDepName() {
        return creatorDepName;
    }

    public void setCreatorDepName(String creatorDepName) {
        this.creatorDepName = creatorDepName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFlowFiles() {
        return flowFiles;
    }

    public void setFlowFiles(String flowFiles) {
        this.flowFiles = flowFiles;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    public String getCurrentDocPath() {
        return currentDocPath;
    }

    public void setCurrentDocPath(String currentDocPath) {
        this.currentDocPath = currentDocPath;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getDocBody() {
        return docBody;
    }

    public void setDocBody(String docBody) {
        this.docBody = docBody;
    }
}
