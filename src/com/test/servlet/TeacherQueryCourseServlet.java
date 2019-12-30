package com.test.servlet;

import com.test.Teacher;
import com.test.TeacherQuery;
import com.test.dao.TeacherDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/TeacherQueryCourseServlet")
public class TeacherQueryCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        TeacherDaoImpl impl = new TeacherDaoImpl();
        try {
            String id = (String) this.getServletContext().getAttribute("id");
            if (id == null) id = request.getParameter("tid");
            int cpage = 1;//当前页
            int count = 5;//每页显示条数

            //获取用户指定的页面
            String cp = request.getParameter("cp");
            if (cp != null) {
                cpage = Integer.parseInt(cp);
            }
            List<TeacherQuery> list = impl.queryCourseList(id, cpage, count);
            int arr[];
            try {
                arr = impl.totalpage(count, 2, id);
                request.setAttribute("tsum", arr[0]);
                request.setAttribute("tpage", arr[1]);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            request.setAttribute("cpage", cpage);
            request.setAttribute("result", list);
            request.getRequestDispatcher("tea-misstion.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
