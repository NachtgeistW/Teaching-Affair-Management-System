<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>注册</title>
    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="css/login.css"/>
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
</head>

<body class="beg-login-bg">
<div class="beg-login-box" style="height: 410px;">
    <header>
        <h1>注册用户</h1>
    </header>
    <div class="beg-login-main" align="center">
        <form action="RegisterServlet" class="layui-form" method="post" id="bd" onsubmit="return check(this);"><input
                name="__RequestVerificationToken" type="hidden"
                value="fkfh8D89BFqTdrE2iiSdG_L781RSRtdWOH411poVUWhxzA5MzI8es07g6KPYQh9Log-xf84pIR2RIAEkOokZL3Ee3UKmX0Jc8bW8jOdhqo81"/>
            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe612;</i>
                </label>
                <input type="text" name="userName" lay-verify="userName" autocomplete="off" placeholder="你的登录名"
                       class="layui-input" value="" id="n">
            </div>
            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe642;</i>
                </label>
                <input type="password" name="userPwd" lay-verify="userPwd" autocomplete="off" placeholder="输入密码"
                       class="layui-input" value="" id="p1">
            </div>
            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe642;</i>
                </label>
                <input type="password" name="userRePwd" lay-verify="userRePwd" autocomplete="off" placeholder="再次确认密码"
                       class="layui-input" value="" id="p2">
            </div>
            <div class="layui-form-item" align="center">
                选择身份
                <div align="center">
                    <input type="radio" name="identity" value="3" title="学生">
                    <input type="radio" name="identity" value="2" title="老师">
                    <input type="radio" name="identity" value="1" title="管理员">
                </div>
            </div>
            <div align="center">
                <input class="layui-btn layui-btn-primary" type="submit" value="注册">

            </div>
            <a href="login.jsp" lay-filter="back">已有账号？立即登录</a>
            <div class="beg-clear">
                <footer>
                    <p align="center">WYU © </p>
                </footer>
            </div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript" src="plugins/layui/layui.js"></script>
<script>
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer,
            $ = layui.jquery,
            form = layui.form();

    });
</script>

<script type="text/javascript" language="JavaScript">

    function check(obj) {

        var i = document.getElementsByName('identity')[0].checked ||
        document.getElementsByName('identity')[1].checked ||
        document.getElementsByName('identity')[2].checked ? true : false;
        if (obj.userName.value == "") {
            alert("请输入用户名！");
            obj.userName.focus();
            return false;
        }
        if (obj.userPwd.value == "") {
            alert("请输入密码！");
            obj.userPwd.focus();
            return false;
        }
        if (obj.userRePwd.value == "") {
            alert("请再次输入密码！");
            obj.userRePwd.focus();
            return false;
        }
        if (i == false) {
            alert("请选择身份！");
            return false;
        }
        if (obj.userPwd.value != obj.userRePwd.value) {
            alert("两次密码不一致！");
            obj.userRePwd.focus();
            return false;
        }
        return true;
    }
</script>
</html>