package com.test;

public class TeacherQuery {
    private String cid;
    private String cname;
    private String cterm;
    private double avg;
    private int count;

    public TeacherQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

    public TeacherQuery(String cid, String cname, String cterm, int count) {
        this.cid = cid;
        this.cname = cname;
        this.cterm = cterm;
        this.count = count;
    }

    public TeacherQuery(String cid, String cname, double avg, int count) {
        this.cid = cid;
        this.cname = cname;
        this.avg = avg;
        this.count = count;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCterm() {
        return cterm;
    }

    public void setCterm(String cterm) {
        this.cterm = cterm;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
}
