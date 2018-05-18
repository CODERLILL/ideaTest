package com.lhl.bean;

import java.sql.Date;
/**
 *模糊查询封装类
 */
public class SearchBuild {
    private int ID;
    private String buildName;
    private String dvpCompany;
    private String proVince;
    private String City;
    private String Area;
    private String designCompany;
    private String sightCompany;
    private String pmCompany;
    private String SG;
    private String isChoice;
    private String Delivery;
    private String Periods;
    private String buildingNm;
    private String taskStatus;
    private Date buildTime;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getDvpCompany() {
        return dvpCompany;
    }

    public void setDvpCompany(String dvpCompany) {
        this.dvpCompany = dvpCompany;
    }

    public String getProVince() {
        return proVince;
    }

    public void setProVince(String proVince) {
        this.proVince = proVince;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getDesignCompany() {
        return designCompany;
    }

    public void setDesignCompany(String designCompany) {
        this.designCompany = designCompany;
    }

    public String getSightCompany() {
        return sightCompany;
    }

    public void setSightCompany(String sightCompany) {
        this.sightCompany = sightCompany;
    }

    public String getPmCompany() {
        return pmCompany;
    }

    public void setPmCompany(String pmCompany) {
        this.pmCompany = pmCompany;
    }

    public String getSG() {
        return SG;
    }

    public void setSG(String SG) {
        this.SG = SG;
    }

    public String getIsChoice() {
        return isChoice;
    }

    public void setIsChoice(String isChoice) {
        this.isChoice = isChoice;
    }

    public String getDelivery() {
        return Delivery;
    }

    public void setDelivery(String delivery) {
        Delivery = delivery;
    }

    public String getPeriods() {
        return Periods;
    }

    public void setPeriods(String periods) {
        Periods = periods;
    }

    public String getBuildingNm() {
        return buildingNm;
    }

    public void setBuildingNm(String buildingNm) {
        this.buildingNm = buildingNm;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Date buildTime) {
        this.buildTime = buildTime;
    }

    @Override
    public String toString() {
        return "SearchBuild{" +
                "ID=" + ID +
                ", buildName='" + buildName + '\'' +
                ", dvpCompany='" + dvpCompany + '\'' +
                ", proVince='" + proVince + '\'' +
                ", City='" + City + '\'' +
                ", Area='" + Area + '\'' +
                ", designCompany='" + designCompany + '\'' +
                ", sightCompany='" + sightCompany + '\'' +
                ", pmCompany='" + pmCompany + '\'' +
                ", SG='" + SG + '\'' +
                ", isChoice='" + isChoice + '\'' +
                ", Delivery='" + Delivery + '\'' +
                ", Periods='" + Periods + '\'' +
                ", buildingNm='" + buildingNm + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", buildTime='" + buildTime + '\'' +
                '}';
    }
}
