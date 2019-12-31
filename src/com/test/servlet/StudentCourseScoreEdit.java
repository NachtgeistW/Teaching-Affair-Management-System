package com.test.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.select.service.Student;
import com.student.select.service.StudentDao;
import com.student.select.service.StudentDaoImpl;
import com.test.dao.CourseDao;
import com.test.dao.CourseDaoImpl;

/**
 * Servlet implementation class StudentCourseScoreEdit
 */
@WebServlet("/StudentCourseScoreEdit")
public class StudentCourseScoreEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCourseScoreEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		String id = (String)this.getServletContext().getAttribute("id");
		if(id == null)id = request.getParameter("sid");
		CourseDao dao = new CourseDaoImpl();
		String cid = request.getParameter("cid");
		String cname;
		try {
			cname = dao.queryByCid(cid).getName();
			request.setAttribute("cname", cname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String score = request.getParameter("score");
		request.setAttribute("sid", id);
		request.setAttribute("cid", cid);
		request.setAttribute("score", score);
		
		request.getRequestDispatcher("stu-misstion-score-write.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
