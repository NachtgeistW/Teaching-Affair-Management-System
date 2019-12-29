package com.test.dao;

import com.test.Statistic;
import com.test.StatisticProvince;

import java.sql.SQLException;
import java.util.List;

public interface StatisticDao extends Dao {

    //获取生源地人数统计
    List<Statistic>StatisticWhere() throws SQLException;

    //获取各院系性别统计
    List<Statistic> StatisticDepartmentSex() throws SQLException;

    //获取各院系不及格名单
    List<Statistic>StatisticDepartmentNoPassList() throws SQLException;

    //获取各院系各科的均分
    List<Statistic>StatisticDepartmentAvgGrade() throws SQLException;

    //获取各性别的各科目的均分
    List<Statistic>StatisticSexAvgGrade(String sex) throws SQLException;

    //获取各院系的地域详情
    List<StatisticProvince>StatisticDepartmentWhere() throws SQLException;
}
