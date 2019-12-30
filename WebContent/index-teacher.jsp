<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>老师系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="css/global.css" media="all">
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">

</head>

<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header header header-demo">
        <div class="layui-main">
            <div class="admin-login-box">
                <a class="logo" style="left: 0;" href="#">
                    <span style="font-size: 22px;">WYUTeacher</span>
                </a>
                <div class="admin-side-toggle">
                    <i class="fa fa-bars" aria-hidden="true"></i>
                </div>
            </div>
            <ul class="layui-nav admin-header-item">

                <li class="layui-nav-item">
                    <a href="javascript:" class="admin-header-user">
                        <img src="images/0.jpg"/>
                        <span>WYU</span>
                    </a>
                    <dl class="layui-nav-child">

                        <dd>
                            <a href="LogoutServlet"><i class="fa fa-sign-out" aria-hidden="true">
                                <script language='javascript'>history.go(1);</script>
                            </i> 注销</a>
                        </dd>
                    </dl>
                </li>
            </ul>
            <ul class="layui-nav admin-header-item-mobile">
                <li class="layui-nav-item">
                    <a href="LogoutServlet"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
                </li>
            </ul>
        </div>
    </div>
    <form action="product-servlet" method="post">
        <div class="layui-side layui-bg-black" id="admin-side">
            <ul class="layui-nav layui-nav-tree" lay-filter="side">
                <li class="layui-nav-item layui-nav-itemd">
                    <a href="javascript:">查询</a>
                    <dl class="layui-nav-child">
                        <dd><a href="Teacherselectperson" target="i">查询个人信息</a></dd>
                        <dd><a href="TeacherQueryCourseServlet" target="i">查询授课信息</a></dd>
                        <dd><a href="TeacherQueryCourseAvgGradeServlet" target="i">查询课程平均成绩</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:">修改</a>
                    <dl class="layui-nav-child">
                        <dd><a href="Teacherselectedit" target="i">修改个人信息</a></dd>
                        <dd><a href="Teacherselectcurselist" target="i">修改授课信息</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </form>
    <div class="layui-body" style="bottom: 0;border-left: solid 2px #1AA094;" id="admin-body">
        <div class="layui-tab admin-nav-card layui-tab-brief" lay-filter="admin-tab">
            <ul class="layui-tab-title">
                <li class="layui-this">
                    <i class="fa fa-dashboard" aria-hidden="true"></i>
                    <cite>控制面板</cite>
                </li>
            </ul>
            <div class="layui-tab-content" style="min-height: 150px; padding: 5px 0 0 0;">
                <div class="layui-tab-item layui-show" style="height: 850px;">
                    <iframe name="i" id="i" src="main.jsp"></iframe>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-footer footer footer-demo" id="admin-footer">
        <div class="layui-main">
            <p>2019 &copy;
                <a href="#">WYU.cn</a>
            </p>
        </div>
    </div>
    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>


    <script type="text/javascript" src="plugins/layui/layui.js"></script>
    <script type="text/javascript" src="datas/nav.js"></script>
    <script src="js/index.js"></script>
    <script>
    </script>
</div>
</body>

</html>