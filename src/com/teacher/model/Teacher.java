package com.teacher.model;

public class Teacher {
    private String tname;
    private String tteacherid;
    private int did;
    private String ttitle;
    private String tsex;

    public Teacher() {
        super();
    }

    public Teacher(String tname, String tteacherid, int did, String ttitle, String tsex) {
        this.tname = tname;
        this.tteacherid = tteacherid;
        this.did = did;
        this.ttitle = ttitle;
        this.tsex = tsex;
    }


    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }


    public String getTteacherid() {
        return tteacherid;
    }

    public void setTteacherid(String tteacherid) {
        this.tteacherid = tteacherid;
    }

    public String getTtitle() {
        return ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }


}
