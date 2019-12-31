package com.test.servlet;

import com.test.Course;
import com.test.Student;
import com.test.dao.CourseDaoImpl;
import com.test.dao.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ShowCourseListServlet")
public class ShowCourseListServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int cpage = 1;//当前页
        int count = 5;//每页显示条数
        
        //获取用户指定的页面
        String cp = request.getParameter("cp");
        if(cp!=null) {
        	cpage = Integer.parseInt(cp);
        }
        
    	CourseDaoImpl impl = new CourseDaoImpl();
    	try {
			int arr[] = impl.totalpage(count);
            List<Course> list = impl.queryAllCourse(cpage,count);
            request.setAttribute("courseList", list);
            request.setAttribute("tsum", arr[0]);
            request.setAttribute("tpage", arr[1]);
            request.setAttribute("cpage", cpage);
            request.getRequestDispatcher("admin-select-course-list.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
