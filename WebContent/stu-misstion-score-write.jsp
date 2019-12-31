<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>成绩修改</title>
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
        <legend>学生--成绩修改</legend>
    </fieldset>

    <form class="layui-form" action="StudentCourseServletEditSubmit?sid=${sid }&cid=${cid }" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">课程编号</label>
            <div class="layui-input-block">
                <input type="text" name="cid" lay-verify="title" autocomplete="off" value="${cid }" class="layui-input"
                       disabled="disabled">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">课程名称</label>
            <div class="layui-input-block">
                <input type="text" name="cname" lay-verify="title" autocomplete="off" value="${cname }"
                       class="layui-input" disabled="disabled">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">分数</label>
            <div class="layui-input-block">
                <input type="text" name="score" lay-verify="title" autocomplete="off" value="${score }"
                       class="layui-input">
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