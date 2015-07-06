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
<title>图书商城系统-订单管理</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="front/css/style.css" />
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
		<div class="g-mn">
			<div class="profile profile-account">
				<h2>订单管理</h2>
			</div>
			<div class="account">
				<div class="purchased">
					<table class="purchase-history">
						<colgroup>
							<col class="purchased-title">
							<col class="purchased-prices">
							<col class="purchased-number">
							<col class="purchased-status">
							<col class="purchased-totalprice">
							<col class="purchased-status">
							<col class="purchased-orderdetail">
							<col class="purchased-option">
						</colgroup>
						<thead>
							<tr>
								<th class="purchased-title">商品名称</th>
								<th class="purchased-prices">单价</th>
								<th class="purchased-number">数量</th>
								<th class="purchased-status">评价状态</th>
								<th class="purchased-totalprice">总价</th>
								<th class="purchased-status">交易状态</th>
								<th class="purchased-orderdetail">订单详情</th>
								<th class="purchased-option">操作</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#request.order" var="order">
								<tr class="a">
									<td colspan="8"><s:date name="orderDate"
											format="yyyy-MM-dd HH:mm:ss" />&nbsp;&nbsp;订单编号：${orderId }</td>
								</tr>
								<s:iterator value="#order.book" status="index" var="book">
									<tr class="b" id="${orderId }">
										<td class="purchased-title" id="${bookId }"><a
											href="front/book/find?bookId=${bookId }&page=1&limit=10">${bookName }</a></td>
										<td class="purchased-prices">${currentPrice }元</td>
										<td class="purchased-number">${number }</td>
										<td class="purchased-status"><a class="appraiseStatus"
											href="#review" data-toggle="modal"> <input type="hidden"
												name="bookName" value="${bookName }"> <input
												type="hidden" name="bookId" value="${bookId }"> <input
												type="hidden" name="orderId" value="${orderId }"> <s:if
													test="#order.appraise.size>0">
													<s:set var="flag" value="0" />
													<s:iterator value="#order.appraise" var="appraise">
														<s:if test="#appraise.bookId==#book.bookId">
															<s:set var="flag" value="#flag+1" />
															<input type="hidden" name="appraiseContent"
																value="${appraiseContent }">
															<input type="hidden" name="mallAnswer"
																value="${mallAnswer }">
															<input type="hidden" name="appraiseGrade"
																value="${appraiseGrade }">
														</s:if>
													</s:iterator>
													<s:if test="#flag==1">
													已评价
												</s:if>
													<s:else>
													待评价
												</s:else>
												</s:if> <s:else>
												待评价
											</s:else>
										</a></td>
										<s:if test="#index.first">
											<td class="purchased-totalprice"
												rowspan="<s:property value="book.size"/>">${totalprice }元</td>
											<s:if test="ispayed==0">
												<td class="purchased-status"
													rowspan="<s:property value="book.size"/>">已支付</td>
											</s:if>
											<s:else>
												<td id="${orderId }" class="purchased-status"
													rowspan="<s:property value="book.size"/>"><a id="pay">待支付</a></td>
											</s:else>
											<td class="purchased-orderdetail"
												rowspan="<s:property value="book.size"/>"><a
												class="show-orderdetail" href="#review3" data-toggle="modal">
													<input type="hidden" name="phone" value="${deliveryAddress.phone }"> 
													<input type="hidden" name="address" value="${deliveryAddress.address }">
													<input type="hidden" name="deliveryPerson" value="${deliveryAddress.deliveryPerson }">
													 <input type="hidden" name="postcode" value="${deliveryAddress.postcode }">
													 <input type="hidden" name="orderId" value="${orderId }">查看</a></td>
											<td class="purchased-option"
												rowspan="<s:property value="book.size"/>"><a
												href="front/order/delete?orderId=${orderId }"
												class="deleteOrder">删除</a></td>
										</s:if>
									</tr>
								</s:iterator>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="g-sd">
			<section class="m-porfile">
			<div class="bd">
				<ul class="list categories-list">
					<li><h4 class="title">
							<a href="front/shoppingCart/shoppingCarts">购&nbsp;&nbsp;物&nbsp;&nbsp;车</a>
						</h4></li>
					<li><h4 class="title">
							<a href="front/order/userOrders">订单管理</a>
						</h4></li>
					<li><h4 class="title">
							<a href="front/user/userInfo">个人信息</a>
						</h4></li>
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
	<div class="m-mask"></div>

	<div class="m-dialog">
		<div id="review" class="modal fade hide in">
			<div class="dialog-hd">
				<h4 class="dialog-title" id="bookTitle"></h4>
				<a href="###" data-dismiss="modal" class="close">×</a>
			</div>
			<div class="dialog-bd">
				<form action="front/appraise/appraise" method="post">
					<input type="hidden" id="orderId" name="orderId" value="">
					<input type="hidden" id="bookId" name="bookId" value="">
					<div class="dialog-form">
						<div class="rating-stars">
							<span class="label">评分</span> <span class="stars-context"
								data-stars="0" href="#" data-stars="2" href="#"> <input
								type="radio" class="star-region" value="1" data-star="1"
								name="rating"> <input type="radio" class="star-region"
								value="2" data-star="2" name="rating"> <input
								type="radio" class="star-region" value="3" data-star="3"
								name="rating"> <input type="radio" class="star-region"
								value="4" data-star="4" name="rating"> <input
								type="radio" class="star-region" value="5" data-star="5"
								name="rating">
							</span>
						</div>
						<div class="rating-grade">
							<input type="radio" value="3" name="appraiseGrade"
								checked="checked">好评 <input type="radio" value="2"
								name="appraiseGrade">中评 <input type="radio" value="1"
								name="appraiseGrade">差评
						</div>
						<div class="rating-comment">
							<label class="comment-label">评价</label>
							<textarea name="appraiseContent" id="appraiseContent" cols="30"
								rows="10" placeholder="你对这部作品的看法和意见" data-max-height="400"
								style="height: 260px;"></textarea>
						</div>
						<div class="form-ft f-cb">
							<button type="submit" id="submitAppraise" class="u-btn">提交评价</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div id="review2" class="modal fade hide in">
			<div class="dialog-hd">
				<h4 class="dialog-title">评价内容</h4>
				<a href="###" data-dismiss="modal" class="close">×</a>
			</div>
			<div class="dialog-bd">
				<div class="dialog-form">
					<div class="rating-stars">
						<span class="label">评价等级</span> <span class="stars-context">
						</span>
					</div>
					<div class="rating-grade">
						<label id="appraiseGrade"></label>
					</div>
					<div class="rating-comment">
						<label class="comment-label">我的评价</label> <input type="hidden"
							id="" value=""> <input type="hidden" id="" value="">
						<textarea name="comment" id="myAppraise" cols="30" rows="10"
							data-max-height="200" style="height: 160px;" readonly="readonly">
						</textarea>
					</div>
					<div class="rating-comment">
						<label class="comment-label">商城回复</label>
						<textarea name="comment" id="mallAnswer" cols="30" rows="10"
							data-max-height="200" style="height: 160px;" readonly="readonly"></textarea>
					</div>
				</div>
			</div>
		</div>
		<div id="review3" class="modal fade hide in">
			<div class="dialog-hd">
				<h4 class="dialog-title">订单详情</h4>
				<a href="###" data-dismiss="modal" class="close">×</a>
			</div>
			<div class="dialog-bd">
				<div class="dialog-form">
					<div class="rating-orderdetail">
						<span class="label">订单编号：</span> <span class="stars-context"
							id="orderDetail-orderId"> </span>
					</div>
					<div class="rating-orderdetail">
						<span class="label">收&nbsp;&nbsp;货&nbsp;人：</span> <span
							class="stars-context" id="orderDetail-deliveryPerson"> </span>
					</div>
					<div class="rating-orderdetail">
						<span class="label">联系电话：</span> <span class="stars-context"
							id="orderDetail-phone"> </span>
					</div>
					<div class="rating-orderdetail">
						<span class="label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编：</span>
						<span class="stars-context" id="orderDetail-postcode"> </span>
					</div>
					<div class="rating-orderdetail">
						<span class="label">收货地址：</span> <span class="stars-context"
							id="orderDetail-address"> </span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="front/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="front/js/bootstrap.js"></script>
	<script type="text/javascript" src="front/js/puerh.js"></script>
	<script type="text/javascript" src="front/js/font.js"></script>
	<script>
		$(document).ready(
				function() {
					$(".deleteOrder").click(function() {
						var deleteOrder = confirm("是否确认删除该订单，删除后无法恢复？");
						if (deleteOrder == false) {
							return false;
						}
					})
					$("#submitAppraise").click(function() {
						if ($("#appraiseContent").val().trim() == "") {
							alert("评价内容不能为空！");
							return false;
						}
					})
					$(".appraiseStatus").click(
							function() {
								if ($(this).text().trim() == "已评价") {
									$(this).attr("href", "#review2");
									var appraiseContent = $(this).children(
											"input[name='appraiseContent']")
											.val();
									var mallAnswer = $(this).children(
											"input[name='mallAnswer']").val();
									var appraiseGrade = $(this).children(
											"input[name='appraiseGrade']")
											.val();
									$("#myAppraise").text(appraiseContent);
									$("#mallAnswer").text(mallAnswer);
									var grade;
									if (appraiseGrade.trim() == "3") {
										grade = "好评！";
										$("#appraiseGrade").attr("class",
												"goodAppraise");
									} else if (appraiseGrade.trim() == "2") {
										grade = "中评！";
									} else {
										grade = "差评！";
									}
									$("#appraiseGrade").text(grade);
								} else {
									var bookName = $(this).children(
											"input[name='bookName']").val();
									var bookId = $(this).children(
											"input[name='bookId']").val();
									var orderId = $(this).children(
											"input[name='orderId']").val();
									$("#bookTitle")
											.text("评价《" + bookName + "》");
									$("#bookId").val(bookId);
									$("#orderId").val(orderId);
								}
							})
							
							$(".show-orderdetail").click(
							function() {
									var orderId = $(this).children("input[name='orderId']").val();
									var deliveryPerson = $(this).children("input[name='deliveryPerson']").val();
									var postcode = $(this).children("input[name='postcode']").val();
									var address = $(this).children("input[name='address']").val();
									var phone = $(this).children("input[name='phone']").val();
									$("#orderDetail-orderId").text(orderId);
									$("#orderDetail-deliveryPerson").text(deliveryPerson);
									$("#orderDetail-postcode").text(postcode);
									$("#orderDetail-address").text(address);
									$("#orderDetail-phone").text(phone);
							})

					var str = "stars-small-";
					var str1 = "data-stars";
					var num = "0";

					$('.star-region').click(function() {
						$('.stars-context').attr(str1, $(this).val());
					})

					$('.stars-context').addClass(str + num).attr(str1, "0");

					$('.stars-context').mouseover(function() {
						$('.star-region').hover(function() {
							$('.stars-context').removeClass(str + num);
							num = $(this).val();
							$('.stars-context').addClass(str + num);
						}, function() {
							return;
						})
					})

					$('.stars-context').mouseleave(
							function() {
								num = $(this).attr(str1);
								$('.stars-context').attr("class",
										str + num + " stars-context");
							})
					$("#pay").click(
							function() {
								var totalPrice = $(this).parent().parent()
										.find(".purchased-totalprice").text()
								var pay = confirm("是否确认支付" + totalPrice + "？");
								if (pay) {
									var orderId = $(this).parent().attr("id");
									$(this).attr(
											"href",
											"front/order/pay?orderId="
													+ orderId);
								} else {
									$(this).removeAttr("href");
								}
							})

				})
	</script>

</body>
</html>