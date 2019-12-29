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
				<legend>修改--个人信息</legend>
			</fieldset>

			<form class="layui-form" action="editsubmit">
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
						<input type="text" name="name" lay-verify="title" autocomplete="off" value="<%=(String)request.getAttribute( "name")%>" class="layui-input" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">学号</label>
					<div class="layui-input-block">
						<input type="text" name="id" lay-verify="title" autocomplete="off" value="<%=(String)request.getAttribute( "id")%>" class="layui-input" disabled="disabled">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">院系代号</label>
					<div class="layui-input-block">
						<input type="text" name="did" lay-verify="title" autocomplete="off" value="<%=request.getAttribute( "did")%>" class="layui-input" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">身份证号</label>
					<div class="layui-input-block">
						<input type="text" name="sid" lay-verify="title" autocomplete="off" value="<%=(String)request.getAttribute( "sid")%>" class="layui-input" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">出生日期</label>
					<div class="layui-input-block">
						<input type="text" name="birth" lay-verify="title" autocomplete="off" value="<%=(String)request.getAttribute( "birth")%>" class="layui-input" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">生源地</label>
					<div class="layui-input-block">
						<input type="text" name="where" lay-verify="title" autocomplete="off" value="<%=(String)request.getAttribute( "where")%>" class="layui-input" >
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">政治面貌</label>
					<div class="layui-input-block">
						<input type="text" name="politics" lay-verify="title" autocomplete="off" value="<%=(String)request.getAttribute( "politics")%>" class="layui-input" >
					</div>
				</div>
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-block">
						<input type="radio" name="sex" value="男" title="男" id="1" <%= (request.getAttribute( "sex").equals("男"))?"checked":"" %>>
						<input type="radio" name="sex" value="女" title="女" id="2" <%= (request.getAttribute( "sex").equals("女"))?"checked":"" %>>
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
			layui.use(['form', 'layedit', 'laydate'], function() {
				var form = layui.form();
			});
		</script>
	</body>

</html>