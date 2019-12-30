package com.teacher.dao;

import java.util.ArrayList;

import com.teacher.model.Teacher;
import com.test.TeacherQuery;

public interface TeacherDao {

    //   教师编号显示个人信息
    public Teacher selectTeacherDid(String tteacherid);

    public int teacherUpdate(Teacher teacher);

    public int teacherCurseDelete(String cid, String cterm, String tid);

    public TeacherQuery getCurse(String cid, String sid);

    public int teacherCurseUpdate(TeacherQuery curse);

    public ArrayList<TeacherQuery> getCurseIdList(String id);

    public int teacherCurseAdd(TeacherQuery curse, String tteacherid);
}
