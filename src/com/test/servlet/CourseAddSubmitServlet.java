package com.test.servlet;

import com.teacher.dao.TeacherDao;
import com.teacher.dao.TeacherImpl;
import com.test.Course;
import com.test.TeacherQuery;
import com.test.dao.CourseDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/CourseAddSubmitServlet")
public class CourseAddSubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Course course = new Course();

        //从form里拿信息
        course.setId(request.getParameter("id"));
        course.setName(request.getParameter("name"));
        course.setComment(request.getParameter("comment"));
        course.setCredit(Integer.parseInt(request.getParameter("credit")));
        course.setKind(request.getParameter("kind"));
        course.setStudyPeriod(Integer.parseInt(request.getParameter("studyPeriod")));
        course.setTestWay(request.getParameter("testWay"));
        course.setTteacherid(request.getParameter("tteacherid"));
        //添加信息
        CourseDaoImpl impl = new CourseDaoImpl();
        int a;
        try {
            a = impl.addCourse(course);
            if (a != 0) {
                PrintWriter out = response.getWriter();
                out.write("<script>");
                out.write("alert('添加成功！');");
                out.write("window.location.href='ShowCourseListServlet';");
                out.write("</script>");
                out.close();
            } else {
                PrintWriter out = response.getWriter();
                out.write("<script>");
                out.write("alert('添加失败！请重新输入！');");
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
