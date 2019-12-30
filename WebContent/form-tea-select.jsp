<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>个人信息</title>
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
        <legend>查询--个人信息</legend>
    </fieldset>

    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="tname" lay-verify="title" autocomplete="off"
                       value="<%=(String)request.getAttribute( "tname")%>" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">教师编号</label>
            <div class="layui-input-block">
                <input type="text" name="tid" lay-verify="title" autocomplete="off"
                       value="<%=(String)request.getAttribute( "tid")%>" class="layui-input" readonly="readonly">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">职称</label>
            <div class="layui-input-block">
                <input type="text" name="title" lay-verify="title" autocomplete="off"
                       value="<%=(String)request.getAttribute( "title")%>" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">院系代号</label>
            <div class="layui-input-block">
                <input type="text" name="did" lay-verify="title" autocomplete="off"
                       value="<%=request.getAttribute( "did")%>" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="<%=(String)request.getAttribute( "sex")%>"
                       title="<%=(String)request.getAttribute( "sex")%>" checked="" disabled="disabled">
            </div>
        </div>
        <div class="layui-form-item">
            <div align="center">
                <a class="layui-btn" href="javascript:history.go(-1)" lay-filter="back">返回</a>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="plugins/layui/layui.js"></script>
<script>
    layui.use(['form'], function () {

        var form = layui.form();
        //监听提交

    });
</script>
</body>

</html>