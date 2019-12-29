package com.test.dao;

import com.test.Page;
import com.test.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao extends Dao {
    //添加学生信息
    int addStudent(Student student) throws SQLException;

    //更新学生信息
    int updateStudent(Student student) throws SQLException;

    //按学号删除学生
    int deleteStudent(String studentId) throws SQLException;

    Student querySingleStudent(String userName) throws SQLException;

    List<Student> queryAllStudent() throws SQLException;
}
