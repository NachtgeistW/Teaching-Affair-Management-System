package com.maike.controller;

import com.maike.service.UserService;
import com.maike.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String uesrPwd = request.getParameter("userPwd");
        HttpSession session = request.getSession();
        int k = userService.judgeLogin(userName, uesrPwd);
        PrintWriter out = response.getWriter();
        out.write("<script>");

        //做登录用户的判断
        if (k == 1) {
            session.setAttribute("pass", "1");
            out.write("window.location.href='index-admin.jsp';");
        }
        if (k == 2) {
            session.setAttribute("pass", "1");
            this.getServletContext().setAttribute("id", userName);
            out.write("window.location.href='index-teacher.jsp';");
        }
        if (k == 3) {
            session.setAttribute("pass", "1");
            this.getServletContext().setAttribute("id", userName);
            out.write("window.location.href='index-student.jsp';");
        }
        if (k == 0) {
            out.write("alert('登录失败！请重新输入！');");
            out.write("window.location.href='login.html';");
        }
        out.write("</script>");
        out.close();
    }

}
