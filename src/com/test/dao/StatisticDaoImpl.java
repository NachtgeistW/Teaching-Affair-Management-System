package com.test.dao;

import com.test.Statistic;
import com.test.StatisticProvince;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatisticDaoImpl implements StatisticDao {
    //获取生源地人数统计
    @Override
    public List<Statistic> StatisticWhere(int cpage, int count) throws SQLException {
        List<Statistic> list = new ArrayList<>();
        Statistic statistic;
        String sql = "SELECT swhere, COUNT(swhere) FROM `student_info` GROUP BY swhere limit ?,?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, (cpage - 1) * count);
        pstmt.setInt(2, count);
        ResultSet res = pstmt.executeQuery();
        //从结果集里拿数据
        while (res.next()) {
            statistic = new Statistic(res.getString("swhere"),
                    res.getInt("COUNT(swhere)"));
            list.add(statistic);
        }
        return list;
    }

    //获取各院系性别统计
    @Override
    public List<Statistic> StatisticDepartmentSex(int cpage, int count) throws SQLException {
        List<Statistic> list = new ArrayList<>();
        Statistic statistic;
        String sql = "SELECT dname, `student_info`.ssex, COUNT(ssex) \n" +
                "FROM `department_info`, `student_info`\n" +
                "WHERE `department_info`.did = `student_info`.did\n" +
                "GROUP BY dname limit ?,?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, (cpage - 1) * count);
        pstmt.setInt(2, count);
        ResultSet res = pstmt.executeQuery();
        while (res.next()) {
            statistic = new Statistic(res.getString("dname"), res.getString("ssex"),
                    res.getInt("COUNT(ssex)"));
            list.add(statistic);
        }
        return list;
    }

    //获取各院系不及格名单
    @Override
    public List<Statistic> StatisticDepartmentNoPassList(int cpage, int count) throws SQLException {
        List<Statistic> list = new ArrayList<>();
        Statistic statistic;
        String sql = "select dname, student_course.sstudentid, sname, student_course.cname, sgrade\n" +
                "from department_info, student_course, course_info, student_info\n" +
                "where department_info.did = student_info.did and course_info.cid = student_course.cid \n" +
                "and student_info.sstudentid = student_course.sstudentid and sgrade < 60 \n" +
                "order by dname limit ?,?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, (cpage - 1) * count);
        pstmt.setInt(2, count);
        ResultSet res = pstmt.executeQuery();
        while (res.next()) {
            statistic = new Statistic(res.getString("dname"), res.getString("sstudentid"),
                    res.getString("sname"), res.getString("cname"),
                    res.getInt("sgrade"));
            list.add(statistic);
        }
        return list;
    }

    //获取各院系各科的均分
    @Override
    public List<Statistic> StatisticDepartmentAvgGrade(int cpage, int count) throws SQLException {
        List<Statistic> list = new ArrayList<>();
        Statistic statistic;
        String sql = "SELECT dname, course_info.cname, avg(sgrade) " +
                "FROM department_info, student_info, course_info, student_course " +
                "WHERE `department_info`.did = `student_info`.did and student_info.sstudentid = student_course.sstudentid " +
                "and student_course.cid = course_info.cid " +
                "group by cname, dname order by dname limit ?,?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, (cpage - 1) * count);
        pstmt.setInt(2, count);
        ResultSet res = pstmt.executeQuery();
        while (res.next()) {
            statistic = new Statistic(res.getString("dname"),
                    res.getString("cname"), res.getDouble("avg(sgrade)"));
            list.add(statistic);
        }
        return list;
    }

    //获取各性别的各科目的均分
    @Override
    public List<Statistic> StatisticSexAvgGrade(String sex, int cpage, int count) throws SQLException {
        List<Statistic> list = new ArrayList<>();
        Statistic statistic;
        String sql = "select count(ssex), course_info.cname, avg(sgrade)\n" +
                "from course_info, student_course, student_info\n" +
                "where ssex = '" + sex + "' and student_info.sstudentid = student_course.sstudentid\n" +
                "and student_course.cid = course_info.cid\n" +
                "group by cname limit ?,?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, (cpage - 1) * count);
        pstmt.setInt(2, count);
        ResultSet res = pstmt.executeQuery();
        while (res.next()) {
            statistic = new Statistic(res.getInt("count(ssex)"),
                    res.getString("cname"), res.getDouble("avg(sgrade)"));
            list.add(statistic);
        }
        return list;
    }

    //获取各院系的地域详情
    @Override
    public List<StatisticProvince> StatisticDepartmentWhere(int cpage, int count) throws SQLException {
        List<StatisticProvince> list = new ArrayList<>();
        StatisticProvince statistic;
        String sql = "select dname, count(student_info.did) as info, count(swhere='安徽' or null) as anhui,\n" +
                "       count(swhere='福建' or null) as fujian, count(swhere='广东' or null) as guangdong,\n" +
                "       count(swhere='湖北' or null) as hubei, count(swhere='湖南' or null) as hunan,\n" +
                "       count(swhere='江西' or null) as jiangxi, count(swhere='重庆' or null) as chongqing\n" +
                "from department_info, student_info\n" +
                "where department_info.did = student_info.did\n" +
                "group by department_info.dname limit ?,?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, (cpage - 1) * count);
        pstmt.setInt(2, count);
        ResultSet res = pstmt.executeQuery();
        while (res.next()) {
            statistic = new StatisticProvince(res.getString("dname"),
                    res.getInt("info"),
                    res.getInt("anhui"),
                    res.getInt("fujian"),
                    res.getInt("guangdong"),
                    res.getInt("hubei"),
                    res.getInt("hunan"),
                    res.getInt("jiangxi"),
                    res.getInt("chongqing"));
            list.add(statistic);
        }
        return list;
    }

    public int[] totalpage(int count, int num) throws SQLException {
        //0记录数，1页数；
        int arr[] = {0, 1};
        String sql = null;
        if (num == 1) {
            sql = "SELECT count(DISTINCT swhere) FROM `student_info`";
        }
        if (num == 2) {
            sql = "select  COUNT(DISTINCT dname) from department_info, student_info where department_info.did = student_info.did";
        }
        if (num == 3) {
            sql = "select  COUNT(DISTINCT dname) from department_info, student_info where department_info.did = student_info.did";
        }
        if (num == 4) {
            sql = "SELECT COUNT(dname) FROM department_info, student_info, course_info, student_course WHERE `department_info`.did = `student_info`.did and student_info.sstudentid = student_course.sstudentid and student_course.cid = course_info.cid group by course_info.cname, dname order by dname";
        }
        if (num == 5) {
            sql = "select count(student_course.sstudentid) from department_info, student_course, course_info, student_info where department_info.did = student_info.did and course_info.cid = student_course.cid and student_info.sstudentid = student_course.sstudentid and sgrade < 60 order by dname";
        }
        if (num == 6) {
            sql = "select count(*) from course_info";
        }

        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet res = pstmt.executeQuery();
        while (res.next()) {

            arr[0] = res.getInt(1);
            if (arr[0] % count == 0)
                arr[1] = arr[0] / count;
            else
                arr[1] = arr[0] / count + 1;
        }
        conn.close();
        return arr;
    }
}
