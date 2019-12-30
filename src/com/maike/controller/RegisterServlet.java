package com.maike.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maike.service.UserService;
import com.maike.service.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String userRePwd = request.getParameter("userRePwd");
        String userIdentity = request.getParameter("identity").toString();
        int k = userService.insertUser(userName, userPwd, userRePwd, userIdentity);
        if (k > 0) {
            request.getRequestDispatcher("login.html").forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('注册失败！');");
            out.write("window.location.href='insert.html';");
            out.write("</script>");
            out.close();
        }
    }

}
