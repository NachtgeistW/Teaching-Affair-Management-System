package com.student.select.service;

public class Student {
    private String studentId;
    private String studentName;
    private String studentWhere;
    private String studentSex;
    private String sId;
    private String studentBirth;
    private int studentDid;
    private String studentSpolitics;

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Student(String studentId, String studentName, String studentWhere, String studentSex, String sId,
                   String studentBirth, int studentDid, String studentSpolitics) {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentWhere = studentWhere;
        this.studentSex = studentSex;
        this.sId = sId;
        this.studentBirth = studentBirth;
        this.studentDid = studentDid;
        this.studentSpolitics = studentSpolitics;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentWhere() {
        return studentWhere;
    }

    public void setStudentWhere(String studentWhere) {
        this.studentWhere = studentWhere;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getStudentBirth() {
        return studentBirth;
    }

    public void setStudentBirth(String studentBirth) {
        this.studentBirth = studentBirth;
    }

    public int getStudentDid() {
        return studentDid;
    }

    public void setStudentDid(int studentDid) {
        this.studentDid = studentDid;
    }

    public String getStudentSpolitics() {
        return studentSpolitics;
    }

    public void setStudentSpolitics(String studentSpolitics) {
        this.studentSpolitics = studentSpolitics;
    }


}
