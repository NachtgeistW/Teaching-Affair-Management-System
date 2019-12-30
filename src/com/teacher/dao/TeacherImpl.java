package com.teacher.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.maike.util.ConnectionUtil;
import com.student.select.service.Studentcurse;
import com.teacher.model.Teacher;
import com.test.TeacherQuery;

public class TeacherImpl implements TeacherDao {
    Connection con = null;
    PreparedStatement pt = null;
    ResultSet rs = null;
    String sql;

    @Override
    public Teacher selectTeacherDid(String tteacherid) {
        sql = "select * from teacher_info where tteacherid = ?";
        Teacher tea = new Teacher();
        try {
            con = ConnectionUtil.getConnection();
            pt = con.prepareStatement(sql);
            pt.setString(1, tteacherid);
            rs = pt.executeQuery();
            while (rs.next()) {
                tea.setTname(rs.getString("tname"));
                tea.setTteacherid(rs.getString("tteacherid"));
                tea.setDid(rs.getInt("did"));
                tea.setTtitle(rs.getString("ttitle"));
                tea.setTsex(rs.getString("tsex"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeRe(con, pt, rs);
        }
        return tea;
    }

    @Override
    public int teacherUpdate(Teacher teacher) {
        int a = 0;
        sql = "UPDATE teacher_info SET tname=?,tsex=?,ttitle=?,did=? where tteacherid=?";
        try {
            con = ConnectionUtil.getConnection();
            pt = con.prepareStatement(sql);
            pt.setString(1, teacher.getTname());
            pt.setString(2, teacher.getTsex());
            pt.setString(3, teacher.getTtitle());
            pt.setInt(4, teacher.getDid());
            pt.setString(5, teacher.getTteacherid());
            a = pt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeRe(con, pt, rs);
        }
        return a;
    }

    @Override
    public int teacherCurseDelete(String cid, String cterm, String tid) {
        int a = 0;
        sql = "delete from student_course where sterm=? and cid=? and tteacherid = ?";
        try {
            con = ConnectionUtil.getConnection();
            pt = con.prepareStatement(sql);
            pt.setString(2, cid);
            pt.setString(1, cterm);
            pt.setString(3, tid);
            a = pt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeRe(con, pt, rs);
        }
        sql = "delete from teacher_course where cterm=? and cid=? and tteacherid = ?";
        try {
            con = ConnectionUtil.getConnection();
            pt = con.prepareStatement(sql);
            pt.setString(2, cid);
            pt.setString(1, cterm);
            pt.setString(3, tid);
            a = pt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeRe(con, pt, rs);
        }
        return a;
    }

    @Override
    public TeacherQuery getCurse(String cid, String sid) {
        TeacherQuery curse = new TeacherQuery();
        sql = "select * from student_course,course_info,teacher_info,teacher_course where teacher_course.tteacherid = ? and student_course.cid=? and student_course.cid=course_info.cid AND course_info.cid = teacher_course.cid and teacher_course.tteacherid = teacher_info.tteacherid and student_course.sterm=teacher_course.cterm";
        try {
            con = ConnectionUtil.getConnection();
            pt = con.prepareStatement(sql);
            pt.setString(1, sid);
            pt.setString(2, cid);
            rs = pt.executeQuery();
            while (rs.next()) {
                curse.setCid(cid);
                curse.setCname(rs.getString("cname"));
                curse.setCterm(rs.getString("cterm"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeRe(con, pt, rs);
        }
        return curse;
    }

    @Override
    public int teacherCurseUpdate(TeacherQuery curse) {
        int a = 0;
        sql = "UPDATE student_course,teacher_course SET student_course.sterm=?,teacher_course.cterm=? where teacher_course.cid=? and student_course.cid=teacher_course.cid and student_course.sterm=teacher_course.cterm";
        try {
            con = ConnectionUtil.getConnection();
            pt = con.prepareStatement(sql);
            pt.setString(1, curse.getCterm());
            pt.setString(2, curse.getCterm());
            pt.setString(3, curse.getCid());
            a = pt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeRe(con, pt);
        }
        return a;
    }

    @Override
    public ArrayList<TeacherQuery> getCurseIdList(String id) {
        ArrayList<TeacherQuery> list = new ArrayList<TeacherQuery>();
        sql = "SELECT course_info.cname,course_info.cid\r\n" +
                "FROM course_info\r\n" +
                "WHERE NOT EXISTS\r\n" +
                "    (SELECT teacher_course.cid\r\n" +
                "    FROM teacher_course\r\n" +
                "    WHERE course_info.cid = teacher_course.cid)\r\n" +
                "  and course_info.tteacherid = ?;";
        try {
            con = ConnectionUtil.getConnection();
            pt = con.prepareStatement(sql);
            pt.setString(1, id);
            rs = pt.executeQuery();
            while (rs.next()) {
                TeacherQuery curse = new TeacherQuery();
                curse.setCid(rs.getString("cid"));
                curse.setCname(rs.getString("cname"));
                list.add(curse);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeRe(con, pt, rs);
        }
        return list;
    }

    @Override
    public int teacherCurseAdd(TeacherQuery curse, String tteacherid) {
        int a = 0;
        String s = "";
        sql = "insert into teacher_course (tteacherid,cid,cterm) values(?,?,?)";
        try {
            con = ConnectionUtil.getConnection();
            pt = con.prepareStatement(sql);
            pt.setString(1, tteacherid);
            pt.setString(2, curse.getCid());
            pt.setString(3, curse.getCterm());
            a = pt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeRe(con, pt, rs);
        }
        return a;
    }

}
