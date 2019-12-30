package com.test.servlet;

import com.test.Statistic;
import com.test.StatisticProvince;
import com.test.dao.StatisticDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/StatisticDepartmentWhereServlet")
public class StatisticDepartmentWhereServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StatisticDaoImpl impl = new StatisticDaoImpl();
        int cpage = 1;//当前页
        int count = 5;//每页显示条数

        //获取用户指定的页面
        String cp = request.getParameter("cp");
        if (cp != null) {
            cpage = Integer.parseInt(cp);
        }
        try {
            List<StatisticProvince> list = impl.StatisticDepartmentWhere(cpage, count);
            int arr[] = impl.totalpage(count, 2);
            request.setAttribute("result", list);
            request.setAttribute("tsum", arr[0]);
            request.setAttribute("tpage", arr[1]);
            request.setAttribute("cpage", cpage);
            request.getRequestDispatcher("admin-select-gyxsydrsfb.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
