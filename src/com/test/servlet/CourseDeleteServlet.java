package com.test.servlet;

import com.teacher.dao.TeacherDao;
import com.teacher.dao.TeacherImpl;
import com.test.dao.CourseDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/CourseDeleteServlet")
public class CourseDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        CourseDaoImpl impl = new CourseDaoImpl();
        int a = 0;
        try {
            a = impl.deleteCourse(cid);
            if (a != 0) {
                PrintWriter out = response.getWriter();
                out.write("<script>");
                out.write("alert('删除成功！');");
                out.write("window.location.href='ShowCourseListServlet';");
                out.write("</script>");
                out.close();
            } else {
                PrintWriter out = response.getWriter();
                out.write("<script>");
                out.write("alert('删除失败！请重试！');");
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
