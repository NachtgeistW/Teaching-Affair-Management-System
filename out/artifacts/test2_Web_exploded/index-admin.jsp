<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>管理员系统</title>
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
                    <span style="font-size: 22px;">WYUAdmin</span>
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
                            <a href="javascript:"><i class="fa fa-user-circle" aria-hidden="true"></i> 个人信息</a>
                        </dd>

                        <dd>
                            <a href="login.html"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
                        </dd>
                    </dl>
                </li>
            </ul>
            <ul class="layui-nav admin-header-item-mobile">
                <li class="layui-nav-item">
                    <a href="login.html"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a>
                </li>
            </ul>
        </div>
    </div>
    <form action="" method="post">
        <div class="layui-side layui-bg-black" id="admin-side">
            <ul class="layui-nav layui-nav-tree" lay-filter="side">
                <li class="layui-nav-item layui-nav-itemd">
                    <a href="javascript:">查询</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:">查询人员信息</a>
                            <dl class="layui-nav-child">
                                <dd><a href="ShowStudentListServlet" target="i">查询学生信息</a></dd>
                                <dd><a href="ShowTeacherListServlet" target="i">查询教师信息</a></dd>
                            </dl>
                        </dd>
                        <dd><a href="ShowCourseListServlet" target="i">查询课程信息</a></dd>
                    </dl>
                    <dd>
                        <a href="javascript:">统计信息</a>
                        <dl class="layui-nav-child">
                            <dd><a href="StatisticWhereServlet" target="i">生源地人数分布</a></dd>
                            <dd><a href="StatisticDepartmentWhereServlet" target="i">各院系人数生源地分布</a></dd>
                            <dd><a href="StatisticDepartmentSexServlet" target="i">各院系按性别人数分布</a></dd>
                            <dd><a href="StatisticDepartmentAvgGradeServlet" target="i">各院系课程的平均成绩</a></dd>
                            <dd><a href="StatisticDepartmentNoPassListServlet" target="i">各院系不及格名单</a></dd>
<%--                            <dd><a href="StatisticSexAvgGradeServlet" target="i">按性别统计课程平均成绩</a></dd>--%>
                        </dl>
                    </dd>
                    </dd>
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