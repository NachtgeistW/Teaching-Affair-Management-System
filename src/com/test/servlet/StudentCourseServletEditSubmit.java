package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class StudentCourseServletEditSubmit
 */
@WebServlet("/StudentCourseServletEditSubmit")
public class StudentCourseServletEditSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCourseServletEditSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
		CourseDao dao = new CourseDaoImpl();
		String id = (String)this.getServletContext().getAttribute("id");
		if(id == null)id = request.getParameter("sid");
		String cid = request.getParameter("cid");
		int score = Integer.parseInt(request.getParameter("score"));
		int a = dao.updateStuScore(id,cid,score);
		if(a!=0) {
			this.getServletContext().setAttribute("id",id);
			PrintWriter out=response.getWriter();
			out.write("<script>");
        	out.write("alert('修改成功！');");
        	out.write("window.location.href='Selectcurseedit?num=2';");
	        out.write("</script>");
	        out.close();
		}
		else {
			PrintWriter out=response.getWriter();
			out.write("<script>");
        	out.write("alert('修改失败！请重新输入！');");
        	out.write("window.location.href='form-student.jsp';");
	        out.write("</script>");
	        out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
