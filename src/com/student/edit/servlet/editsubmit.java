package com.student.edit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.select.service.Student;
import com.student.select.service.StudentDao;
import com.student.select.service.StudentDaoImpl;

/**
 * Servlet implementation class editsubmit
 */
@WebServlet("/editsubmit")
public class editsubmit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public editsubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Student stu = new Student();
        String id = (String) this.getServletContext().getAttribute("id");
        stu.setStudentId(id);
        stu.setStudentName(request.getParameter("name"));
        stu.setStudentWhere(request.getParameter("where"));
        stu.setStudentSex(request.getParameter("sex").toString());
        stu.setsId(request.getParameter("sid"));
        stu.setStudentBirth(request.getParameter("birth"));
        stu.setStudentDid(Integer.valueOf(request.getParameter("did")));
        stu.setStudentSpolitics(request.getParameter("politics"));
        StudentDao dao = new StudentDaoImpl();
        int a = dao.updateStudent(stu);
        if (a != 0) {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('修改成功！');");
            out.write("window.location.href='Selectpersonedit';");
            out.write("</script>");
            out.close();
        } else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('修改失败！请重新输入！');");
            out.write("window.location.href='form-student.jsp';");
            out.write("</script>");
            out.close();
        }
    }

}
