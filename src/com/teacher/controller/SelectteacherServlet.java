package com.teacher.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teacher.dao.TeacherDao;
import com.teacher.dao.TeacherImpl;
import com.teacher.model.Teacher;

@WebServlet("/SelectteacherServlet")
public class SelectteacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SelectteacherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Teacher tea=new Teacher();
		TeacherDao teaDao=new TeacherImpl();
		String id = (String)this.getServletContext().getAttribute("123");
		tea = teaDao.selectTeacherDid(id);
		request.setAttribute("name", tea.getTname());
		request.setAttribute("id", tea.getTteacherid());
		request.setAttribute("did", tea.getDid());
		request.setAttribute("title", tea.getTtitle());
		request.setAttribute("sex", tea.getTsex());
		request.getRequestDispatcher("form-tea-select.jsp").forward(request, response);
	}

}
