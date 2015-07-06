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
<title>图书商城系统-图书搜索</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="front/css/style.css" />
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
						<input name="keyword" type="text"
							value="<s:property value="keyword"/>"> <input
							type="button" value="搜索" onclick="form.submit()">
					</form>
				</div>
			</div>
			<div class="m-tabs line">
				<div class="desc">
					<ul>
						<li><a href="">全部(<s:property value="#request.total" />)
						</a></li>
						<li class="curr"><a
							href="front/book/sortBySearch?page=1&orderKeywords=sales&order=desc&keyword=${keyword }">销量▼</a></li>
						<li><a href="">价格▲</a></li>
						<li><a href="">评分▼</a></li>
					</ul>
				</div>
			</div>
			<div class="m-list f-cb">
				<ul class="book-list">
					<s:iterator value="#request.books">
						<li class="item">
							<div class="img">
								<img src="image/<s:property value="image"/>" />
							</div>
							<div class="info">
								<div class="price">
									<span class="price-tag"> <s:property
											value="currentPrice" /> 元
									</span>
								</div>
								<div class="title">
									<a
										href="front/book/find?bookId=<s:property value="bookId"/>&page=1&limit=10"><s:property
											value="bookName" /></a>
								</div>
								<p>
									<span class="label">作者</span> <span class="labeled-text"><a>
											<s:property value="author" />
									</a></span>
								</p>
								<p>
									<span class="label">类别</span> <span class="labeled-text"><a
										href="front/book/findCategoryBook?categoryId=<s:property value="categoryId" />&page=1&limit=10"><s:property
												value="category.oneCategory" /></a></span>
								</p>
								<div class="rating">
									<span class="rating-star">★ ★ ★ ★ ☆</span> <span
										class="rating-average"> 9.2</span> <span
										class="rating-ammount">(<a href="">154人评价</a>)
									</span>
								</div>
								<div class="article-desc">
									<s:property value="contentSummary.substring(0,80)" />
									... <a
										href="front/book/find?bookId=<s:property value="bookId"/>&page=1&limit=10">(更多)</a>
								</div>
							</div>
						</li>
					</s:iterator>

				</ul>
			</div>
			<s:if test="#request.pageCount!=0">
				<div class="m-page m-page-sr m-page-sm">
					<a
						href="front/book/searchBook?keyword=<s:property value="keyword" />&page=1&limit=10"
						class="first pageprv">首页</a>
					<s:if test="page==1">
						<a href="javascript:void(0)" class="first pageprv z-dis"><span
							class="pagearr">&lt;</span>上一页</a>
					</s:if>
					<s:else>
						<a
							href="front/book/searchBook?keyword=<s:property value="keyword" />&page=<s:property value="page-1"/>&limit=10"
							class="first pageprv"><span class="pagearr">&lt;</span>上一页</a>
					</s:else>
					<s:if test="page>2">
						<a
							href="front/book/searchBook?keyword=<s:property value="keyword" />&page=<s:property value="page-2"/>&limit=10"><s:property
								value="page-2" /></a>
					</s:if>
					<s:if test="page>=2">
						<a
							href="front/book/searchBook?keyword=<s:property value="keyword" />&page=<s:property value="page-1"/>&limit=10"><s:property
								value="page-1" /></a>
					</s:if>
					<a class="z-crt"
						href="front/book/searchBook?keyword=<s:property value="keyword" />&page=<s:property value="page"/>&limit=10"><s:property
							value="page" /></a>
					<s:if test="page<pageCount">
						<a
							href="front/book/searchBook?keyword=<s:property value="keyword" />&page=<s:property value="page+1"/>&limit=10"><s:property
								value="page+1" /></a>
					</s:if>
					<s:if test="page<pageCount-1">
						<a
							href="front/book/searchBook?keyword=<s:property value="keyword" />&page=<s:property value="page+2"/>&limit=10"><s:property
								value="page+2" /></a>
					</s:if>
					<s:if test="page>=pageCount">
						<a href="javascript:void(0)" class="last pagenxt z-dis">下一页<span
							class="pagearr">&gt;</span></a>
					</s:if>
					<s:else>
						<a
							href="front/book/searchBook?keyword=<s:property value="keyword" />&page=<s:property value="page+1"/>&limit=10"
							class="last pagenxt">下一页<span class="pagearr">&gt;</span></a>
					</s:else>
					<a
						href="front/book/searchBook?keyword=<s:property value="keyword" />&page=<s:property value="pageCount"/>&limit=10"
						class="last pagenxt">末页</a>
				</div>
			</s:if>
		</div>
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