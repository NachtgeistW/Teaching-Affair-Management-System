package com.test.dao;

import com.PageInfo;
import com.test.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao extends Dao {
    //添加课程信息
    int addCourse(Course course) throws SQLException;
    //更新课程信息
    int updateCourse(Course course) throws SQLException;
    //按课程号删除课程
    int deleteCourse(String courseId) throws SQLException;

    List<Course> queryAllCourse() throws SQLException;

    Course queryByCid(String cid) throws SQLException;

    PageInfo queryByPage(int currentPage) throws SQLException;
}
