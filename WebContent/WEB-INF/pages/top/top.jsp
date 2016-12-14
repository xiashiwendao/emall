<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<c:forEach var="product" items="${topList}">
		<div style="width: 100px; heigh: 100px">
			<img src="<%=path%>${product.picUrl}" />
		</div>
		<div style="float: rigth; margin-left: 10px; margin-top: 50px">
			<label>商品名称: </label>${product.name }<br /> <label>单价: </label>${product.price }
		</div>
	</c:forEach>
</body>
</html>