package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.select.service.Studentcurse;
import com.student.select.service.StudentcurseDao;
import com.student.select.service.StudentcurseDaoImpl;
import com.teacher.dao.TeacherDao;
import com.teacher.dao.TeacherImpl;

/**
 * Servlet implementation class Teacherselectcursedel
 */
@WebServlet("/Teacherselectcursedel")
public class Teacherselectcursedel extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacherselectcursedel() {
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
        String tid = request.getParameter("tid");
        String cid = request.getParameter("cid");
        String sterm = request.getParameter("cterm");
        TeacherDao dao = new TeacherImpl();
        int a = dao.teacherCurseDelete(cid, sterm, tid);
        if (a != 0) {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('删除成功！');");
            out.write("window.location.href='Selectcurseedit';");
            out.write("</script>");
            out.close();
        } else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('删除失败！请重试！');");
            out.write("window.location.href='Selectcurseedit';");
            out.write("</script>");
            out.close();
        }
    }

}
