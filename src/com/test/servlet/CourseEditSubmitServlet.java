package com.test.servlet;

import com.test.Course;
import com.test.dao.CourseDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/EditCourseSubmitServlet")
public class CourseEditSubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Course course = new Course();
        course.setId(request.getParameter("id"));
        course.setName(request.getParameter("name"));
        course.setComment(request.getParameter("comment"));
        course.setCredit(Integer.parseInt(request.getParameter("credit")));
        course.setKind(request.getParameter("kind"));
        course.setTestWay(request.getParameter("testWay"));
        CourseDaoImpl impl = new CourseDaoImpl();
        int a;
        try {
            a = impl.updateCourse(course);
            if (a != 0) {
                PrintWriter out = response.getWriter();
                out.write("<script>");
                out.write("alert('修改成功！');");
                out.write("window.location.href='ShowCourseListServlet';");
                out.write("</script>");
                out.close();
            } else {
                PrintWriter out = response.getWriter();
                out.write("<script>");
                out.write("alert('修改失败！请重新输入！');");
                out.write("window.location.href='javascript:history.go(-1)';");
                out.write("</script>");
                out.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
