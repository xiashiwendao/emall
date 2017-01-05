<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <%
	String path = request.getContextPath();
%>
  <meta charset="utf-8">
  <title>jQuery UI 自动完成（Autocomplete） - 远程 JSONP 数据源</title>
  <link rel="stylesheet" href="<%=path %>/resources/css/jquery-ui.css">
  <script src="<%=path %>/resources/js/jquery-1.12.4.js"></script>
  <script src="<%=path %>/resources/js/jquery-ui.js"></script>
  <style>
	.search {
		border: 1px solid #000;
		height: 150px;
		width: 100px;
		float: left;
		display: inline;
		margin-left: 70px;
		margin-top: 0px;
		background-color: white;
		position: absolute;
	}
	
	#list label{
		display: block
	}
	</style>
  <script>
  	var lastKeyword="";
  	function showText(text){
  		//$("#showText").html($("#showText").html() + "<br/>" + text);
  	}
  	
  	function keywordChanged(obj){
  		if(obj.value.length==0){
  			showText("长度为0，不处理")
  			$("#list").hide();
  			return;
  		}
  		// 空字符不处理
  		if($(obj).val().replace(" ", "") == ""){
  			showText("空字符串，不处理");
  			return;
  		}
  		if(lastKeyword == $(obj).val()){
  			showText("和上次关键字一样，忽略");
  			$("#list").show();
  			return;
  		}
  		lastKeyword = $(obj).val();
  		showText("设置查询关键字: " + ($(obj).val()));
  		var count = 0;
  		showText("显示下拉菜单内容：")
  		$("#list").children("label").each(function(){
  			labelText = $(this).html();
  			showText(labelText);
  			keyword = $(obj).val();
  			showText("keyword: " + keyword + "; item: " + labelText);
  			if(labelText.indexOf(keyword) >= 0){
  				showText("包含关键字");
  				count++;
  				//$(this).show();
  				$(this).css("display", "block");
  			}else{
  				//$(this).hide();
  				$(this).css("display", "none");
  			}
  		})
  		
  		if(count > 0){
  			return;
  		}
  		
  		lastKeyword=$(obj).val();
  		$("#showText").html("重新查询:(");
  		$.ajax({
            url: "<%=path%>/search",
			dataType : "json",
			data : {
				keyword : encodeURI($(obj).val())
			},
			success : function(data) {
				data = decodeURI(data);
				var dataObj = eval("("+data+")");
				$("#list").html("");
				$.each(dataObj, function(index, item){
					var preInnerHtml = $("#list").html();
					$("#list").html(preInnerHtml + "<label>" + item + "</label>");
				})
				
				$("#list").show();
			}
  		})
  	}
  </script>
</head>
<body>
	<form id="form1" action="search" method="post">
		<div>
			<label>查询商品</label>
			<input type="text" id="keyWord" name="keyWord" style="width: 100px" onkeyup="keywordChanged(this);" autocomplete="off"/><input type="submit" value="检索"/>
		</div>
	</form>
	<div>
		显示内容：<label id="showText"></label>
	</div>
	<div id="list" class="search" style="display:none">balal</div>
	<c:forEach var="product" items="${topList}">
		<div style="display: inline-block">
			<img src="<%=path%>${product.picUrl}" /><br /> <label>商品名称:
			</label>${product.name }<br /> <label>单价: </label>${product.price }
		</div>
	</c:forEach>
</body>
</html>
