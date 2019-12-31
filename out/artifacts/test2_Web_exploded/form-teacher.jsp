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

			<form class="layui-form" action="Teacherupdatesubmit?tid=${tid }">
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
						<input type="text" name="tname" lay-verify="title" autocomplete="off" value="<%=(String)request.getAttribute( "tname")%>" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">教师编号</label>
					<div class="layui-input-block">
						<input type="text" name="tid" lay-verify="title" autocomplete="off" value="<%=(String)request.getAttribute( "tid")%>" class="layui-input" readonly="readonly">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">职称</label>
					<div class="layui-input-block">
						<input type="text" name="ttitle" lay-verify="title" autocomplete="off" value="<%=(String)request.getAttribute( "ttitle")%>" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">院系代号</label>
					<div class="layui-input-block">
						<input type="text" name="did" lay-verify="title" autocomplete="off" value="<%=request.getAttribute( "did")%>" class="layui-input">
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
				var form = layui.form(),
					layer = layui.layer,
					layedit = layui.layedit,
					laydate = layui.laydate;

				//创建一个编辑器
				var editIndex = layedit.build('LAY_demo_editor');
				//自定义验证规则
				form.verify({
					title: function(value) {
						if(value.length < 5) {
							return '标题至少得5个字符啊';
						}
					},
					pass: [/(.+){6,12}$/, '密码必须6到12位'],
					content: function(value) {
						layedit.sync(editIndex);
					}
				});

				//监听提交
				form.on('submit(demo1)', function(data) {
					layer.alert(JSON.stringify(data.field), {
						title: '最终的提交信息'
					})
					return false;
				});
			});
		</script>
	</body>

</html>