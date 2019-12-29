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
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String uesrPwd = request.getParameter("userPwd");
        int k = userService.judgeLogin(userName,uesrPwd);
        
				PrintWriter out=response.getWriter();
				out.write("<script>");
				
            if(k == 1) {
            	out.write("window.location.href='index-admin.jsp';");
            }
            if(k == 2) {
            	this.getServletContext().setAttribute("id", userName);
            	out.write("window.location.href='index-teacher.jsp';");
            }
            if(k == 3) {
            	this.getServletContext().setAttribute("id", userName);
            	out.write("window.location.href='index-student.jsp';");
            }
            if(k == 0) {
            	out.write("alert('登录失败！请重新输入！');");
            	out.write("window.location.href='login.html';");
            }
            out.write("</script>");
            out.close();
    }

}
