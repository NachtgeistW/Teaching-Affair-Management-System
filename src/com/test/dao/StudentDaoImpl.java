package com.test.dao;

import com.test.Page;
import com.test.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public int addStudent(Student student) {
        String sql = "INSERT INTO student_info values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getWhere());
            pstmt.setString(3, student.getSex());
            pstmt.setString(4, student.getStudentId());
            pstmt.setString(5, student.getId());
            pstmt.setString(6, student.getPolitics());
            pstmt.setInt(7, student.getDepartmentId());
            pstmt.setBlob(8, (Blob) null);
            pstmt.setDate(9, student.getBirth());
            int i = pstmt.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateStudent(Student student) {
        int i = deleteStudent(student.getStudentId());
        addStudent(student);
        return i;
    }

    @Override
    public int deleteStudent(String studentId) {
        String sql_delete = "DELETE FROM student_info WHERE sstudentid = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql_delete);
            pstmt.setString(1, studentId);
            int i = pstmt.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Student querySingleStudent(String studentId) throws SQLException {
        Student student = null;
        String sql = "select * from student_info where sstudentid=?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, studentId);
        ResultSet res = pstmt.executeQuery(sql);
        try {
            if (res.next()) {
                student = new Student(res.getString("sname"), res.getString("swhere"),
                        res.getString("ssex"), res.getString("sstudentid"), res.getString("sid"),
                        res.getString("spolitics"), res.getInt("did"), res.getDate("sbirth"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> queryAllStudent(int cpage,int count) throws SQLException {
        List<Student> list = new ArrayList<>();
        Student student;
        String sql = "select sname, swhere, ssex, sstudentid, sid, spolitics, dname, sbirth\n" +
                "from student_info, department_info\n" +
                "where department_info.did = student_info.did limit ?,?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, (cpage-1)*count);
        pstmt.setInt(2, count);
        ResultSet res = pstmt.executeQuery();
        //从结果集里拿数据
        while (res.next()) {
            student = new Student(res.getString("sname"), res.getString("swhere"),
                    res.getString("ssex"), res.getString("sstudentid"), res.getString("sid"),
                    res.getString("spolitics"), res.getString("dname"), res.getDate("sbirth"));
            list.add(student);
        }
        return list;
    }
    
    public  int[] totalpage(int count) throws SQLException {
    	//0记录数，1页数；
    	int arr[] = {0,1};
    	String sql = "select count(*) from student_info";
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
