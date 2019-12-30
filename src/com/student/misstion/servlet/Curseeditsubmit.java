package com.student.misstion.servlet;

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

/**
 * Servlet implementation class Curseeditsubmit
 */
@WebServlet("/Curseeditsubmit")
public class Curseeditsubmit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Curseeditsubmit() {
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
        Studentcurse curse = new Studentcurse();
        curse.setcId(request.getParameter("cid"));
        curse.setsTerm(request.getParameter("sterm"));
        curse.setComment(request.getParameter("comment"));
        StudentcurseDao dao = new StudentcurseDaoImpl();
        int a = dao.updateCurse(curse);
        if (a != 0) {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('修改成功！');");
            out.write("window.location.href='Selectcurseedit';");
            out.write("</script>");
            out.close();
        } else {
            request.setAttribute("cid", curse.getcId());
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('修改失败！请重新输入！');");
            out.write("window.location.href='Curseeiditshow';");
            out.write("</script>");
            out.close();
        }
    }

}
