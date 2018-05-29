<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>错误</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<c:if test="${pageContext.errorData.statusCode<=499}">
		<h1>找不到要获取的页面！~</h1>
	</c:if>
	<c:if test="${pageContext.errorData.statusCode>=500}">
		<h1>网络错误哦！~</h1>
	</c:if>
	<h4><a href='jsp/index.jsp'>【<span id="span1">5</span>秒后自动返回登录页面，如果没返回请点击此处】</a></h4>
	<table border=1 id="mytable" class="table table-bordered">
		<tr valign="top">
			<td><b>Error:</b></td>
			<td>${pageContext.exception}</td>
		</tr>
		<tr valign="top">
			<td><b>URI:</b></td>
			<td>${pageContext.errorData.requestURI}</td>
		</tr>
		<tr valign="top">
			<td><b>Status code:</b></td>
			<td>${pageContext.errorData.statusCode}</td>
		</tr>
		<tr valign="top">
			<td><b>Stack trace:</b></td>
		<td>
			<c:forEach var="trace" items="${pageContext.exception.stackTrace}">
				<p>${trace}</p>
			</c:forEach>
		</td>
		</tr>
	</table>
	<script type="text/javascript" src="js/jQuery-2.2.2-min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script>
	var num = 5;
	var ospan = document.getElementById("span1");
	window.setInterval(function(){
		ospan.innerHTML = --num; 
		if(num<=0){
			location.href="jsp/index.jsp";
		}
	},1000);
</script>
</body>
</html>