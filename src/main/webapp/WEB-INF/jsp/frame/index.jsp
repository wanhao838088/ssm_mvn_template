<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/1
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
    <%@ include file="../common/head.jsp" %>
    <%--<link rel="stylesheet" href="${ctx}/static/css/index.css">--%>
    <link rel="stylesheet" href="${ctx}/static/css/font.css">
    <link rel="stylesheet" href="${ctx}/static/css/xadmin.css">

</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="./index.html">X-admin v2.0</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">admin</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('个人信息','http://www.baidu.com')">个人信息</a></dd>
                <dd><a onclick="x_admin_show('切换帐号','http://www.baidu.com')">切换帐号</a></dd>
                <dd><a href="./login.html">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index"><a href="/">前台首页</a></li>
    </ul>

</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->

<div class="left-nav">
    <div id="side-nav">
        <ul id="nav" lay-filter="side-main">
            <%--<li>--%>
                <%--<a href="javascript:;">--%>
                    <%--<i class="iconfont">&#xe6b8;</i>--%>
                    <%--<cite>会员管理</cite>--%>
                    <%--<i class="iconfont nav_right">&#xe697;</i>--%>
                <%--</a>--%>
                <%--<ul class="sub-menu">--%>
                    <%--<li>--%>
                        <%--<a _href="member-list.html">--%>
                            <%--<i class="iconfont">&#xe6a7;</i>--%>
                            <%--<cite>会员列表</cite>--%>

                        <%--</a>--%>
                    <%--</li >--%>
                    <%--<li>--%>
                        <%--<a _href="member-del.html">--%>
                            <%--<i class="iconfont">&#xe6a7;</i>--%>
                            <%--<cite>会员删除</cite>--%>

                        <%--</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="javascript:;">--%>
                            <%--<i class="iconfont">&#xe70b;</i>--%>
                            <%--<cite>会员管理</cite>--%>
                            <%--<i class="iconfont nav_right">&#xe697;</i>--%>
                        <%--</a>--%>
                        <%--<ul class="sub-menu">--%>
                            <%--<li>--%>
                                <%--<a _href="xxx.html">--%>
                                    <%--<i class="iconfont">&#xe6a7;</i>--%>
                                    <%--<cite>会员列表</cite>--%>

                                <%--</a>--%>
                            <%--</li >--%>
                            <%--<li>--%>
                                <%--<a _href="xx.html">--%>
                                    <%--<i class="iconfont">&#xe6a7;</i>--%>
                                    <%--<cite>会员删除</cite>--%>

                                <%--</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a _href="xx.html">--%>
                                    <%--<i class="iconfont">&#xe6a7;</i>--%>
                                    <%--<cite>等级管理</cite>--%>

                                <%--</a>--%>
                            <%--</li>--%>

                        <%--</ul>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>
        </ul>
    </div>
</div>

<%--<div class="navBar layui-side-scroll" id="navBar">--%>
    <%--<ul class="layui-nav layui-nav-tree" lay-filter="side-main">--%>
        <%--<li class="layui-nav-item  layui-nav-itemed">--%>
            <%--<a href="javascript:;">--%>
                <%--<i class="layui-icon">&#xe620;</i>基础运营</a>--%>
            <%--<dl class="layui-nav-child">--%>
            <%--</dl>--%>
        <%--</li>--%>
        <%--<li class="layui-nav-item">--%>
            <%--<a href="javascript:;"><i class="layui-icon">&#xe628;</i>网站建设</a>--%>
            <%--<dl class="layui-nav-child">--%>
                <%--<dd>--%>
                    <%--<!--<a href="javascript:;" href-url="#"><i class="layui-icon">&#xe621;</i>配置</a>-->--%>
                <%--</dd>--%>
            <%--</dl>--%>
        <%--</li>--%>
    <%--</ul>--%>
<%--</div>--%>


<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='./welcome.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer">
    <div class="copyright">Copyright ©2017 x-admin v2.3 All Rights Reserved</div>
</div>

</body>
</html>
<script src="${ctx}/static/js/frame/vip_comm.js"></script>

<script>
    layui.use(['layer', 'vip_nav'], function () {
        // 操作对象
        var layer = layui.layer
            , vipNav = layui.vip_nav
            , $ = layui.jquery;

        // 主体菜单生成 [请求地址,过滤ID,是否展开,携带参数]
       vipNav.main('/static/js/frame/nav_main.json', 'side-main', true);

    });
</script>
<script type="text/javascript" src="${ctx}/static/js/frame/xadmin.js"></script>
