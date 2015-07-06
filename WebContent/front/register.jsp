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
<title>图书商城系统-用户注册</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="front/css/style.css" />
<script type="text/javascript" src="front/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="front/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="front/js/validate_cn.js"></script>
<script type="text/javascript">
	function changeValidateCode(obj) {
		/*** 
		 *   获取当前的时间作为参数，无具体意义    
		 *   每次请求需要一个不同的参数，否则可能会返回同样的验证码     
		 *   这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。   
		 */
		var timeNow = new Date().getTime();
		obj.src = "front/user/changeCode.action?time=" + timeNow;
	}
	$().ready(function() {
		$("#form").validate({
			rules : {
				username : {
					required : true
				},
				email : {
					required : true,
					email : true
				},
				password : {
					required : true,
					rangelength : [ 6, 18 ]
				},
				repassword : {
					required : true,
					rangelength : [ 6, 18 ],
					equalTo : "#password"
				},
				code : {
					required : true
				}
			},
			messages : {
				username : {
					required : "用户名不能为空"
				},
				email : {
					required : "请输入你要绑定的邮箱账号"
				},
				password : {
					required : "密码不能为空"
				},
				repassword : {
					required : "请再次输入密码",
					equalTo : "两次输入密码不一致"
				},
				code : {
					required : "请输入验证码"
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
		<div class="m-form">
			<form id="form" action="front/user/register" method="post">
				<fieldset>
					<legend>欢迎注册账户</legend>
					<div class="formitm">
						<label class="lab">用户名：</label>
						<div class="ipt">
							<input type="text" name="username" class="u-ipt" />
							<s:fielderror class="error" fieldName="username" />
							<p>2~8个字符，包括字母，数字，下划线。以字母开头，字母或数字结尾</p>
						</div>
					</div>
					<div class="formitm">
						<label class="lab">邮箱：</label>
						<div class="ipt">
							<input type="text" name="email" class="u-ipt" />
							<s:fielderror class="error" fieldName="email" />
							<p>输入你要绑定的邮箱</p>
						</div>
					</div>
					<div class="formitm">
						<label class="lab">初始密码：</label>
						<div class="ipt">
							<input type="password" id="password" name="password" class="u-ipt" />
							<s:fielderror class="error" fieldName="password" />
							<p>6~18个字符，区分大小写</p>
						</div>
					</div>
					<div class="formitm">
						<label class="lab">确认密码：</label>
						<div class="ipt">
							<input type="password" name="repassword" class="u-ipt" />
							<s:fielderror class="error" fieldName="repassword" />
							<p>再次输入密码</p>
						</div>
					</div>
					<div class="formitm">
						<label class="lab">验证码：</label>
						<div class="ipt">
							<input type="text" name="code" class="u-ipt" /><img
								class="code-img" src="front/user/changeCode.action"
								onclick="changeValidateCode(this)" title="点击图片刷新验证码" />
							<s:fielderror class="error" fieldName="code" />
							<p>点击图片刷新验证码</p>
							<p class="tip">
								<input type="checkbox" id="agree" /><label for="agree">同意“服务条款”和“隐私权保护和个人信息利用政策”</label>
							</p>
						</div>
					</div>
					<div class="formitm formitm-1">
						<button class="u-btn" type="submit">立即注册</button>
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