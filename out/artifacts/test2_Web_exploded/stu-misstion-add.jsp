<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>添加</title>
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
				<legend>添加--上课任务</legend>
			</fieldset>

			<form class="layui-form" action="Curseadd" onsubmit="return check(this);">
				<div class="layui-form-item">
					<label class="layui-form-label">课程名称</label>
					<select id="test" name="cid" >
						<c:forEach var="u" items="${curseidlist}">
						
							<option value="${u.cId }">${u.cName }-${u.cTname}</option>
							
						</c:forEach>
						
					</select>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">教师姓名</label>
					<select id="test" name="cTname" >
						<c:forEach var="u" items="${curseidlist}">
						
							<option value="${u.cTname }">${u.cTname}</option>
							
						</c:forEach>
						
					</select>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">修课时间</label>
					<div class="layui-input-block">
						<input type="text" name="sterm" lay-verify="title" autocomplete="off" value="2019-2020-2" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">考核方式</label>
					<div class="layui-input-block">
						<input type="text" name="ctestway" lay-verify="title" autocomplete="off" placeholder="请输入考核方式" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-block">
						<input type="text" name="comment" lay-verify="title" autocomplete="off" placeholder="请输入备注" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
		<script type="text/javascript">
			function check(obj) {
				if(obj.cterm.value==""){
					alert("请输入修课时间！");
					obj.cterm.focus();
					return false;
				}
				if(obj.ctestway.value==""){
					alert("请输入考核方式！");
					obj.ctestway.focus();
					return false;
				}
				return true;
			}
		</script>
	</body>

</html>