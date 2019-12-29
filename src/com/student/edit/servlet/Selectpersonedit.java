package com.student.edit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import com.student.select.service.Student;
import com.student.select.service.StudentDao;
import com.student.select.service.StudentDaoImpl;

import javafx.scene.control.RadioButton;

/**
 * Servlet implementation class Selectperson
 */
@WebServlet("/Selectpersonedit")
public class Selectpersonedit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Selectpersonedit() {
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
		Student stu = new Student();
		StudentDao stuDao = new StudentDaoImpl();
		String id = (String)this.getServletContext().getAttribute("id");
		if(id == null)id = request.getParameter("sid");
		stu = stuDao.setStudent(id);
		request.setAttribute("name",stu.getStudentName());
		request.setAttribute("id",stu.getStudentId());
		request.setAttribute("did", stu.getStudentDid());
		request.setAttribute("sid", stu.getsId());
		request.setAttribute("birth", stu.getStudentBirth());
		request.setAttribute("where", stu.getStudentWhere());
		request.setAttribute("politics", stu.getStudentSpolitics());
		request.setAttribute("sex", stu.getStudentSex());
		
		request.getRequestDispatcher("form-student.jsp").forward(request, response);
	}

}
