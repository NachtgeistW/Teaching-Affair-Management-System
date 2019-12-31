package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.Teacher;
import com.test.dao.TeacherDaoImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/CourseAddServlet")
public class CourseAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	TeacherDaoImpl impl = new TeacherDaoImpl();
    	List<Teacher> list;
		try {
			list = impl.queryAllTeacher(1,100);
			request.setAttribute("teacherList", list);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        request.getRequestDispatcher("form-course-add.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
