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
        try {
            List<Statistic> list = impl.StatisticWhere();
            request.setAttribute("result", list);
            request.getRequestDispatcher("admin-select-sydrsfb.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
