package com.test.servlet;

import com.test.Statistic;
import com.test.dao.StatisticDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/StatisticDepartmentAvgGradeServlet")
public class StatisticDepartmentAvgGradeServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        StatisticDaoImpl impl = new StatisticDaoImpl();
        try {
            List<Statistic> list = impl.StatisticDepartmentAvgGrade();
            request.setAttribute("result", list);
            request.getRequestDispatcher("admin-select-gyxkcdpjcj.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
