package com.student.misstion.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.select.service.Student;
import com.student.select.service.StudentDao;
import com.student.select.service.StudentDaoImpl;
import com.student.select.service.Studentcurse;
import com.student.select.service.StudentcurseDao;
import com.student.select.service.StudentcurseDaoImpl;

/**
 * Servlet implementation class Curseeiditshow
 */
@WebServlet("/Curseeiditshow")
public class Curseeiditshow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Curseeiditshow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = (String)this.getServletContext().getAttribute("id");
        if(id == null)id = request.getParameter("sid");
		Studentcurse curse = new Studentcurse();
		StudentcurseDao dao = new StudentcurseDaoImpl();
		String cid = request.getParameter("cid");
		curse = dao.getCurse(cid, id);
		request.setAttribute("cname",curse.getcName());
		request.setAttribute("cid",curse.getcId());
		request.setAttribute("ctname", curse.getcTname());
		request.setAttribute("sterm", curse.getsTerm());
		request.setAttribute("ctestway",curse.getcTestway());
		request.setAttribute("comment", curse.getComment());
		
		
		request.getRequestDispatcher("stu-misstion-write.jsp").forward(request, response);
	}

}
