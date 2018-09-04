<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/1
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <%@ include file="/WEB-INF/jsp/common/head.jsp" %>
    <link rel="stylesheet" href="${ctx}/static/css/font.css">
    <link rel="stylesheet" href="${ctx}/static/css/xadmin.css">

</head>
<body class="layui-anim layui-anim-up">

<div class="x-nav" style="">

    <div class="my-breadcrumb" style="float: left">
            <span class="layui-breadcrumb" lay-filter="breadcrumb" style="visibility: visible;">
              <a href="javascript:;">会员管理</a><span lay-separator="">/</span>
                <a>
                    <cite>会员列表</cite>
                </a>
             </span>
    </div>

    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">
            &#xe669;
        </i>
    </a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form id="form" class="layui-form layui-col-md12 x-so">
            <%--分页使用--%>
            <input type="hidden" id="pageVal" name="pageVal" value="">
            <input class="layui-input" placeholder="注册开始时间" name="start" id="start">
            <input class="layui-input" placeholder="注册截止时间" name="end" id="end">
            <input type="text" id="username" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
            <button id="my-data-table-query" class="layui-btn"
                    lay-filter="sreach" data-type="reload"><i class="layui-icon">&#xe615;</i>
            </button>
        </form>
    </div>

    <table class="layui-hide" id="my-data-table" lay-filter="my-data-table"></table>

</div>

<script type="text/html" id="barOption">
    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="${ctx}/static/js/frame/vip_comm.js"></script>
<script src="${ctx}/static/js/user/list.js"></script>

</body>

</html>

<script>

</script>
