package com.student.select.servlet;

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

/**
 * Servlet implementation class Selectcore
 */
@WebServlet("/Selectcore")
public class Selectcore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Selectcore() {
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
        StudentcurseDao cursedao = new StudentcurseDaoImpl();
        ArrayList<Studentcurse> list = new ArrayList<Studentcurse>();
        list = cursedao.setCurse(id);
        request.setAttribute("curselist", list);
        request.getRequestDispatcher("stu-misstion-score.jsp").forward(request, response);
	}

}
