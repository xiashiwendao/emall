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
<style>
.search {
	border: 1px solid #000;
	height: 50px;
	width: 70px;
	float: left;
	display: inline;
	margin-left: 70px;
	margin-top: 0px; position : absolute;
	background-color: white;
	position: absolute;
	z-index:200px;
}
</style>
</head>
<body>
	<div>
		<label>查询商品</label> <input type="text" style="width: 100px" />
	</div>
	<div class="search">hehe</div>
	<c:forEach var="product" items="${topList}">
		<div style="display: inline-block">
			<img src="<%=path%>${product.picUrl}" /><br /> <label>商品名称:
			</label>${product.name }<br /> <label>单价: </label>${product.price }
		</div>
	</c:forEach>
</body>
</html>