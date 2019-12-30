package com.test.servlet;

import com.test.Course;
import com.test.dao.CourseDao;
import com.test.dao.CourseDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/EditCourseServlet")
public class CourseEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        CourseDao dao = new CourseDaoImpl();
        Course course = null;
        String id = (String) this.getServletContext().getAttribute("id");
        if (id == null) id = request.getParameter("cid");
        try {
            course = dao.queryByCid(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (course != null) {
            request.setAttribute("name", course.getName());
            request.setAttribute("id", course.getId());
            request.setAttribute("kind", course.getKind());
            request.setAttribute("testWay", course.getTestWay());
            request.setAttribute("credit", course.getCredit());
            request.setAttribute("comment", course.getComment());
        }

        request.getRequestDispatcher("form-course-edit.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
