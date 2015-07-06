<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书商城系统-登录</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="front/css/style.css" />
<script type="text/javascript" src="front/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="front/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="front/js/validate_cn.js"></script>
<script>
	$().ready(function() {
		$("#form").validate({
			rules : {
				username : {
					required : true
				},
				password : {
					required : true,
					rangelength : [ 6, 18 ]
				}
			},
			messages : {
				username : {
					required : "请输入用户名"
				},
				password : {
					required : "请输入密码"
				}
			},
			errorElement : 'p'
		});
	});
</script>
</head>
<body>
	<div class="g-hd g-bgc6">
		<div class="m-hd">
			<div class="m-logo f-cb">
				<img src="image/logo.jpg" alt="" />
			</div>
			<div class="m-nav">
				<ul>
					<li><a href="index">首页</a></li>
					<li><a href="index">发现</a></li>
				</ul>
			</div>
			<div class="m-btn">
				<ul class="login f-cb">
					<li><a href="front/shoppingCart/shoppingCarts">购物车</a></li>
					<li><a href="front/login.jsp">登录</a></li>
					<li><a href="front/register.jsp">注册</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="g-bd f-cb">
		<div class="m-form">
			<form id="form" name="" action="front/user/login" method="post">
				<fieldset>
					<legend>欢迎登录</legend>
					<div class="formitm">
						<label class="lab">用户名：</label>
						<div class="ipt">
							<input type="text" name="username" class="u-ipt" />
						</div>
					</div>
					<br>
					<div class="formitm">
						<label class="lab">密&nbsp;&nbsp;&nbsp;码：</label>
						<div class="ipt">
							<input type="password" name="password" class="u-ipt" />
							<p>
								<s:actionerror class="error" />
							</p>
						</div>
					</div>
					<div class="formitm">
						<div class="ipt">
							<p class="tip">
								<input type="checkbox" id="agree" /><label for="agree">下次自动登录</label>
								|<a href="#">忘记密码</a>
							</p>

						</div>
					</div>
					<div class="formitm formitm-1">
						<button class="u-btn" type="submit">登录</button>
					</div>
				</fieldset>
			</form>
			<div class="g-sd">
				<p class="log">
					还没有账号？<a href="front/register.jsp">立即注册</a>
				</p>
			</div>
		</div>
	</div>
	<div class="g-ft">
		<div class="main">
			<div class="inr f-cb">
				<!-- <div class="ab">www.bookstore.com</div> -->
				<div class="vo">
					<dt>联系我们</dt>
					<dd>SuperTeam 团队</dd>
					<div class="copy">Copyright 2015 图书商城系统</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>