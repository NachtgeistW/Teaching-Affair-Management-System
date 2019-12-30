<%--
  Created by IntelliJ IDEA.
  User: 56223
  Date: 2019/12/29
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>课程信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
</head>

<body>
<div style="margin: 15px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>修改--课程信息</legend>
    </fieldset>

    <form class="layui-form" action="EditCourseSubmitServlet">
        <div class="layui-form-item">
            <label class="layui-form-label">课程代号</label>
            <div class="layui-input-block">
                <input type="text" name="id" lay-verify="title" autocomplete="off"
                       value="<%=(String)request.getAttribute("id")%>" class="layui-input" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">课程名称</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="title" autocomplete="off"
                       value="<%=(String)request.getAttribute("name")%>" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">类别</label>
            <div class="layui-input-block">
                <input type="text" name="kind" lay-verify="title" autocomplete="off"
                       value="<%=(String)request.getAttribute("kind")%>" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">学分</label>
            <div class="layui-input-block">
                <input type="text" name="credit" lay-verify="title" autocomplete="off"
                       value="<%=request.getAttribute("credit")%>" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">考核方式</label>
            <div class="layui-input-block">
                <input type="text" name="testWay" lay-verify="title" autocomplete="off"
                       value="<%=(String)request.getAttribute("testWay")%>" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <input type="text" name="comment" lay-verify="title" autocomplete="off"
                       value="<%=(String)request.getAttribute("comment")%>" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                <a class="layui-btn" href="javascript:history.go(-1)" lay-filter="back">返回</a>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="plugins/layui/layui.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form();
    });
</script>
</body>

</html>