package com.test.dao;

import com.maike.util.ConnectionUtil;
import com.test.Course;
import com.test.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public int addCourse(Course course) throws SQLException {
        String sql = "INSERT INTO course_info values (?, ?, ?, ?, ?, ?, ?,?)";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, course.getName());
            pstmt.setString(2, course.getId());
            pstmt.setString(3, course.getKind());
            pstmt.setString(4, course.getTestWay());
            pstmt.setInt(5, course.getCredit());
            pstmt.setInt(6, course.getStudyPeriod());
            pstmt.setString(7, course.getComment());
            pstmt.setString(8, course.getTteacherid());
            int i = pstmt.executeUpdate();
            conn.close();
            return i;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateCourse(Course course) throws SQLException {
    	String sql = "update course_info set cid=?,cname=?,ckind=?,ccredit=?,ctestway=?,comment=? where cid = ?";
        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, course.getId());
            pstmt.setString(2, course.getName());
            pstmt.setString(3, course.getKind());
            pstmt.setInt(4, course.getCredit());
            pstmt.setString(5, course.getTestWay());
            pstmt.setString(6, course.getComment());
            pstmt.setString(7, course.getId());
            int i = pstmt.executeUpdate();
            conn.close();
            return i;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteCourse(String courseId) throws SQLException {
        String sql_delete = "DELETE FROM course_info WHERE cid = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql_delete);
            pstmt.setString(1, courseId);
            int i = pstmt.executeUpdate();
            conn.close();
            return i;
        }catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    @Override
    public Course queryByCid(String cid) throws SQLException {
        Course course = null;
        String sql = "select * from course_info where cid = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, cid);
        ResultSet res = pstmt.executeQuery();
        while (res.next()) {
            course = new Course(res.getString("cname"), res.getString("cid"),
                    res.getString("ckind"), res.getString("ctestway"),
                    res.getInt("ccredit"), res.getInt("cstudyperiod"),
                    res.getString("comment"),res.getString("tteacherid"));
        }
        return course;
    }
    
    @Override
    public List<Course> queryAllCourse(int cpage,int count) throws SQLException {
        List<Course> list = new ArrayList<>();
        Course course;
        String sql = "select * from course_info limit ?,?";
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, (cpage-1)*count);
        pstmt.setInt(2, count);
        ResultSet res = pstmt.executeQuery();
        //从结果集里拿数据
        while (res.next()) {
            course = new Course(res.getString("cname"), res.getString("cid"),
                    res.getString("ckind"), res.getString("ctestway"),
                    res.getInt("ccredit"), res.getInt("cstudyperiod"),
                    res.getString("comment"),res.getString("tteacherid"));
            list.add(course);
        }
        conn.close();
        return list;
    }
    
    public  int[] totalpage(int count) throws SQLException {
    	//0记录数，1页数；
    	int arr[] = {0,1};
    	String sql = "select count(*) from course_info";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet res = pstmt.executeQuery(sql);
        while(res.next()) {
        	
        	arr[0] = res.getInt(1);
        	if(arr[0]%count==0)
        		arr[1] = arr[0]/count;
        	else
        		arr[1] = arr[0]/count+1;
        }
        conn.close();
    	return arr;
    }
}
