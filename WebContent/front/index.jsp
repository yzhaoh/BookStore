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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width" />
<title>图书商城系统-主页</title>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="front/css/style.css" />
<script type="text/javascript" src="front/js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<div class="g-hd g-bgc6">
		<div class="m-hd ">
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
		<div class="g-mn">
			<div class="m-main">
				<div class="m-search">
					<form action="front/book/searchBook?page=1&limit=10" method="post">
						<input name="keyword" type="text"> <input type="button"
							value="搜索" onclick="form.submit()">
					</form>
				</div>
			</div>
			<div class="m-tabs line">
				<div class="m-title ">
					<h3>最新上线</h3>
				</div>
			</div>

			<div class="m-items f-cb">
				<s:iterator value="newBooks">
					<div class="m-item mr">
						<div class="img">
							<img src="image/<s:property value='image'/>" />
						</div>
						<div class="main">
							<h4 class="tit">
								<a
									href="front/book/find?bookId=<s:property value="bookId"/>&page=1&limit=10"><s:property
										value="bookName" /></a>
							</h4>
							<div class="author">
								<span><s:property value="author" /></span>
							</div>
							<div class="info">
								<h3>
									<s:property value="category.oneCategory" />
								</h3>
								<p>
									<s:property value="contentSummary.substring(0,30)" />
									...
								</p>
								<span class="price"><s:property value="currentPrice" />元</span>
							</div>
						</div>
					</div>
				</s:iterator>
			</div>
		</div>

		<!--sd-->
		<div class="g-sd">
			<section class="m-categories">
			<div class="m-title line">
				<h3>图书分类</h3>
			</div>
			<div class="bd">
				<ul class="list categories-list">
					<s:iterator value="#application.bookCategory">
						<li><a
							href="front/book/findCategoryBook?categoryId=<s:property value="categoryId" />&page=1&limit=10"><s:property
									value="oneCategory" /></a></li>
					</s:iterator>
				</ul>
			</div>
			</section>
			<section class="m-rankings">
			<div class="hd m-title line">
				<h3>热卖排行</h3>
			</div>
			<div class="bd">
				<ul class="list rankings-list">
					<s:iterator value="#application.salesTop">
						<li>
							<h4 class="title">
								<a href="front/book/find?bookId=<s:property value="bookId"/>"><s:property
										value="bookName" /></a>
							</h4>
							<div class="author">
								<s:property value="author" />
							</div>
						</li>
					</s:iterator>
				</ul>
			</div>
			</section>
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