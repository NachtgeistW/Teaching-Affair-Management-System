package com.student.select.servlet;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class Selectcurse
 */
@WebServlet("/Selectcurse")
public class Selectcurse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Selectcurse() {
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
        String id = (String)this.getServletContext().getAttribute("id");
        if(id == null)id = request.getParameter("sid");
        StudentcurseDao cursedao = new StudentcurseDaoImpl();
        int cpage = 1;//当前页
        int count = 5;//每页显示条数
        
        //获取用户指定的页面
        String cp = request.getParameter("cp");
        if(cp!=null) {
        	cpage = Integer.parseInt(cp);
        }
        ArrayList<Studentcurse> list = new ArrayList<Studentcurse>();
        list = cursedao.setCurse(id,cpage,count);
        int arr[];
		try {
			arr = cursedao.getPage(count,1,id);
			request.setAttribute("tsum", arr[0]);
	        request.setAttribute("tpage", arr[1]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("cpage", cpage);
        request.setAttribute("curselist", list);
        request.getRequestDispatcher("stu-misstion.jsp").forward(request, response);
	}

}
