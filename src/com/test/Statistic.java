package com.test;

public class Statistic {
    private int count;//通用，计数
    private String province;//省份
    private String department;
    private String sex;
    private int grade;
    private String studentId;
    private String studentName;
    private String courseName;
    private double avgGrade;

    public Statistic(String province, int count) {
        this.province = province;
        this.count = count;
    }

    public Statistic(String dname, String ssex, int anInt) {
        this.department = dname;
        this.sex = ssex;
        this.count = anInt;
    }

    public Statistic(String dname, String sstudentid, String sname, String cname, int sgrade) {
        this.department = dname;
        this.studentId = sstudentid;
        this.studentName = sname;
        this.courseName = cname;
        this.grade = sgrade;
    }

    public Statistic(String dname, String cname, double avg) {
        this.department = dname;
        this.courseName = cname;
        this.avgGrade = avg;
    }

    public Statistic(int count, String cname, double avg) {
        this.count = count;
        this.courseName = cname;
        this.avgGrade = avg;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
}
