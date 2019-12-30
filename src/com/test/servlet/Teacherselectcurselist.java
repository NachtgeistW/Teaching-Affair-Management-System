package com.test.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.TeacherQuery;
import com.test.dao.TeacherDaoImpl;

/**
 * Servlet implementation class Teacherdeletecurselist
 */
@WebServlet("/Teacherselectcurselist")
public class Teacherselectcurselist extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacherselectcurselist() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        TeacherDaoImpl impl = new TeacherDaoImpl();
        int cpage = 1;//当前页
        int count = 5;//每页显示条数

        //获取用户指定的页面
        String cp = request.getParameter("cp");
        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }
        try {
            String id = (String) this.getServletContext().getAttribute("id");
            if (id == null) id = request.getParameter("tid");
            List<TeacherQuery> list = impl.queryCourseList(id, cpage, count);
            int arr[] = impl.totalpage(count, 2, id);
            request.setAttribute("tsum", arr[0]);
            request.setAttribute("tpage", arr[1]);
            request.setAttribute("cpage", cpage);
            request.setAttribute("result", list);
            request.setAttribute("tid", id);
            request.getRequestDispatcher("tea-misstion-edit.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
