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
<title>图书商城系统-购物车</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="front/css/style.css" />
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
		<div class="g-mn">
			<div class="profile profile-cart">
				<h2>购物车</h2>
			</div>
			<div class="wishlist">
				<table class="table table-striped">
					<thead>
						<tr>
							<th class="select-all"><label class="checkbox f-cb">
									<input checked="checked" type="checkbox">全选
							</label></th>
							<th class="th-name">商品名称</th>
							<th class="th-num">数量</th>
							<th class="th-price">价格</th>
							<th class="th-op">操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator
							value="#session.username==null?#session.shoppingCarts:shoppingCarts">
							<tr>
								<td class="td-select"><input type="checkbox"
									checked="checked" value="<s:property value="book.bookId" />" data-id="1803577" data-title="少年们无尽的夜"
									data-price="6.00"></td>
								<td class="td-name"><a class="works-url" target="_blank"
									href="front/book/find?bookId=<s:property value="bookId"/>&page=1&limit=10"><s:property
											value="book.bookName" /></a> <span class="author"><s:property
											value="book.author" /></span></td>
								<td class="td-num"><a href="javascript:void(0)"
									class="op-sub">-</a> <span class="book-num"><s:property
											value="number" /></span> <a href="javascript:void(0)"
									class="op-add">+</a></td>
								<td class="td-price"><span class="price-tag "><s:property
											value="book.currentPrice" />元</span></td>
								<td class="td-op"><a class="lnk-delete"
									href="front/shoppingCart/delete?bookId=<s:property value="bookId"/>"
									data-aid="1803577">删除</a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<div class="bottom-actions f-cb">
					<div class="item select-all">
						<label class="checkbox"> <input type="checkbox"
							checked="checked">全选
						</label>
					</div>
					<div class="item action-batch-delete">
						<a class="btn-link bulk-batch-delete"
							href="front/shoppingCart/deleteAll">清空购物车</a>
					</div>
					<div class="right-actions f-cb">
						<div class="item selected-items">
							已选作品 <span class="num"></span>本
						</div>
						<div class="item">合计:</div>
						<div class="item price-sum"></div>
						<div class="item action-purchase" data-article-kind="购物车中的作品"
							data-default-secretly="true" data-article-id="wishlist"
							data-widget="purchase" data-buyer-reading="">
							<a id="payForShoppingCart" class="btn btn-icon bulk-purchase"
								href="#address" data-toggle="modal" value="${session.username }">
								<span class="icon-cart"></span>结 算
							</a>
						</div>
					</div>
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
		<div id="address" class="modal fade hide in">
			<div class="dialog-hd">
				<h4 class="dialog-title">选择收货地址</h4>
				<a href="###" data-dismiss="modal" class="close">×</a>
			</div>
			<div class="dialog-bd">
				<form id="addressForm" name="" action="front/order/submitOrder" method="post">
					<table id="datas" class="table table-striped">
						<thead>
							<tr>
								<th class="radio-all"></th>
								<th class="th-user">姓名</th>
								<th class="th-address">地址</th>
								<th class="th-postcode">邮编</th>
								<th class="th-phone">联系电话</th>
							</tr>
						</thead>
						<tbody id="addressBody">
							<tr id="template">
								<td id="addressId" class="td-radio"></td>
								<td id="deliveryPerson" class="td-user"></td>
								<td id="address" class="td-address"></td>
								<td id="postcode" class="td-postcode"></td>
								<td id="phone" class="td-phone"></td>
							</tr>
						</tbody>
					</table>
					<div class="bottom-actions f-cb">
						<div class="right-actions f-cb">
							<button id="submitButton" class="btn btn-icon bulk-purchase">提交订单</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			var tbody;
			$("#submitButton").click(function(){
				var text="";
				var i=0;
				$("tbody tr").each(
					function() {
						if ($(this).children("td.td-radio").children(":radio").is(':checked')) {
							var addressId=$(this).children("td.td-radio").children(":radio").val();
							text+="<input type='hidden' name='addressId' value="+addressId+">";
							i=1;
						}
					}
				);
				if(i==0){
					alert("请选择一个收货地址");
					return false;
				}
				var index=0;
				$("tbody tr").each(
					function() {
						if ($(this).children("td.td-select").children(":checkbox").is(':checked')) {
							number = parseFloat($(this).children("td.td-num")
									.children("span.book-num").text());
							bookId=$(this).children("td.td-select")
									.children("input").val();
							text+="<input type='hidden' name='books["+index+"].bookId' value="+bookId+">";
							text+="<input type='hidden' name='books["+index+"].number' value="+number+">";
							index++;
						}
					}
				);
				tbody=$("#addressBody").html();
				$("#addressBody").html(text);
			});
			$("#payForShoppingCart").click(function(){
				if(tbody){
					$("#addressBody").html(tbody);
				}else{
					var username=$("#payForShoppingCart").attr("value");
					if($.trim(username)!=''){
					       $.ajax({
					            type: "get",//使用get方法访问后台
					            dataType: "json",//返回json格式的数据
					            url: "front/deliveryAddress/allAddress",//要访问的后台地址
					            complete :function(){$("#load").hide();},//AJAX请求完成时隐藏loading提示
					            success: function(data){//msg为返回的数据，在这里做数据绑定
									var json = eval(data);
						            if(json.deliveryAddresses!=""){
						            	 $(json.deliveryAddresses).each( function(i, n){
							                    var row = $("#template").clone();
							                    row.find("#deliveryPerson").text(n.deliveryPerson);
							                    row.find("#address").text(n.address);
							                    row.find("#postcode").text(n.postcode);
							                    row.find("#phone").text(n.phone);
							                    row.find("#addressId").html("<input type='radio' name='addressId' value="+n.addressId+">");
							                    row.attr("id","ready");//改变绑定好数据的行的id
							                    row.appendTo("#datas");//添加到模板的容器中 
							              }); 
								          $("#template").remove();
						            }else{
						            	$("#datas").remove();
						            	$("#addressForm").html("<a style='font-size: 22px;' href='front/user/userInfo'>还没有收货地址，点击添加新地址</a>");
						            }
								}
					       });
					 }else{
						$("#payForShoppingCart").attr("href","front/login.jsp");
					}
				}
			});
			getSum();
			$(".op-add").click(function() {
				var num = parseFloat($(this).prev(".book-num").text()) + 1;
				$(this).prev(".book-num").html(num);
				getSum();
			});

			$(".op-sub").click(function() {
				var num = parseFloat($(this).next(".book-num").text());
				if (num == 1) {
					alert("图书数量不能小于1");
				} else {
					$(this).next(".book-num").html(num - 1);
					getSum();
				}
			});
		});
		//全选/取消全选
		$(".select-all :checkbox").click(function() {
			$(":checkbox").prop("checked", this.checked);
			getSum();
		});

		$(":checkbox").click(function() {
			getSum();
		});

		//计算购物车总价
		function getSum() {
			var sum = 0;
			var count = 0;
			var num = 0;
			$("tbody tr").each(
					function() {
						if ($(this).children("td.td-select").children(
								":checkbox").is(':checked')) {
							var _val = parseFloat($(this).children(
									"td.td-price").children("span.price-tag")
									.text());
							num = parseFloat($(this).children("td.td-num")
									.children("span.book-num").text());
							_val = _val * num;
							count++;
						} else {
							var _val = 0;
						}
						sum += _val;
					})
			$(".price-sum").html("¥" + sum.toFixed(2));
			$(".num").html(count);
		}
	</script>
</body>
</html>