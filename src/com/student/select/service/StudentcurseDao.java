package com.student.select.service;

import java.util.ArrayList;

public interface StudentcurseDao {
	public ArrayList<Studentcurse> setCurse(String studentId);
	public Studentcurse getCurse(String cid,String studentId);
	public int updateCurse(Studentcurse curse);
	public int addCurse(Studentcurse curse);
	public ArrayList<Studentcurse> getCurseIdList(String id);
	public int deleteCurse(String cid,String sterm,String sid);
}
