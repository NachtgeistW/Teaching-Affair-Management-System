<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="com.test.Util" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>查询学生信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="css/begtable.css"/>
</head>

<body>
<div style="margin: 15px;">
    <blockquote class="layui-elem-quote">
        学生列表
    </blockquote>
    <fieldset class="layui-elem-field">
        <div class="layui-field-box">
            <div align="right">
                <a class="layui-btn layui-btn-xs" href="javascript:history.go(-1)" lay-filter="back">返回</a>
            </div>
            <div id="xx" style=" width: 1024px; height: 450px; ; border: 1px solid #DDDDDD;">
                <div class="beg-table-box">
                    <div class="beg-table-body">
                        <table class="beg-table beg-table-bordered beg-table-striped beg-table-hovered">
                            <table class="layui-table">
                                <colgroup>
                                    <col width="150">
                                    <col width="200">
                                    <col>
                                </colgroup>
                                <thead>
                                <tr>
                                    <th>学生学号</th>
                                    <th>学生姓名</th>
                                    <th>学生院系</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${studentList}" var="student">
                                    <tr>
                                        <td>${student.getStudentId()}</td>
                                        <td>${student.getName()}</td>
                                        <td>${student.getDepartment()}</td>
                                        <td align="right">
                                            <a class="layui-btn layui-btn-primary layui-btn-xs"
                                               href="Selectperson?sid=${student.getStudentId()}">
                                                <i class="layui-icon">&#xe615;</i>查看个人信息
                                            </a>
                                            <a class="layui-btn layui-btn-primary layui-btn-xs"
                                               href="Selectcurse?sid=${student.getStudentId()}">
                                                <i class="layui-icon">&#xe615;</i>查看课程信息
                                            </a>
                                            <a class="layui-btn layui-btn-primary layui-btn-xs"
                                               href="Selectpersonedit?sid=${student.getStudentId()}">
                                                <i class="layui-icon">&#xe642;</i>修改个人信息
                                            </a>
                                            <a class="layui-btn layui-btn-primary layui-btn-xs"
                                               href="Selectcurseedit?sid=${student.getStudentId()}&num=1">
                                                <i class="layui-icon">&#xe642;</i>修改课程信息
                                            </a>
                                            <a class="layui-btn layui-btn-primary layui-btn-xs"
                                               href="Selectcurseedit?sid=${student.getStudentId()}&num=2">
                                                <i class="layui-icon">&#xe642;</i>成绩
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </table>
                    </div>
                    <div class="beg-table-paged">
                        <div class="list-page" align="center">
                            共${tsum} 条记录，当前${cpage}/${tpage} 页
                            <a href="ShowStudentListServlet?cp=1">首页</a>
                            <a href="ShowStudentListServlet?cp=${cpage-1<1?1:cpage-1}">上一页</a>
                            <a href="ShowStudentListServlet?cp=${cpage+1>tpage?tpage:cpage+1}">下一页</a>
                            <a href="ShowStudentListServlet?cp=${tpage}">尾页</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </fieldset>
    <hr>
</div>

</body>

</html>