package com.test;

import java.sql.Date;

public class Student {
    private String name;
    private String studentId;
    private int departmentId;
    private String id;
    private Date birth;
    private String where;
    private String politics;
    private String sex;
    private String department;

    Student() {
    }

    public Student(String name, String where, String sex, String studentId, String id, String politics, int departmentId, Date birth) {
        this.name = name;
        this.where = where;
        this.sex = sex;
        this.studentId = studentId;
        this.id = id;
        this.politics = politics;
        this.departmentId = departmentId;
        this.birth = birth;
    }

    public Student(String name, String where, String sex, String studentId, String id, String politics, String department, Date birth) {
        this.name = name;
        this.where = where;
        this.sex = sex;
        this.studentId = studentId;
        this.id = id;
        this.politics = politics;
        this.department = department;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
