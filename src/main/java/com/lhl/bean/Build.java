package com.lhl.bean;

import java.sql.Date;
/**
 * 楼盘信息实体类
 */
public class Build {
    private int id; //楼盘id
    private String buildname;// 楼盘名称
    private String dvpcompany;//开发企业
    private String province;    //省份
    private String city;    //城市
    private String area;    //区域
    private String designcompany;   //设计公司
    private String sightcompany;    //景观公司
    private String pmcompany;   //物业公司
    private String sg;  //施工单位
    private String ischoice;    //是否严选
    private String delivery;    //交付状态
    private String periods; //期数
    private String buildingnm;  //楼幢数
    private String taskstatus;  //任务状态
    private Date buildtime;   //楼盘创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuildname() {
        return buildname;
    }

    public void setBuildname(String buildname) {
        this.buildname = buildname;
    }

    public String getDvpcompany() {
        return dvpcompany;
    }

    public void setDvpcompany(String dvpcompany) {
        this.dvpcompany = dvpcompany;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDesigncompany() {
        return designcompany;
    }

    public void setDesigncompany(String designcompany) {
        this.designcompany = designcompany;
    }

    public String getSightcompany() {
        return sightcompany;
    }

    public void setSightcompany(String sightcompany) {
        this.sightcompany = sightcompany;
    }

    public String getPmcompany() {
        return pmcompany;
    }

    public void setPmcompany(String pmcompany) {
        this.pmcompany = pmcompany;
    }

    public String getSg() {
        return sg;
    }

    public void setSg(String sg) {
        this.sg = sg;
    }

    public String getIschoice() {
        return ischoice;
    }

    public void setIschoice(String ischoice) {
        this.ischoice = ischoice;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    public String getBuildingnm() {
        return buildingnm;
    }

    public void setBuildingnm(String buildingnm) {
        this.buildingnm = buildingnm;
    }

    public String getTaskstatus() {
        return taskstatus;
    }

    public void setTaskstatus(String taskstatus) {
        this.taskstatus = taskstatus;
    }

    public Date getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Date buildtime) {
        this.buildtime = buildtime;
    }


}

