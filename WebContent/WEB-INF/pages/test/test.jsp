<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>Spring MVC</title>
<%
	String path = request.getContextPath();
%>
<script src="<%=path%>/resources/js/jquery-1.12.4.js"></script>
<script src="<%=path%>/resources/js/jquery.json.min.js"></script>
<script>
	//将一个表单的数据返回成JSON对象  
	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};

	$(document).ready(
			function() {
				jQuery.ajax({
					type : 'GET',
					contentType : 'application/json',
					url : 'user/list',
					dataType : 'json',
					success : function(data) {
						if (data && data.success == "true") {
							$('#info').html("共" + data.total + "条数据。<br/>");
							$.each(data.data, function(i, item) {
								$('#info').append(
										"编号：" + item.id + "，姓名："
												+ item.username + "，年龄："
												+ item.age);
							});
						}
					},
					error: function (jqXHR, textStatus, errorThrown) {
			            /*弹出jqXHR对象的信息*/
			            alert(jqXHR.responseText);
			            alert(jqXHR.status);
			            alert(jqXHR.readyState);
			            alert(jqXHR.statusText);
			            /*弹出其他两个参数的信息*/
			            alert(textStatus);
			            alert(errorThrown);
			        }
				});
				$("#submit").click(function() {
					var jsonuserinfo = $.toJSON($('#form').serializeObject());
					alert(jsonuserinfo);
					jQuery.ajax({
						type : 'POST',
						contentType : 'application/json',
						url : 'user/add',
						data : jsonuserinfo,
						dataType : 'json',
						success : function(data) {
							alert("新增成功！");
						},
						error : function(data) {
							alert("error")
						}
					});
				});
			});
</script>
</head>
<body>
	<div id="info"></div>
	<form action="add" method="post" id="form">
		编号：<input type="text" name="id" /> 姓名：<input type="text"
			name="username" /> 年龄：<input type="text" name="age" /> <input
			type="button" value="提交" id="submit" />
	</form>
</body>
</html>
<html><head><title>Apache Tomcat/7.0.39 - Error report</title><style><!--H1 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:22px;} H2 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:16px;} H3 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:14px;} BODY {font-family:Tahoma,Arial,sans-serif;color:black;background-color:white;} B {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;} P {font-family:Tahoma,Arial,sans-serif;background:white;color:black;font-size:12px;}A {color : black;}A.name {color : black;}HR {color : #525D76;}--></style> </head><body><h1>HTTP Status 406 - </h1><HR size="1" noshade="noshade"><p><b>type</b> Status report</p><p><b>message</b> <u></u></p><p><b>description</b> <u>The resource identified by this request is only capable of generating responses with characteristics not acceptable according to the request "accept" headers.</u></p><HR size="1" noshade="noshade"><h3>Apache Tomcat/7.0.39</h3></body></html>
