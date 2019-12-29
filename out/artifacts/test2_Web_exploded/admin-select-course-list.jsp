<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>课程信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="css/begtable.css"/>
</head>

<body>
<div style="margin: 15px;">
    <blockquote class="layui-elem-quote">
        课程信息
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
                                    <th>类别</th>
                                    <th>学分</th>
                                    <th>考核方式</th>
                                    <th>备注</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${info.courseList}" var="course">
                                    <tr>
                                        <td>${course.getId()}</td>
                                        <td>${course.getName()}</td>
                                        <td>${course.getKind()}</td>
                                        <td>${course.getCredit()}</td>
                                        <td>${course.getTestWay()}</td>
                                        <td>${course.getComment()}</td>
                                        <td align="right">
                                            <a class="layui-btn layui-btn-primary layui-btn-xs" href="EditCourseServlet?cid=${courese.getCourseId()}">
                                                <i class="layui-icon">&#xe642;</i>修改课程信息
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
                            共${info.getTotalRecord()}条记录，当前${info.getCurrentPage()}/${info.getTotalPages()} 页
                            <a href="${pageContext.request.contextPath}/ShowCourseListServlet?currentPage=${1}">首页</a>
                            <a href="${pageContext.request.contextPath}/ShowCourseListServlet?currentPage=${info.currentPage - 1}">上一页</a>
                            <a href="${pageContext.request.contextPath}/ShowCourseListServlet?currentPage=${info.currentPage + 1}">下一页</a>
                            <a href="${pageContext.request.contextPath}/ShowCourseListServlet?currentPage=${info.getTotalPages()}">尾页</a>
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