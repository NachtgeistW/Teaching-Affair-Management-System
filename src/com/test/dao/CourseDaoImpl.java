package com.test.dao;

import com.PageInfo;
import com.test.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public int addCourse(Course course) throws SQLException {
        String sql = "INSERT INTO course_info values (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, course.getName());
            pstmt.setString(2, course.getId());
            pstmt.setString(3, course.getKind());
            pstmt.setString(4, course.getTestWay());
            pstmt.setInt(5, course.getCredit());
            pstmt.setInt(6, course.getStudyPeriod());
            pstmt.setString(7, course.getComment());
            int i = pstmt.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateCourse(Course course) throws SQLException {
        int i = deleteCourse(course.getId());
        addCourse(course);
        return i;
    }

    @Override
    public int deleteCourse(String courseId) throws SQLException {
        String sql_delete = "DELETE FROM course_info WHERE cid = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql_delete);
            pstmt.setString(1, courseId);
            int i = pstmt.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Course> queryAllCourse() throws SQLException {
        List<Course> list = new ArrayList<>();
        Course course;
        String sql = "select * from course_info";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet res = pstmt.executeQuery(sql);
        //从结果集里拿数据
        while (res.next()) {
            course = new Course(res.getString("cname"), res.getString("cid"),
                    res.getString("ckind"), res.getString("ctestway"),
                    res.getInt("ccredit"), res.getInt("cstudyperiod"),
                    res.getString("comment"));
            list.add(course);
        }
        return list;
    }

    @Override
    public Course queryByCid(String cid) throws SQLException {
        Course course = null;
        String sql = "select * from course_info where cid = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, cid);
        ResultSet res = pstmt.executeQuery();
        while (res.next()){
            course = new Course(res.getString("cname"), res.getString("cid"),
                    res.getString("ckind"), res.getString("ctestway"),
                    res.getInt("ccredit"), res.getInt("cstudyperiod"),
                    res.getString("comment"));
        }
        return course;
    }

    //自己写的。整合的时候记得换成卓林的
    @Override
    public PageInfo queryByPage(int currentPage) throws SQLException {
        List<Course> list = new ArrayList<>();
        Course course;
        String sql = "select * from course_info limit ?, ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, (currentPage - 1) * 4);
        pstmt.setInt(2, 4);
        ResultSet res = pstmt.executeQuery();
        //从结果集里拿数据
        while (res.next()) {
            course = new Course(res.getString("cname"), res.getString("cid"),
                    res.getString("ckind"), res.getString("ctestway"),
                    res.getInt("ccredit"), res.getInt("cstudyperiod"),
                    res.getString("comment"));
            list.add(course);
        }

        //查询总记录数
        String countSql = "select count(cid) as totalRecord from course_info";
        PreparedStatement pstmt2 = conn.prepareStatement(countSql);
        ResultSet res2 = pstmt2.executeQuery();
        long total = 0;
        if (res2.next()) {
            total = res2.getLong("totalRecord");
        }

        PageInfo pageInfo = new PageInfo(list, currentPage, total);
        return pageInfo;
    }
}
