package com.test;

public class Course {
    private String name;
    private String id;
    private String kind;
    private String testWay;
    private int credit;         //学分
    private int studyPeriod;    //学时
    private String comment;
    public Course(){};
    public Course(String name, String id, String kind, String testWay, int credit, int studyPeriod, String comment){
        this.name = name;
        this.id = id;
        this.kind = kind;
        this.testWay = testWay;
        this.credit = credit;
        this.studyPeriod = studyPeriod;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTestWay() {
        return testWay;
    }

    public void setTestWay(String testWay) {
        this.testWay = testWay;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getStudyPeriod() {
        return studyPeriod;
    }

    public void setStudyPeriod(int studyPeriod) {
        this.studyPeriod = studyPeriod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
