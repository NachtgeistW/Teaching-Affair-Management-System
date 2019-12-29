<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

		<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
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
						<input type="text" name="name" lay-verify="title" autocomplete="off" placeholder="<%=(String)request.getAttribute( "name")%>" class="layui-input" disabled="disabled">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">学号</label>
					<div class="layui-input-block">
						<input type="text" name="id" lay-verify="title" autocomplete="off" placeholder="<%=(String)request.getAttribute( "id")%>" class="layui-input" disabled="disabled">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">院系代号</label>
					<div class="layui-input-block">
						<input type="text" name="did" lay-verify="title" autocomplete="off" placeholder="<%=request.getAttribute( "did")%>" class="layui-input" disabled="disabled">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">身份证号</label>
					<div class="layui-input-block">
						<input type="text" name="sid" lay-verify="title" autocomplete="off" placeholder="<%=(String)request.getAttribute( "sid")%>" class="layui-input" disabled="disabled">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">出生日期</label>
					<div class="layui-input-block">
						<input type="text" name="birth" lay-verify="title" autocomplete="off" placeholder="<%=(String)request.getAttribute( "birth")%>" class="layui-input" disabled="disabled">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">生源地</label>
					<div class="layui-input-block">
						<input type="text" name="where" lay-verify="title" autocomplete="off" placeholder="<%=(String)request.getAttribute( "where")%>" class="layui-input" disabled="disabled">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">政治面貌</label>
					<div class="layui-input-block">
						<input type="text" name="politics" lay-verify="title" autocomplete="off" placeholder="<%=(String)request.getAttribute( "politics")%>" class="layui-input" disabled="disabled">
					</div>
				</div>
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-block">
						<input type="radio" name="sex" value="<%=(String)request.getAttribute( "sex")%>" title="<%=(String)request.getAttribute( "sex")%>" checked="" disabled="disabled">
					</div>
				</div>
				<div class="layui-form-item" >
					<div align="center">
						<a class="layui-btn" href="javascript:history.go(-1)" lay-filter="back">返回</a>
					</div>
				</div>
			</form>
		</div>
		<script type="text/javascript" src="plugins/layui/layui.js"></script>
		<script>
			layui.use(['form'], function() {
				var form = layui.form();
				//监听提交
				
			});
		</script>
	</body>

</html>