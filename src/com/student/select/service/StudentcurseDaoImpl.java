package com.student.select.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.maike.util.ConnectionUtil;

public class StudentcurseDaoImpl implements StudentcurseDao {
	Connection con = null;
    PreparedStatement pt = null;
    ResultSet rs = null;
    String sql;
	@Override
	public ArrayList<Studentcurse> setCurse(String studentId) {
		sql = "select * from student_course,course_info,teacher_info,teacher_course where sstudentid = ? and student_course.cid=course_info.cid AND course_info.cid = teacher_course.cid and teacher_course.tteacherid = teacher_info.tteacherid and student_course.sterm=teacher_course.cterm";
        ArrayList<Studentcurse> list = new ArrayList<Studentcurse>();
        try {
            con = ConnectionUtil.getConnection();
            pt = con.prepareStatement(sql);
            pt.setString(1, studentId);
            rs = pt.executeQuery();
            while(rs.next()) {
               Studentcurse curse = new Studentcurse();
               curse.setSstudentId(studentId);
               curse.setcId(rs.getString("cid"));
               curse.setsGrade(rs.getString("sgrade"));
               curse.setsTerm(rs.getString("sterm"));
               curse.setcName(rs.getString("cname"));
               curse.setcKind(rs.getString("ckind"));
               curse.setcTestway(rs.getString("ctestway"));
               curse.setcCredit(rs.getInt("ccredit"));
               curse.setcStudentperiod(rs.getInt("cstudyperiod"));
               curse.setComment(rs.getString("comment"));
               curse.setcTname(rs.getString("tname"));
               list.add(curse);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            ConnectionUtil.closeRe(con, pt, rs);
        }
		return list;
	}
	@Override
	public Studentcurse getCurse(String cid,String studentId) {
		Studentcurse curse = new Studentcurse();
		sql = "select * from student_course,course_info,teacher_info,teacher_course where sstudentid = ? and student_course.cid=? and student_course.cid=course_info.cid AND course_info.cid = teacher_course.cid and teacher_course.tteacherid = teacher_info.tteacherid and student_course.tteacherid=teacher_course.tteacherid";
		try {
            con = ConnectionUtil.getConnection();
            pt = con.prepareStatement(sql);
            pt.setString(1, studentId);
            pt.setString(2, cid);
            rs = pt.executeQuery();
            while(rs.next()) {
               curse.setSstudentId(studentId);
               curse.setcId(rs.getString("cid"));
               curse.setsGrade(rs.getString("sgrade"));
               curse.setsTerm(rs.getString("sterm"));
               curse.setcName(rs.getString("cname"));
               curse.setcKind(rs.getString("ckind"));
               curse.setcTestway(rs.getString("ctestway"));
               curse.setcCredit(rs.getInt("ccredit"));
               curse.setcStudentperiod(rs.getInt("cstudyperiod"));
               curse.setComment(rs.getString("comment"));
               curse.setcTname(rs.getString("tname"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            ConnectionUtil.closeRe(con, pt, rs);
        }
		return curse;
	}
	@Override
	public int updateCurse(Studentcurse curse) {
		int a = 0;
		 sql = "UPDATE student_course,teacher_course SET sterm=?,cterm=?,comment=? where student_course.cid=? and student_course.cid=teacher_course.cid and student_course.sterm=teacher_course.cterm";
	        try {
	            con = ConnectionUtil.getConnection();
	            pt = con.prepareStatement(sql);
	            pt.setString(1, curse.getsTerm());
	            pt.setString(2, curse.getsTerm());
	            pt.setString(3, curse.getComment());
	            pt.setString(4, curse.getcId());
	            a = pt.executeUpdate();
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally {
	            ConnectionUtil.closeRe(con, pt);
	        }
	        return a;
		
	}
	@Override
	public int addCurse(Studentcurse curse) {
		int a = 0;
		String s="";
		sql = "insert into student_course (sstudentid,cid,sterm,comment,cname) values(?,?,?,?,?)";
		 try {
	            con = ConnectionUtil.getConnection();
	            pt = con.prepareStatement(sql);
	            pt.setString(1, curse.getSstudentId());
	            pt.setString(3, curse.getsTerm());
	            pt.setString(4, curse.getComment());
	            pt.setString(2, curse.getcId());
	            pt.setString(5, curse.getcName());
                System.out.println(curse.getcId()+curse.getcName()+curse.getcTname()+curse.getcTestway());
	            a = pt.executeUpdate();
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally {
	        	ConnectionUtil.closeRe(con, pt, rs);
	        }
	        return a;
	}
	@Override
    public ArrayList<Studentcurse> getCurseIdList(String id) {
        ArrayList<Studentcurse> list = new ArrayList<>();
        ArrayList<Studentcurse> s = new ArrayList<Studentcurse>();
        
        sql = "SELECT teacher_course.cid,teacher_course.cterm,teacher_course.tteacherid FROM teacher_course WHERE NOT EXISTS(SELECT student_course.cid FROM student_course WHERE teacher_course.cid = student_course.cid and teacher_course.tteacherid=student_course.tteacherid and student_course.sstudentid = ?)";
        try {
            con = ConnectionUtil.getConnection();
            pt = con.prepareStatement(sql);
            pt.setString(1, id);
            rs = pt.executeQuery();
            while (rs.next()) {
            	Studentcurse curse = new Studentcurse();
            	curse.setcId(rs.getString("cid"));
            	curse.setsTerm(rs.getString("cterm"));
            	curse.setcTname(rs.getString("tteacherid"));
                s.add(curse);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeRe(con, pt, rs);
        }
        for(int b = 0;b<s.size();b++) {
        	sql = "SELECT * FROM teacher_course,course_info,teacher_info WHERE teacher_course.cid = ? and teacher_course.tteacherid=? and teacher_course.cid = course_info.cid and teacher_course.tteacherid = teacher_info.tteacherid";
            try {
                con = ConnectionUtil.getConnection();
                pt = con.prepareStatement(sql);
                pt.setString(1, s.get(b).getcId());
                pt.setString(2, s.get(b).getcTname());
                rs = pt.executeQuery();
                while (rs.next()) {
                    Studentcurse curse1 = new Studentcurse();
                    curse1.setcId(rs.getString("cid"));
                    curse1.setcName(rs.getString("cname"));
                    curse1.setcTname(rs.getString("tname"));
                    curse1.setsTerm(rs.getString("cterm"));
                    curse1.setcTestway(rs.getString("ctestway"));
                    list.add(curse1);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                ConnectionUtil.closeRe(con, pt, rs);
            }
        }
        
        return list;
    }
	@Override
	public int deleteCurse(String cid,String sterm,String sid) {
		int a = 0;
		sql = "delete from student_course where sterm=? and cid=? and sstudentid=?";
		 try {
	            con = ConnectionUtil.getConnection();
	            pt = con.prepareStatement(sql);
	            pt.setString(3, sid);
	            pt.setString(2, cid);
	            pt.setString(1, sterm);
	            
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
