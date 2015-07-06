<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<title>图书商城系统-用户注册-验证邮箱</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="front/css/style.css" />
<script type="text/javascript" src="front/js/jquery-1.9.1.min.js"></script>
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
					<s:if test='#session.username!=null'>
						<li><a href="front/user/userInfo">个人中心</a></li>
						<li><a href="front/user/exit">退出</a></li>
					</s:if>
					<s:else>
						<li><a href="front/login.jsp">登录</a></li>
						<li><a href="front/register.jsp">注册</a></li>
					</s:else>
				</ul>
			</div>
		</div>
	</div>

	<div class="g-bd f-cb">
		<div>
			<form action="front/login.jsp" method="post">
				<fieldset>
					<legend class="legend">用户注册-激活邮箱</legend>
					<div>
						<br> <br> <br> <br> <br> <br> <br>
						<br>
					</div>
					<s:if test='#send=="success"'>
						<div align="center">
							<p class="sendEmail">
								邮件已发送！若你未收到邮件请<a
									href="front/user/sendEmail?username=<s:property value="username"/>&email=<s:property value="email"/>&url=<%=basePath%>index&checkUrl=<%=basePath%>front/user/checkUrl">点击此处</a>重新发送
							</p>
						</div>
					</s:if>
					<s:elseif test='#checkUrl=="success"'>
						<div align="center">
							<p class="sendEmail">邮箱验证成功！</p>
						</div>
					</s:elseif>
					<s:elseif test='#checkUrl=="error"'>
						<div align="center">
							<p class="sendEmail">邮箱验证失败！</p><br>
							<p class="sendEmail">可能的原因：</p>
							<p class="sendEmail">链接已失效！请在30分钟内完成验证！</p>
							<p class="sendEmail">未在同一浏览器中操作！</p>
						</div>
					</s:elseif>
					<s:else>
						<div align="center">
							<p class="sendEmail">
								注册成功！<a
									href="front/user/sendEmail?username=<s:property value="username"/>&email=<s:property value="email"/>&url=<%=basePath%>index&checkUrl=<%=basePath%>front/user/checkUrl">点击此处</a>验证邮箱，验证邮箱后可在商城购买图书
							</p>
						</div>
					</s:else>
					<div>
						<br> <br> <br>
					</div>
					<div align="center">
						<button class="u-btn" type="submit">立即登录</button>
						<div>
							<br> <br> <br> <br> <br> <br> <br>
						</div>
					</div>
				</fieldset>
			</form>
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