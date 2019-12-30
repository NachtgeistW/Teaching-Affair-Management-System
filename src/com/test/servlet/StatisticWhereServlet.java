package com.test.servlet;

import com.test.Statistic;
import com.test.dao.StatisticDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/StatisticWhereServlet")
public class StatisticWhereServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        StatisticDaoImpl impl = new StatisticDaoImpl();
        int cpage = 1;//当前页
        int count = 5;//每页显示条数

        //获取用户指定的页面
        String cp = request.getParameter("cp");
        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }
        try {
            List<Statistic> list = impl.StatisticWhere(cpage, count);
            int arr[] = impl.totalpage(count, 1);
            request.setAttribute("result", list);
            request.setAttribute("tsum", arr[0]);
            request.setAttribute("tpage", arr[1]);
            request.setAttribute("cpage", cpage);
            request.getRequestDispatcher("admin-select-sydrsfb.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
