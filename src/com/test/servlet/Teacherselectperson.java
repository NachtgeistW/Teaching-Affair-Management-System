package com.test.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teacher.dao.TeacherDao;
import com.teacher.dao.TeacherImpl;
import com.teacher.model.Teacher;

/**
 * Servlet implementation class Teacherselectperson
 */
@WebServlet("/Teacherselectperson")
public class Teacherselectperson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacherselectperson() {
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
		Teacher teacher = new Teacher();
		TeacherDao dao = new TeacherImpl();
		String id = (String)this.getServletContext().getAttribute("id");
		if(id == null)id = request.getParameter("tid");
		teacher = dao.selectTeacherDid(id);
		request.setAttribute("tname",teacher.getTname());
		request.setAttribute("tid",teacher.getTteacherid());
		request.setAttribute("did", teacher.getDid());
		request.setAttribute("title", teacher.getTtitle());
		request.setAttribute("sex", teacher.getTsex());
		
		request.getRequestDispatcher("form-tea-select.jsp").forward(request, response);
	}
}
