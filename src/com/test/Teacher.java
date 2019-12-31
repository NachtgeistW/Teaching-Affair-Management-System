package com.test;

public class Teacher {
    private String name;
    private String sex;
    private String teacherId;
    private String title;
    private String department;
    private int departmentId;
    Teacher(){}
    public Teacher(String name, String sex, String teacherId, String title, String department){
        this.name = name;
        this.sex = sex;
        this.teacherId = teacherId;
        this.title = title;
        this.department = department;
    }

    public Teacher(String name, String sex, String teacherId, String title, int departmentId){
        this.name = name;
        this.sex = sex;
        this.teacherId = teacherId;
        this.title = title;
        this.departmentId = departmentId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
