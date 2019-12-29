package com.course;

import com.student.select.service.Student;
import com.student.select.service.StudentDao;
import com.student.select.service.StudentDaoImpl;
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
public class EditCourseSubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Course course = new Course();
        String id = (String) this.getServletContext().getAttribute("id");
        course.setId(id);
        course.setName(request.getParameter("name"));
        course.setComment(request.getParameter("name"));
        course.setCredit(Integer.parseInt(request.getParameter("credit")));
        course.setKind(request.getParameter("kind"));
        course.setTestWay(request.getParameter("testWay"));
        CourseDaoImpl impl = new CourseDaoImpl();
        int a = 0;
        try {
            a = impl.updateCourse(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (a != 0) {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('修改成功！');");
            out.write("window.location.href='Selectpersonedit';");
            out.write("</script>");
            out.close();
        } else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('修改失败！请重新输入！');");
            out.write("window.location.href='form-student.jsp';");
            out.write("</script>");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
