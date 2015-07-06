<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css"
	href="js/extjs/resources/css/ext-all.css" />
<script src="js/extjs/ext-all.js"></script>
<script src="js/extjs/locale/ext-lang-zh_CN.js"></script>
<script src="js/login.js"></script>
<title>图书商城系统后台管理平台-登录</title>
</head>
<body bgcolor="#E8F2FE">

</body>
</html>