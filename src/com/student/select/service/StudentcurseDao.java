package com.student.select.service;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentcurseDao {
    public ArrayList<Studentcurse> setCurse(String studentId, int cpage, int count);

    public Studentcurse getCurse(String cid, String studentId);

    public int updateCurse(Studentcurse curse);

    public int addCurse(Studentcurse curse);

    public ArrayList<Studentcurse> getCurseIdList(String id);

    public int deleteCurse(String cid, String sterm, String sid);

    public int[] getPage(int count, int num, String id) throws SQLException;
}
