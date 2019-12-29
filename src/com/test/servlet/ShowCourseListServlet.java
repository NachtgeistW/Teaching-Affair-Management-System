package com.test.servlet;

import com.PageInfo;
import com.test.Course;
import com.test.Student;
import com.test.dao.CourseDaoImpl;
import com.test.dao.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ShowCourseListServlet")
public class ShowCourseListServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        CourseDaoImpl impl = new CourseDaoImpl();
        try {
            int currentPage = 1;
            String currentPageStr = request.getParameter("currentPage");
            if (currentPageStr != null && !currentPageStr.trim().equals(""))
                currentPage = Integer.parseInt(currentPageStr);

            PageInfo info = impl.queryByPage(currentPage);
            request.setAttribute("info", info);
            request.getRequestDispatcher("admin-select-course-list.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
