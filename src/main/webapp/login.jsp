<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/1
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <%@ include file="WEB-INF/jsp/common/head.jsp" %>

    <link rel="stylesheet" href="${ctx}/static/css/public.css">

</head>
<body class="loginBody">
<form class="layui-form">
    <div class="login_face">
        <img src="${ctx}/static/images/face.jpg" class="userAvatar">
    </div>
    <div class="layui-form-item input-item">
        <label for="userName">用户名</label>
        <input type="text" value="test" placeholder="请输入用户名" autocomplete="off" id="userName" class="layui-input"
               lay-verify="required">
    </div>
    <div class="layui-form-item input-item">
        <label for="password">密码</label>
        <input type="password" value="test" placeholder="请输入密码" autocomplete="off" id="password" class="layui-input"
               lay-verify="required">
    </div>
    <div class="layui-form-item input-item" id="imgCode">
        <label for="code">验证码</label>
        <input type="text" placeholder="请输入验证码" autocomplete="off" id="code" class="layui-input">
        <img src="${ctx}/kaptcha/captcha-image" width="116" height="36" id="imgVerify" onclick="getVerify(this);">
        <script>
            //获取验证码
            function getVerify(obj) {
                obj.src = "${ctx}/kaptcha/captcha-image?" + Math.random();
            }
        </script>

    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-block" id="login" lay-filter="login" lay-submit>登录</button>
    </div>
</form>
</body>

</html>
<script>
    layui.use(['form', 'layer', 'jquery'], function () {
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;

        //登录按钮
        form.on("submit(login)", function (data) {
            //检查验证码是否正确
            postRequest(kaptchaValUrl,{"verifyCode":$("#code").val()},function (json) {
                if (json==false){
                    layer.msg("验证码错误!");
                }else {
                    //验证码正确
                    $("#login").text("登录中...").attr("disabled", "disabled").addClass("layui-disabled");
                    setTimeout(function () {
                        window.location.href = "${ctx}/index";
                    }, 1000);
                }
            });

            return false;
        });

        //表单输入效果
        $(".loginBody .input-item").click(function (e) {
            e.stopPropagation();
            $(this).addClass("layui-input-focus").find(".layui-input").focus();
        })
        $(".loginBody .layui-form-item .layui-input").focus(function () {
            $(this).parent().addClass("layui-input-focus");
        })
        $(".loginBody .layui-form-item .layui-input").blur(function () {
            $(this).parent().removeClass("layui-input-focus");
            if ($(this).val() != '') {
                $(this).parent().addClass("layui-input-active");
            } else {
                $(this).parent().removeClass("layui-input-active");
            }
        })
    })

</script>