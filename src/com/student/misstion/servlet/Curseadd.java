package com.student.misstion.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.select.service.Studentcurse;
import com.student.select.service.StudentcurseDao;
import com.student.select.service.StudentcurseDaoImpl;

/**
 * Servlet implementation class Curseadd
 */
@WebServlet("/Curseadd")
public class Curseadd extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Curseadd() {
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
        String id = (String) this.getServletContext().getAttribute("id");
        if (id == null) id = request.getParameter("sid");
        String cid = request.getParameter("cid").substring(0, request.getParameter("cid").indexOf(","));
        String ctname = request.getParameter("cid").substring(cid.length() + 1, request.getParameter("cid").length());
        Studentcurse curse = new Studentcurse();
        ArrayList<Studentcurse> list = new ArrayList<Studentcurse>();
        StudentcurseDao dao = new StudentcurseDaoImpl();
        list = dao.getCurseIdList(id);
        for (int x = 0; x < list.size(); x++) {
            Studentcurse s = list.get(x);
            if (s.getcId().equals(cid) && s.getcTname().equals(ctname)) {
                curse.setcName(s.getcName());
                curse.setsTerm(s.getsTerm());
                curse.setcTname(s.getcTname());
                curse.setTeacherid(s.getTeacherid());
                break;
            }
        }
        curse.setSstudentId(id);
        curse.setcId(cid);
        curse.setcTestway(request.getParameter("ctestway"));
        curse.setComment(request.getParameter("comment"));
        int a = dao.addCurse(curse);
        if (a != 0) {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('添加成功！');");
            out.write("window.location.href='Selectcurseedit';");
            out.write("</script>");
            out.close();
        } else {
            request.setAttribute("cid", curse.getcId());
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('添加失败！请重新输入！');");
            out.write("window.location.href='Curseaddshowcid';");
            out.write("</script>");
            out.close();
        }
    }

}
