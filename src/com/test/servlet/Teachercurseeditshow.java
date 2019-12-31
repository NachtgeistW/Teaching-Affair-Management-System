package com.test.servlet;

import java.io.IOException;
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
 * Servlet implementation class Teachercurseeditshow
 */
@WebServlet("/Teachercurseeditshow")
public class Teachercurseeditshow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teachercurseeditshow() {
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
        
		TeacherQuery curse = new TeacherQuery();
		TeacherDao dao = new TeacherImpl();
		String cid = request.getParameter("cid");
		curse = dao.getCurse(cid, id);
		request.setAttribute("cname",curse.getCname());
		request.setAttribute("cid",curse.getCid());
		request.setAttribute("cterm", curse.getCterm());
		request.getRequestDispatcher("tea-misstion-write.jsp").forward(request, response);
	}

}
