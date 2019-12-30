package com.test.servlet;

import com.test.Student;
import com.test.dao.StudentDaoImpl;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ShowStudentListServlet")
public class ShowStudentListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        StudentDaoImpl impl = new StudentDaoImpl();
        int cpage = 1;//当前页
        int count = 5;//每页显示条数
        
        //获取用户指定的页面
        String cp = request.getParameter("cp");
        if(cp!=null) {
        	cpage = Integer.parseInt(cp);
        }
        try {
        	int arr[] = impl.totalpage(count);
            List<Student> list = impl.queryAllStudent(cpage,count);
            request.setAttribute("studentList", list);
            request.setAttribute("tsum", arr[0]);
            request.setAttribute("tpage", arr[1]);
            request.setAttribute("cpage", cpage);
            request.getRequestDispatcher("admin-select-student-list.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
