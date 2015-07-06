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
<title>图书商城系统-图书详情</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="front/css/style.css" />
<link rel="shortcut icon" href="img/favicon.ico" />
<link rel="apple-touch-icon" href="img/touchicon.png" />
<script type="text/javascript" src="front/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="front/js/bootstrap.js"></script>
<script type="text/javascript" src="front/js/puerh.js"></script>
<script type="text/javascript" src="front/js/font.js"></script>
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
		<div class="m-good">
			<div class="main f-cb">
				<div class="bd f-cb">
					<div class="pic">
						<div class="big">
							<img src="image/<s:property value='book.image'/>" />
						</div>

					</div>
					<div class="info">
						<div class="tit">
							<h3>
								<s:property value="book.bookName" />
							</h3>
						</div>
						<div class="opt f-cb">
							<p>
								<span class="label">作者</span> <span class="labeled-text"><a><s:property
											value="book.author" /></a></span>
							</p>
							<p>
								<span class="label">类别</span> <span class="labeled-text"><a
									href=""><s:property value="book.category.oneCategory" /></a></span>
							</p>
						</div>
						<div class="rating">
							<span class="rating-star" title="5"></span> <span
								class="rating-average">好评率 99.0%</span> <span
								class="rating-amount">( <a href="javascript:void(0)"><span><s:property
											value="appraisess.size()" /></span>人评价</a>)
							</span>
						</div>
						<div class="btn f-cb">
							<div class="buy">
								<a href="front/shoppingCart/buy?bookId=<s:property value="book.bookId" />&number=1&book.bookName=<s:property value="book.bookName" />&book.author=<s:property value="book.author" />&book.currentPrice=<s:property value="book.currentPrice" />" type="button" class="u-btn"><span class="price-tag "><s:property
											value="book.currentPrice" />元</span><i class="icon-splitter">|</i>购买</a>
								<a type="button" class="u-btn u-btn-c4">收藏</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="intros">
				<div class="intros-tabs">
					<ul class="tab-title f-cb">
						<li class="tab-title-item"><a href="#tab-1" data-toggle="tab">简介</a></li>
						<li class="tab-title-item"><a href="#tab-2" data-toggle="tab">导言</a></li>
						<li class="tab-title-item"><a href="#tab-3" data-toggle="tab">作品信息</a></li>
					</ul>
				</div>
				<div id="tab-1" class="intros-intro tab-content-pane active">
					<div class="info">
						<p>
							<s:property value="book.contentSummary" />
						</p>
					</div>
				</div>
				<div id="tab-2" class="intros-intro tab-content-pane">
					<div class="info">
						<p>这个集子里收录了十篇小说，长短不一，内容各异，大部分发表在以往五六年的《萌芽》杂志上。其中前七篇的主角都是年轻女孩，关于女孩之间的八卦，关于爱情，关于对爱情的幻想，关于亲情，关于伤痛，还有关于信仰等等。后三篇，有奇思妙想，也有无尽感慨。</p>
					</div>
					<div class="info">
						<p>空闲工夫剥野菱，是宜兴话里说人闲得无聊，剥几个野菱吃，用以打发时间。野菱是很难徒手剥的，用它来形容我写小说真是量身定做。又难又没意思，剥出来的菱肉也没人稀罕，聊以打发孤身一人的夜晚而已。要是生活幸福，夜夜笙歌，谁还写小说啊。</p>
					</div>
					<div class="info">
						<p>姚黄，本名徐晚晴，以“斯弥”之名行于网络。1985年出生于江苏宜兴，现居北京。中文系毕业。西方小说重度阅读者。作品散见于《萌芽》杂志。</p>
						<p>做过山寨记者、山寨编辑，被广告行业长时间摧残过。</p>
						<p>植物爱好者，识花辨草，不稼不穑。长期无证从事植物科普、养花指导、情感疏导、生活百科疑难解答等。</p>
					</div>
				</div>
				<div id="tab-3" class="intros-intro tab-content-pane">
					<p class="author">
						<span class="label">作者</span><span class="labeled-text"><a
							itemprop="author" class="author-item" href="/author/63688008">徐晚晴</a></span>
					</p>
					<p class="category">
						<span class="label">类别</span><span class="labeled-text"><span
							itemprop="genre"> 小说 / 中短篇集 </span></span>
					</p>
					<p class="">
						<span class="label">篇数</span><span class="labeled-text">十篇</span>
					</p>
					<p class="">
						<span class="label">首次发表</span><span class="labeled-text">《萌芽》2007年第五期</span>
					</p>
					<p class="">
						<span class="label">上架时间</span><span class="labeled-text">2013年05月</span>
					</p>
					<p class="">
						<span class="label">标签</span><span class="labeled-text"><meta
								content="小说,爱情,青春,亲情,短作品" itemprop="keywords"> <a
							href="/tag/%E5%B0%8F%E8%AF%B4/">小说(4363)</a><span class="sep">/</span><a
							href="/tag/%E7%88%B1%E6%83%85/">爱情(1352)</a><span class="sep">/</span><a
							href="/tag/%E9%9D%92%E6%98%A5/">青春(843)</a><span class="sep">/</span><a
							href="/tag/%E4%BA%B2%E6%83%85/">亲情(123)</a><span class="sep">/</span><a
							href="/tag/%E7%9F%AD%E4%BD%9C%E5%93%81/">短作品(140)</a></span>
					</p>
				</div>
			</div>
			<div class="reviews">
				<section class="reviews-list">
				<div class="reviews-heading f-cb">
					<h3 class="reviews-heading-title">
						评论 <span class="reviews-count"><s:property
								value="appraisess.size()" /></span>
					</h3>
				</div>
				<div class="reviews-lists">
					<ul class="reviews-items">
						<s:iterator value="appraisess" status="appraise">
							<li class="review-item">
								<div class="avatar">
									<img width="48px" height="48px" itemprop="image"
										alt="<s:property value="user.username"/>"
										src="image/<s:property value="user.icon"/>">
								</div>
								<div class="review-info">
									<div class="review-custum">
										<div class="author" itemprop="reviewer">
											<a class="" itemprop="url" target=""><s:property
													value="user.username" /></a> <span
												class="rating-stars stars-small-context stars-small-5"
												title="5"><span class="icon-star"></span><span
												class="icon-star"></span><span class="icon-star"></span><span
												class="icon-star"></span><span class="icon-star"></span></span>
											<meta content="10" itemprop="rating">
											<meta content="10" itemprop="best">
											<meta content="2" itemprop="worst">
										</div>
										<div class="desc" itemprop="description">
											<s:property value="appraiseContent" />
										</div>
										<div class="review-data" style="">
											<s:date name="appraiseTime" format=" yyyy-MM-dd  HH:mm:ss" />
										</div>
									</div>
								</div> <s:if test="mallAnswer!=''">
									<div class="review-reply">
										<div class="author" itemprop="reviewer">
											<span>商城回复</span> <span
												class="rating-stars stars-small-context stars-small-5"
												title="5"></span>
											<meta content="10" itemprop="rating">
											<meta content="10" itemprop="best">
											<meta content="2" itemprop="worst">
										</div>
										<div class="desc" itemprop="description">
											<s:property value="mallAnswer" />
										</div>
									</div>
								</s:if>
							</li>
						</s:iterator>
					</ul>
				</div>
				</section>
			</div>
		</div>
		<!--pages-->
		<div class="m-page m-page-sr m-page-sm">
			<a href="javascript:void(0)" class="first pageprv z-dis"><span
				class="pagearr">&lt;</span>上一页</a> <a class="z-crt" rel="1"
				href="./lost?page=1">1</a> <a rel="2" href="./lost?page=2">2</a> <a
				rel="3" href="./lost?page=3">3</a> <a rel="4" href="./lost?page=4">4</a>
			<a rel="5" href="./lost?page=5">5</a> <a rel="6" href="./lost?page=6">6</a>
			<a rel="7" href="./lost?page=7">7</a> <a href="./lost?page=2"
				class="last pagenxt">下一页<span class="pagearr">&gt;</span></a>
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