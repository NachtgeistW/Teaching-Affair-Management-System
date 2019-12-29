package com.test;

public class StatisticProvince {
    private String department;
    private int count;
    private int anHui;
    private int fuJian;
    private int guangDong;
    private int huBei;
    private int huNan;
    private int jiangXi;
    private int chongQing;

    public StatisticProvince(String department, int count, int anHui, int fuJian, int guangDong, int huBei, int huNan, int jiangXi, int chongQing) {
        this.department = department;
        this.count = count;
        this.anHui = anHui;
        this.fuJian = fuJian;
        this.guangDong = guangDong;
        this.huBei = huBei;
        this.huNan = huNan;
        this.jiangXi = jiangXi;
        this.chongQing = chongQing;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAnHui() {
        return anHui;
    }

    public void setAnHui(int anHui) {
        this.anHui = anHui;
    }

    public int getFuJian() {
        return fuJian;
    }

    public void setFuJian(int fuJian) {
        this.fuJian = fuJian;
    }

    public int getGuangDong() {
        return guangDong;
    }

    public void setGuangDong(int guangDong) {
        this.guangDong = guangDong;
    }

    public int getHuBei() {
        return huBei;
    }

    public void setHuBei(int huBei) {
        this.huBei = huBei;
    }

    public int getHuNan() {
        return huNan;
    }

    public void setHuNan(int huNan) {
        this.huNan = huNan;
    }

    public int getJiangXi() {
        return jiangXi;
    }

    public void setJiangXi(int jiangXi) {
        this.jiangXi = jiangXi;
    }

    public int getChongQing() {
        return chongQing;
    }

    public void setChongQing(int chongQing) {
        this.chongQing = chongQing;
    }
}
