<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>登录</title>
    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="css/login.css"/>
</head>

<body class="beg-login-bg">
<div class="beg-login-box">
    <header>
        <h1>后台登录</h1>
    </header>
    <div class="beg-login-main">
        <form action="LoginServlet" class="layui-form" method="post" onsubmit="return check(this);"><input
                name="__RequestVerificationToken" type="hidden"
                value="fkfh8D89BFqTdrE2iiSdG_L781RSRtdWOH411poVUWhxzA5MzI8es07g6KPYQh9Log-xf84pIR2RIAEkOokZL3Ee3UKmX0Jc8bW8jOdhqo81"/>
            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe612;</i>
                </label>
                <input type="text" name="userName" lay-verify="userName" autocomplete="off" placeholder="这里输入登录名"
                       class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe642;</i>
                </label>
                <input type="password" name="userPwd" lay-verify="password" autocomplete="off" placeholder="这里输入密码"
                       class="layui-input">
            </div>
            <div class="layui-form-item">
                <div class="beg-pull-right">
                    <button class="layui-btn layui-btn-primary" lay-submit lay-filter="login">
                        <i class="layui-icon">&#xe650;</i> 登录
                    </button>
                    <a class="layui-btn-normal " href="insert.jsp">注册</a>
                </div>
                <div class="beg-clear"></div>
            </div>
        </form>
    </div>
    <footer>
        <p>WYU © </p>
    </footer>
</div>
<script type="text/javascript" src="plugins/layui/layui.js"></script>
<script>
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer,
            $ = layui.jquery,
            form = layui.form();
    });
</script>
<script type="text/javascript">
    function check(obj) {
        if (obj.userName.value === "") {
            alert("请输入用户名！");
            obj.userName.focus();
            return false;
        }
        if (obj.userPwd.value === "") {
            alert("请输入密码！");
            obj.userPwd.focus();
            return false;
        }
        return true;
    }
</script>
</body>

</html>