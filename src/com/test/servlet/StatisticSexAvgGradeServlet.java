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

@WebServlet("/StatisticSexAvgGradeServlet")
public class StatisticSexAvgGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StatisticDaoImpl impl = new StatisticDaoImpl();
        try {
            List<Statistic> list1 = impl.StatisticSexAvgGrade("男");
            List<Statistic> list2 = impl.StatisticSexAvgGrade("女");
            request.setAttribute("result1", list1);
            request.setAttribute("result2", list2);
            request.getRequestDispatcher("admin-select-gyxaxbtjkcpjcj.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
