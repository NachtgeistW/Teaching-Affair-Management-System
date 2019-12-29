package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class Teacheraddcursesubmit
 */
@WebServlet("/Teacheraddcursesubmit")
public class Teacheraddcursesubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacheraddcursesubmit() {
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
        TeacherQuery curse = new TeacherQuery();
        curse.setCid(request.getParameter("cid"));
        curse.setCterm(request.getParameter("cterm"));
        curse.setCname(request.getParameter("cname"));
        
        TeacherDao dao = new TeacherImpl();
        int a = dao.teacherCurseAdd(curse, id);
        if(a!=0) {
			PrintWriter out=response.getWriter();
			out.write("<script>");
        	out.write("alert('添加成功！');");
        	out.write("window.location.href='Teacherselectcurselist';");
	        out.write("</script>");
	        out.close();
		}
		else {
			PrintWriter out=response.getWriter();
			out.write("<script>");
        	out.write("alert('添加失败！请重新你输入！');");
        	out.write("window.location.href='Teachercurseeditshow';");
	        out.write("</script>");
	        out.close();
		}
	}

}
