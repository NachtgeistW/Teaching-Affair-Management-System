package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.select.service.Student;
import com.student.select.service.StudentDao;
import com.student.select.service.StudentDaoImpl;
import com.teacher.dao.TeacherDao;
import com.teacher.dao.TeacherImpl;
import com.test.TeacherQuery;

/**
 * Servlet implementation class Teachercurseeditsubmit
 */
@WebServlet("/Teachercurseeditsubmit")
public class Teachercurseeditsubmit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teachercurseeditsubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        TeacherQuery curse = new TeacherQuery();
        String id = (String) this.getServletContext().getAttribute("id");
        curse.setCid(request.getParameter("cid"));
        curse.setCname(request.getParameter("cname"));
        curse.setCterm(request.getParameter("cterm"));
        System.out.println(curse.getCid() + curse.getCname() + curse.getCterm());
        TeacherDao dao = new TeacherImpl();
        int a = dao.teacherCurseUpdate(curse);
        if (a != 0) {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('修改成功！');");
            out.write("window.location.href='Teacherselectcurselist';");
            out.write("</script>");
            out.close();
        } else {
            request.setAttribute("cid", curse.getCid());
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('修改失败！请重新输入！');");
            out.write("window.location.href='Teachercurseeditshow';");
            out.write("</script>");
            out.close();
        }
    }

}
