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
import com.teacher.dao.TeacherDao;
import com.teacher.dao.TeacherImpl;
import com.teacher.model.Teacher;

/**
 * Servlet implementation class Teacherupdatesubmit
 */
@WebServlet("/Teacherupdatesubmit")
public class Teacherupdatesubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacherupdatesubmit() {
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
		teacher.setTteacherid(id);
        teacher.setTname(request.getParameter("tname"));
        teacher.setDid(Integer.parseInt(request.getParameter("did")));
        teacher.setTsex(request.getParameter("sex").toString());
        teacher.setTtitle(request.getParameter("ttitle"));
		int a = dao.teacherUpdate(teacher);	
		if(a!=0) {
			PrintWriter out=response.getWriter();
			out.write("<script>");
        	out.write("alert('修改成功！');");
        	out.write("window.location.href='Teacherselectedit';");
	        out.write("</script>");
	        out.close();
		}
		else {
			PrintWriter out=response.getWriter();
			out.write("<script>");
        	out.write("alert('修改失败！请重新输入！');");
        	out.write("window.location.href='form-teacher.jsp';");
	        out.write("</script>");
	        out.close();
		}
	}

}
