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
		margin-top: 0px;
		position: absolute;
		background-color: white;
		position: absolute;
		z-index: 200px;
	}
	</style>
  <link rel="stylesheet" href="<%=path %>/resources/css/jquery-ui.css">
  <script src="<%=path %>/resources/js/jquery-1.12.4.js"></script>
  <script src="<%=path %>/resources/js/jquery-ui.js"></script>
  <script>
  $( function() {
    var availableTags = [
      "ActionScript",
      "AppleScript",
      "Asp",
      "BASIC",
      "C",
      "C++",
      "Clojure",
      "COBOL",
      "ColdFusion",
      "Erlang",
      "Fortran",
      "Groovy",
      "Haskell",
      "Java",
      "JavaScript",
      "Lisp",
      "Perl",
      "PHP",
      "Python",
      "Ruby",
      "Scala",
      "Scheme"
    ];
    $("#keyWord").autocomplete({
      source: availableTags
    });
  } );
	</script>
</head>
<body>
	<form id="form1" action="search" method="post">
		<div>
			<label>查询商品</label> <input type="text" id="keyWord" name="keyWord" style="width: 100px"/><input type="submit" value="检索"/>
		</div>
	</form>
	<!-- <div class="search">hehe</div> -->
	<c:forEach var="product" items="${topList}">
		<div style="display: inline-block">
			<img src="<%=path%>${product.picUrl}" /><br /> <label>商品名称:
			</label>${product.name }<br /> <label>单价: </label>${product.price }
		</div>
	</c:forEach>
</body>
</html>