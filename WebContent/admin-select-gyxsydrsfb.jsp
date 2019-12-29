<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>各院系生源地人数分布</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="css/begtable.css"/>
</head>

<body>
<div style="margin: 15px;">
    <blockquote class="layui-elem-quote">
        各院系生源地人数分布
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
                                    <col width="100">
                                    <col>
                                </colgroup>
                                <thead>
                                <tr>
                                    <th>院系名称</th>
                                    <th>院系人数</th>
                                    <th>安徽</th>
                                    <th>福建</th>
                                    <th>广东</th>
                                    <th>湖北</th>
                                    <th>湖南</th>
                                    <th>江西</th>
                                    <th>重庆</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="u" items="${result}">
                                    <tr>
                                        <td>${u.getDepartment()}</td>
                                        <td>${u.getCount()}</td>
                                        <td>${u.getAnHui()}</td>
                                        <td>${u.getFuJian()}</td>
                                        <td>${u.getGuangDong()}</td>
                                        <td>${u.getHuBei()}</td>
                                        <td>${u.getHuNan()}</td>
                                        <td>${u.getJiangXi()}</td>
                                        <td>${u.getChongQing()}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </table>
                    </div>
                    <div class="beg-table-paged">
                        <div class="list-page" align="center">
                            共${tsum} 条记录，当前${cpage}/${tpage} 页
                            <a href="">首页</a>
                            <a href="">上一页</a>
                            <a href="">下一页</a>
                            <a href="">尾页</a>
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