package com.lhl.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
/**
 *照片实体类
 */
public class Photo {
    private Integer pId;

    private String pType;

    private String pCity;

    private Integer pBId;

    private String pHousehold;

    private String pUnit;

    private String pFloor;

    private String pDoorModel;

    private String pBedroom;

    private String pWall;

    private String pNote1;

    private String pNote2;

    private String pNote3;

    private String pPoints;

    private String pMeasurement;

    private String pLable;

    private String pPhoto;

    private String pAddress;

    private Date pTime;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getpCity() {
        return pCity;
    }

    public void setpCity(String pCity) {
        this.pCity = pCity;
    }

    public Integer getpBId() {
        return pBId;
    }

    public void setpBId(Integer pBId) {
        this.pBId = pBId;
    }

    public String getpHousehold() {
        return pHousehold;
    }

    public void setpHousehold(String pHousehold) {
        this.pHousehold = pHousehold;
    }

    public String getpUnit() {
        return pUnit;
    }

    public void setpUnit(String pUnit) {
        this.pUnit = pUnit;
    }

    public String getpFloor() {
        return pFloor;
    }

    public void setpFloor(String pFloor) {
        this.pFloor = pFloor;
    }

    public String getpDoorModel() {
        return pDoorModel;
    }

    public void setpDoorModel(String pDoorModel) {
        this.pDoorModel = pDoorModel;
    }

    public String getpBedroom() {
        return pBedroom;
    }

    public void setpBedroom(String pBedroom) {
        this.pBedroom = pBedroom;
    }

    public String getpWall() {
        return pWall;
    }

    public void setpWall(String pWall) {
        this.pWall = pWall;
    }

    public String getpNote1() {
        return pNote1;
    }

    public void setpNote1(String pNote1) {
        this.pNote1 = pNote1;
    }

    public String getpNote2() {
        return pNote2;
    }

    public void setpNote2(String pNote2) {
        this.pNote2 = pNote2;
    }

    public String getpNote3() {
        return pNote3;
    }

    public void setpNote3(String pNote3) {
        this.pNote3 = pNote3;
    }

    public String getpPoints() {
        return pPoints;
    }

    public void setpPoints(String pPoints) {
        this.pPoints = pPoints;
    }

    public String getpMeasurement() {
        return pMeasurement;
    }

    public void setpMeasurement(String pMeasurement) {
        this.pMeasurement = pMeasurement;
    }

    public String getpLable() {
        return pLable;
    }

    public void setpLable(String pLable) {
        this.pLable = pLable;
    }

    public String getpPhoto() {
        return pPhoto;
    }

    public void setpPhoto(String pPhoto) {
        this.pPhoto = pPhoto;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public Date getpTime() {
        return pTime;
    }

    public void setpTime(Date pTime) {
        this.pTime = pTime;
    }
}
