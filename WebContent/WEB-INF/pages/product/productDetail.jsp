<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String path = request.getContextPath();
%>
</head>
<body>
	<div style="float: left">
		<img src="<%=path%>/resources/pics/Chrysanthemum.jpg" />
	</div>
	<div style="float: left; margin-left: 10px; margin-top: 50px">
		<label>商品名称: </label>${product.name }<br />
		<label>单价: </label>${product.price }
	</div>
</body>
</html>