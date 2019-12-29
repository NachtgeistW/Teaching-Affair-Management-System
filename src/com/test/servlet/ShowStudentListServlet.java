package com.test.servlet;

import com.test.Student;
import com.test.dao.StudentDaoImpl;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ShowStudentListServlet")
public class ShowStudentListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        StudentDaoImpl impl = new StudentDaoImpl();
        try {
            List<Student> list = impl.queryAllStudent();
            request.setAttribute("studentList", list);
            request.getRequestDispatcher("admin-select-student-list.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
