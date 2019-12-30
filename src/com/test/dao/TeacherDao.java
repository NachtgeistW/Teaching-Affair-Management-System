package com.test.dao;

import com.test.Teacher;
import com.test.TeacherQuery;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDao extends Dao {
    //���ѧ����Ϣ
    int addTeacher(Teacher teacher) throws SQLException;

    //����ѧ����Ϣ
    int updateTeacher(Teacher teacher) throws SQLException;

    //��ѧ��ɾ��ѧ��
    int deleteTeacher(String teacherId) throws SQLException;

    List<Teacher> queryAllTeacher(int cpage, int count) throws SQLException;

    //查询授课信息
    List<TeacherQuery> queryCourseList(String tteacherid, int cpage, int count) throws SQLException;

    //查询课程平均成绩和不及格人数
    List<TeacherQuery> queryCourseAvgGrade(String teacherList, int cpage, int count) throws SQLException;
}
