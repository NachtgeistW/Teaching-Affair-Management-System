package com.test.servlet;

import com.test.Student;
import com.test.Teacher;
import com.test.dao.StudentDaoImpl;
import com.test.dao.TeacherDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ShowTeacherListServlet")
public class ShowTeacherListServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        TeacherDaoImpl impl = new TeacherDaoImpl();
        int cpage = 1;//当前页
        int count = 5;//每页显示条数

        //获取用户指定的页面
        String cp = request.getParameter("cp");
        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }
        try {
            List<Teacher> list = impl.queryAllTeacher(cpage, count);
            int arr[] = impl.totalpage(count, 1, null);
            request.setAttribute("teacherList", list);
            request.setAttribute("tsum", arr[0]);
            request.setAttribute("tpage", arr[1]);
            request.setAttribute("cpage", cpage);
            request.getRequestDispatcher("admin-select-teacher-list.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
