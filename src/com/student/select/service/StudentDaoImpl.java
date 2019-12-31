package com.student.select.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.maike.util.ConnectionUtil;

public class StudentDaoImpl implements StudentDao {
	Connection con = null;
    PreparedStatement pt = null;
    ResultSet rs = null;
    String sql;
	@Override
	public Student setStudent(String studentId) {
		 sql = "select * from student_info where sstudentid = ?";
	        Student stu = new Student();
	        try {
	            con = ConnectionUtil.getConnection();
	            pt = con.prepareStatement(sql);
	            pt.setString(1, studentId);
	            rs = pt.executeQuery();
	            while(rs.next()) {
	            	stu.setStudentId(rs.getString("sstudentid"));
	            	stu.setStudentName(rs.getString("sname"));
	            	stu.setsId(rs.getString("sid"));
	            	stu.setStudentBirth(rs.getString("sbirth"));
	            	stu.setStudentDid(rs.getInt("did"));
	            	stu.setStudentWhere(rs.getString("swhere"));
	            	stu.setStudentSex(rs.getString("ssex"));
	            	stu.setStudentSpolitics(rs.getString("spolitics"));
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally {
	            ConnectionUtil.closeRe(con, pt, rs);
	        }
	        return stu;
	    }
	@Override
	public int updateStudent(Student student) {
		int a = 0;
			 sql = "UPDATE student_info SET sname=?,sid=?,sbirth=date_format(?,'%y-%m-%d'),swhere=?,spolitics=?,ssex=?,did=? where sstudentid=?";
		        try {
		            con = ConnectionUtil.getConnection();
		            pt = con.prepareStatement(sql);
		            pt.setString(1, student.getStudentName());
		            pt.setString(2, student.getsId());
		            pt.setString(3, student.getStudentBirth());
		            pt.setString(4, student.getStudentWhere());
		            pt.setString(5, student.getStudentSpolitics());
		            pt.setString(6, student.getStudentSex());
		            pt.setInt(7, student.getStudentDid());
		            pt.setString(8, student.getStudentId());
		            a = pt.executeUpdate();
		            
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }finally {
		            ConnectionUtil.closeRe(con, pt, rs);
		        }
		        return a;
	}
		

}
