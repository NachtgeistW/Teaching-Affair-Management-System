<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>授课信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="css/begtable.css"/>
</head>

<body>
<div style="margin: 15px;">
    <blockquote class="layui-elem-quote">
        授课信息
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
                                    <th>课程代号</th>
                                    <th>课程名称</th>
                                    <th>授课时间</th>
                                    <th>选课人数</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="u" items="${result}">
                                    <tr>
                                        <td>${u.getCid()}</td>
                                        <td>${u.getCname()}</td>
                                        <td>${u.getCterm()}</td>
                                        <td>${u.getCount()}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </table>
                    </div>
                    <div class="beg-table-paged">
                        <div class="list-page" align="center">
                            共${tsum} 条记录，当前${cpage}/${tpage} 页
                            <a href="TeacherQueryCourseServlet?cp=1">首页</a>
                            <a href="TeacherQueryCourseServlet?cp=${cpage-1<1?1:cpage-1}">上一页</a>
                            <a href="TeacherQueryCourseServlet?cp=${cpage+1>tpage?tpage:cpage+1}">下一页</a>
                            <a href="TeacherQueryCourseServlet?cp=${tpage}">尾页</a>
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