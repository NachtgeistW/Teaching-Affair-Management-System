package com.test.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.select.service.Studentcurse;
import com.student.select.service.StudentcurseDao;
import com.student.select.service.StudentcurseDaoImpl;
import com.teacher.dao.TeacherDao;
import com.teacher.dao.TeacherImpl;
import com.test.TeacherQuery;

/**
 * Servlet implementation class Teacheraddcurse
 */
@WebServlet("/Teacheraddcurse")
public class Teacheraddcurse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacheraddcurse() {
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
        if(id == null)id = request.getParameter("tid");
        ArrayList<TeacherQuery> list = new ArrayList<TeacherQuery>();
        TeacherDao dao = new TeacherImpl();
        list = dao.getCurseIdList(id);
        request.setAttribute("curseidlist", list);
        request.getRequestDispatcher("tea-misstion-add.jsp").forward(request, response);
	}

}
