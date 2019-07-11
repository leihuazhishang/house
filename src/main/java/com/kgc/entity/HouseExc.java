package com.kgc.entity;

public class HouseExc extends House {

    private String tName;
    private String sName;
    private String dName;
    private Integer dId;
     private String uName;




    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Override
    public String toString() {
        return "HouseExc{" +
                "tName='" + tName + '\'' +
                ", sName='" + sName + '\'' +
                ", dName='" + dName + '\'' +
                ", dId=" + dId +
                '}';
    }
}
