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
  .ui-autocomplete-loading {
    background: white url('images/ui-anim_basic_16x16.gif') right center no-repeat;
  }
  #keyWord { width: 25em; }

  </style>
  <script>
  $(function() {
    function log( message ) {
      $( "<div>" ).text( message ).prependTo( "#log" );
      $( "#log" ).scrollTop( 0 );
    }
 
    $( "#keyWord" ).autocomplete({
      source: function( request, response ) {
        $.ajax({
          url: "<%=path%>/search",
          dataType: "json",
          data: {
            keyword:$("#keyWord").val()
          },
          success: function( data ) {
        	  alert(data);
            response( $.map(data, function(item) {
              return {
                label: item.key,
                value: item.value
              }
            }));
          }
        });
      },
      minLength: 2,
      select: function( event, ui ) {
        log( ui.item ?
          "Selected: " + ui.item.label :
          "Nothing selected, input was " + this.value);
      },
      open: function() {
        $( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
      },
      close: function() {
        $( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
      }
    });
  });
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
 
 
</body>
</html>