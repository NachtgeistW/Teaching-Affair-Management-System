package com.test.dao;

import com.test.Teacher;
import com.test.TeacherQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    @Override
    public int addTeacher(Teacher teacher) throws SQLException {
        String sql = "INSERT INTO teacher_info values (?, ?, ?, ?, ?)";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, teacher.getName());
            pstmt.setString(2, teacher.getSex());
            pstmt.setString(3, teacher.getTeacherId());
            pstmt.setString(4, teacher.getTitle());
            pstmt.setInt(5, teacher.getDepartmentId());
            int i = pstmt.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateTeacher(Teacher teacher) throws SQLException {
        int i = deleteTeacher(teacher.getTeacherId());
        addTeacher(teacher);
        return i;
    }

    @Override
    public int deleteTeacher(String teacherId) throws SQLException {
        String sql_delete = "DELETE FROM teacher_info WHERE tteacherid = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql_delete);
            pstmt.setString(1, teacherId);
            int i = pstmt.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Teacher> queryAllTeacher(int cpage,int count) throws SQLException {
        List<Teacher> list = new ArrayList<>();
        Teacher teacher;
        String sql = "select tname, tsex, tteacherid, ttitle, dname\n" +
                "from teacher_info,\n" +
                "     department_info\n" +
                "where teacher_info.did = department_info.did limit ?,?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, (cpage-1)*count);
        pstmt.setInt(2, count);
        ResultSet res = pstmt.executeQuery();
        //从结果集里拿数据
        while (res.next()) {
            teacher = new Teacher(res.getString("tname"), res.getString("tsex"),
                    res.getString("tteacherid"), res.getString("ttitle"),
                    res.getString("dname"));
            list.add(teacher);
        }
        return list;
    }

    //查询授课信息
    @Override
    public List<TeacherQuery> queryCourseList(String teacherId,int cpage,int count) throws SQLException {
        List<TeacherQuery> list = new ArrayList<>();
        TeacherQuery teacherQuery;
        String sql = "select teacher_course.cid, cname, cterm, count\n" + 
        		"from teacher_info, course_info, teacher_course\n" + 
        		"         left join (select cid, count(*) as count\n" + 
        		"                    from student_course\n" + 
        		"                    group by cid) as sc on teacher_course.cid = sc.cid\n" + 
        		"where course_info.cid = teacher_course.cid and teacher_course.tteacherid = '"+ teacherId +"'\n" + 
        		"group by cname limit ?,?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, (cpage-1)*count);
        pstmt.setInt(2, count);
        ResultSet res = pstmt.executeQuery();
        while (res.next()) {
            teacherQuery = new TeacherQuery(res.getString("cid"),
                    res.getString("cname"),
                    res.getString("cterm"),
                    res.getInt("count"));
            list.add(teacherQuery);
        }
        return list;
    }

    //查询课程平均成绩和不及格人数
    @Override
    public List<TeacherQuery> queryCourseAvgGrade(String teacherList,int cpage,int count) throws SQLException{
        List<TeacherQuery> list = new ArrayList<>();
        TeacherQuery teacherQuery;
        String sql = "select teacher_course.cid as cid, course_info.cname, avg(sgrade) as avg, count(student_course.sgrade < 60 or null) as count\n" +
                "from teacher_course, student_course, course_info\n" +
                "where course_info.cid = teacher_course.cid and student_course.cid = teacher_course.cid\n" +
                "and teacher_course.tteacherid = '" + teacherList + "'\n" +
                "group by teacher_course.cid limit ?,?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, (cpage-1)*count);
        pstmt.setInt(2, count);
        ResultSet res = pstmt.executeQuery();
        while (res.next()) {
            teacherQuery = new TeacherQuery(res.getString("cid"),
                    res.getString("cname"),
                    res.getDouble("avg"),
                    res.getInt("count"));
            list.add(teacherQuery);
        }
        return list;
    }
    public  int[] totalpage(int count,int num,String id) throws SQLException {
    	//0记录数，1页数；
    	int arr[] = {0,1};
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	if(num==1) {
    		String sql = "select count(*) from teacher_info";
    		pstmt = conn.prepareStatement(sql);
    	}
    	if(num==2) {
    		String sql = "select COUNT(teacher_course.tteacherid) from teacher_course where teacher_course.tteacherid = ?";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, id);
    	}
        if(num==3) {
        	String sql = "select count(DISTINCT teacher_course.cid) from teacher_course,student_course where  teacher_course.tteacherid = ? and teacher_course.cid = student_course.cid and teacher_course.tteacherid = student_course.tteacherid";
        	pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, id);
        }
        
        ResultSet res = pstmt.executeQuery();
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
