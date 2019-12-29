package com.test.servlet;

import com.test.Student;
import com.test.Teacher;
import com.test.dao.StudentDaoImpl;
import com.test.dao.TeacherDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ShowTeacherListServlet")
public class ShowTeacherListServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        TeacherDaoImpl impl = new TeacherDaoImpl();
        try {
            List<Teacher> list = impl.queryAllTeacher();
            request.setAttribute("teacherList", list);
            request.getRequestDispatcher("admin-select-teacher-list.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
