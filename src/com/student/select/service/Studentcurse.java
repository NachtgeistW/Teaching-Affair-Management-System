package com.student.select.service;

public class Studentcurse {
	private String sstudentId;
	private String cId;
	private String sGrade;
	private String sTerm;
	private String cName;
	private String cKind;
	private String cTestway;
	private int    cCredit;
	private int    cStudentperiod;
	private String comment;
	private String cTname;
	public Studentcurse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Studentcurse(String sstudentId, String cId, String sGrade, String sTerm, String cName, String cKind,
			String cTestway, int cCredit, int cStudentperiod, String comment,String cTname) {
		super();
		this.sstudentId = sstudentId;
		this.cId = cId;
		this.sGrade = sGrade;
		this.sTerm = sTerm;
		this.cName = cName;
		this.cKind = cKind;
		this.cTestway = cTestway;
		this.cCredit = cCredit;
		this.cStudentperiod = cStudentperiod;
		this.comment = comment;
		this.cTname = cTname;
	}

	public String getSstudentId() {
		return sstudentId;
	}

	public void setSstudentId(String sstudentId) {
		this.sstudentId = sstudentId;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getsGrade() {
		return sGrade;
	}

	public void setsGrade(String sGrade) {
		this.sGrade = sGrade;
	}

	public String getsTerm() {
		return sTerm;
	}

	public void setsTerm(String sTerm) {
		this.sTerm = sTerm;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcKind() {
		return cKind;
	}

	public void setcKind(String cKind) {
		this.cKind = cKind;
	}

	public String getcTestway() {
		return cTestway;
	}

	public void setcTestway(String cTestway) {
		this.cTestway = cTestway;
	}

	public int getcCredit() {
		return cCredit;
	}

	public void setcCredit(int cCredit) {
		this.cCredit = cCredit;
	}

	public int getcStudentperiod() {
		return cStudentperiod;
	}

	public void setcStudentperiod(int cStudentperiod) {
		this.cStudentperiod = cStudentperiod;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getcTname() {
		return cTname;
	}

	public void setcTname(String cTname) {
		this.cTname = cTname;
	}
	
}
