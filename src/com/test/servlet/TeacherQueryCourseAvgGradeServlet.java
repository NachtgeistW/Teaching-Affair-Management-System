package com.test.servlet;

import com.student.select.service.Studentcurse;
import com.test.TeacherQuery;
import com.test.dao.TeacherDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/TeacherQueryCourseAvgGradeServlet")
public class TeacherQueryCourseAvgGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherDaoImpl impl = new TeacherDaoImpl();
        try {
        	String id = (String)this.getServletContext().getAttribute("id");
    		if(id == null)id = request.getParameter("sid");
            List<TeacherQuery> list = impl.queryCourseAvgGrade(id);
            request.setAttribute("result", list);
            request.getRequestDispatcher("tea-misstion-score.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
