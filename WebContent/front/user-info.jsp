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
<title>图书商城系统-个人信息</title>
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
			<div class="profile profile-info">
				<h2>个人信息</h2>
			</div>
			<div class="people-section">
				<div class="people-warper">
					<div class="people-avatar">
						<a href="#"> <img src="image/<s:property value="u.icon"/>"
							alt="">
						</a>
					</div>
					<div class="cm-body">
						<div class="hd">
							<div class="people-name">
								<s:property value="u.username" />
							</div>
						</div>
						<div class="bd">
							<span class="joined-time"> 2011-11-20 加入 </span>
						</div>
					</div>
				</div>
				<div class="user-addr">
					<div class="lined">
						<div class="more-link">
							<a href="#address" data-toggle="modal">添加收货地址</a>
						</div>
						<h3>收货地址</h3>
					</div>
					<div class="bd">
						<table class="purchase-address">
							<colgroup>
								<col class="purchased-name">
								<col class="purchased-address">
								<col class="purchased-code">
								<col class="purchased-phone">
								<col class="purchased-op">
								<col class="purchased-op">
							</colgroup>
							<thead>
								<tr>
									<th class="purchased-name">收货人</th>
									<th class="purchased-address">收货地址</th>
									<th class="purchased-code">邮编</th>
									<th class="purchased-phone">手机</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="deliveryAddresses" status="d">
									<tr>
										<td class="purchased-name"><s:property
												value="deliveryPerson" /></td>
										<td class="purchased-address"><s:property value="address" /></td>
										<td class="purchased-code"><s:property value="postcode" /></td>
										<td class="purchased-phone"><s:property value="phone" /></td>
										<td class="purchased-op"><a id='<s:property value="addressId"/>'  class="lnk-edit" href="#alterAddress" data-toggle="modal">修改</a></td>
										<td class="purchased-op"><a class="lnk-delete" href="front/deliveryAddress/delete?addressId=<s:property value="addressId"/>">删除</a></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
				<div class="user-info">
					<div class="lined">
						<div class="more-link">
							<a href="#myinfo" data-toggle="modal">修改个人信息</a>
						</div>
						<h3>我的信息</h3>
					</div>
					<div class="bd">
						<p>
							昵称：
							<s:property value="u.username" />
						</p>
						<p>
							姓名：
							<s:property value="u.name" />
						</p>
						<p>
							性别：
							<s:property value="u.sex==0?'男':'女'" />
						</p>
						<p>
							邮箱：
							<s:property value="u.email" />
						</p>
						<p>
							手机：
							<s:property value="u.phone" />
						</p>
						<p>
							居住地：
							<s:property value="u.address" />
						</p>
					</div>
				</div>
			</div>
		</div>

		<!--sd-->
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
				<h4 class="dialog-title">添加收货地址</h4>
				<a href="###" data-dismiss="modal" class="close">×</a>
			</div>
			<div class="dialog-bd">
				<div class="m-form dialog-form f-cb">
					<form name="" action="front/deliveryAddress/add" method="post">
						<fieldset>
							<div class="formitm">
								<label class="lab">收货人姓名：</label>
								<div class="ipt">
									<input type="hidden" name="userId"
										value="<s:property value="u.userId"/>" class="u-ipt">
									<input type="text" name="deliveryPerson" class="u-ipt">
									<p></p>
								</div>
							</div>
							<div class="formitm">
								<label class="lab">收货地址：</label>
								<div class="ipt">
									<input type="text" name="address" class="u-ipt">
									<p></p>
								</div>
							</div>
							<div class="formitm">
								<label class="lab">邮编：</label>
								<div class="ipt">
									<input type="text" name="postcode" class="u-ipt">
									<p></p>
								</div>
							</div>
							<div class="formitm">
								<label class="lab">手机号码：</label>
								<div class="ipt">
									<input type="text" name="phone" class="u-ipt">
									<p></p>
								</div>
							</div>
							<div class="formitm formitm-1">
								<button class="u-btn" type="submit">保存</button>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="m-dialog">
		<div id="alterAddress" class="modal fade hide in">
			<div class="dialog-hd">
				<h4 class="dialog-title">修改收货地址</h4>
				<a href="###" data-dismiss="modal" class="close">×</a>
			</div>
			<div class="dialog-bd">
				<div class="m-form dialog-form f-cb">
					<form name="" action="front/deliveryAddress/alter" method="post">
						<fieldset>
							<div class="formitm">
								<label class="lab">收货人姓名：</label>
								<div class="ipt">
									<input type="hidden" name="userId"
										value="<s:property value="u.userId"/>" class="u-ipt">
										<input type="hidden" name="addressId"
										value="" class="u-ipt">
									<input type="text" name="deliveryPerson" value="" class="u-ipt">
									<p></p>
								</div>
							</div>
							<div class="formitm">
								<label class="lab">收货地址：</label>
								<div class="ipt">
									<input type="text" name="address" value="" class="u-ipt">
									<p></p>
								</div>
							</div>
							<div class="formitm">
								<label class="lab">邮编：</label>
								<div class="ipt">
									<input type="text" name="postcode" value="" class="u-ipt">
									<p></p>
								</div>
							</div>
							<div class="formitm">
								<label class="lab">手机号码：</label>
								<div class="ipt">
									<input type="text" name="phone" value="" class="u-ipt">
									<p></p>
								</div>
							</div>
							<div class="formitm formitm-1">
								<button class="u-btn" type="submit">保存</button>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="m-dialog">
		<div id="myinfo" class="modal fade hide in">
			<div class="dialog-hd">
				<h4 class="dialog-title">修改个人信息</h4>
				<a href="###" data-dismiss="modal" class="close">×</a>
			</div>
			<div class="dialog-bd">
				<div class="m-form dialog-form f-cb">
					<form name=""
						action="front/user/alterMessage?userId=<s:property value="u.userId"/>"
						method="post">
						<fieldset>
							<div class="formitm">
								<label class="lab">昵称：</label>
								<div class="ipt">
									<input type="text" name="username" readonly="readonly"
										class="u-ipt" value='<s:property value="u.username"/>'>
									<p>
										<s:fielderror value="username" />
									</p>
								</div>
							</div>
							<div class="formitm">
								<label class="lab">姓名：</label>
								<div class="ipt">
									<input type="text" name="name" class="u-ipt"
										value='<s:property value="u.name"/>'>
									<p>
										<s:fielderror value="name" />
									</p>
								</div>
							</div>
							<div class="formitm">
								<label class="lab">性别：</label>
								<div class="ipt">
									<input type="radio" id="radio1" value="<s:property value="u.sex"/>" name="sex">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                	<input type="radio" id="radio2" name="sex">女
									<p>
										<s:fielderror value="sex" />
									</p>
								</div>
							</div>
							<div class="formitm">
								<label class="lab">手机：</label>
								<div class="ipt">
									<input type="text" name="phone" class="u-ipt"
										value='<s:property value="u.phone"/>'>
									<p>
										<s:fielderror value="phone" />
									</p>
								</div>
							</div>
							<div class="formitm">
								<label class="lab">居住地：</label>
								<div class="ipt">
									<input type="text" name="address" class="u-ipt"
										value='<s:property value="u.address"/>'>
									<p>
										<s:fielderror value="address" />
									</p>
								</div>
							</div>
							<div class="formitm formitm-1">
								<button id="alterUserSubmit" class="u-btn" type="submit">保存</button>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="front/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="front/js/bootstrap.js"></script>
