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
    <link rel="stylesheet" href="${ctx}/static/css/font.css">
    <link rel="stylesheet" href="${ctx}/static/css/xadmin.css">

</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="javascript:;">LayUi后台管理</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <ul class="layui-nav right" lay-filter="">
            <li class="layui-nav-item" id="userInfo">
                <a href="javascript:;"><img src="${ctx}/static/images/face.jpg" class="layui-nav-img userAvatar" width="35" height="35">
                    <cite class="adminName">管理员</cite>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;"
                           data-url="page/user/userInfo.html">
                        <i class="seraph icon-ziliao" data-icon="icon-ziliao"></i>
                        <cite>个人资料</cite></a>
                    </dd>
                    <dd><a href="javascript:;"
                           data-url="page/user/changePwd.html">
                        <i class="seraph icon-xiugai" data-icon="icon-xiugai"></i><cite>修改密码</cite>
                    </a></dd>
                    <dd><a href="javascript:;" class="showNotice"><i class="layui-icon">&#xe645;</i><cite>系统公告</cite><span class="layui-badge-dot"></span></a></dd>
                    <dd pc><a href="javascript:;" class="functionSetting"><i class="layui-icon">&#xe620;</i><cite>功能设定</cite><span class="layui-badge-dot"></span></a></dd>
                    <dd pc><a href="javascript:;" class="changeSkin"><i class="layui-icon">&#xe61b;</i>
                        <cite>更换皮肤</cite></a></dd>
                    <dd><a href="/login.jsp" class="signOut"><i class="seraph icon-tuichu"></i><cite>退出</cite></a>
                    </dd>
                </dl>
            </li>

    </ul>

</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->

<div class="left-nav">
    <div class="user-photo">
        <a class="img" title="我的头像" ><img src="${ctx}/static/images/face.jpg"
                                          class="userAvatar">
        </a>
        <p>你好！<span class="userName">管理员</span>, 欢迎登录</p>
    </div>

    <div id="side-nav">
        <ul id="nav" lay-filter="side-main">
        </ul>
    </div>
</div>

<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='/welcome' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->

<!-- 底部结束 -->

</body>
</html>
<script src="${ctx}/static/js/frame/vip_comm.js"></script>

<script>
    layui.use(['layer', 'vip_nav'], function () {
        // 操作对象
        var layer = layui.layer
            , vipNav = layui.vip_nav
            , $ = layui.jquery;

        // 主体菜单生成
       vipNav.main('/static/js/frame/nav_main.json', 'side-main', true);

    });
</script>
<script type="text/javascript" src="${ctx}/static/js/frame/xadmin.js"></script>