<script type="text/javascript" src="front/js/puerh.js"></script>
<script type="text/javascript" src="front/js/font.js"></script>
<script>
	$(document).ready(function(){
		$(".lnk-edit").click(function(){
			var addressId=$(this).attr("id");
	    	var deliveryPerson = $(this).parent().parent().find(".purchased-name").text();
			var address = $(this).parent().parent().find(".purchased-address").text();
			var postcode = $(this).parent().parent().find(".purchased-code").text();
			var phone = $(this).parent().parent().find(".purchased-phone").text();
			
			$("#alterAddress").find("input[name='addressId']").attr("value",addressId);
	     	$("#alterAddress").find("input[name='deliveryPerson']").attr("value",deliveryPerson);
	     	$("#alterAddress").find("input[name='address']").attr("value",address);
	     	$("#alterAddress").find("input[name='postcode']").attr("value",postcode);
	     	$("#alterAddress").find("input[name='phone']").attr("value",phone);
		});
		if($("#radio1").val()==0){
			$("#radio1").attr("checked","checked");
		}else{
			$("#radio2").attr("checked","checked");
		}
		$("#alterUserSubmit").click(function(){
			$('input:radio[id="radio1"]:checked').attr("value",0);
			$('input:radio[id="radio2"]:checked').attr("value",1); 
			/*  if($("#radio1").attr("checked")){
			}else{
			}  */
		});
	});
</script>
</body>
</html>