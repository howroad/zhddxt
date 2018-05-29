<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<title>登录失败</title>
<style>
	#box{  width:300px;  margin:80px auto;  }
</style>
</head>
<body>
	<div class="box">
		<div id="box">
			<p>登录失败！${message}</p>
			<a href='/Disaster/html/index.html'><span id="span1">3</span>秒后自动回到登陆界面，若没返回请点此处！</a>
	    </div>
	</div>
<script>
	var num = 3;
	var ospan = document.getElementById("span1");
	window.setInterval(function(){
		ospan.innerHTML = --num; 
		if(num<=0){
			location.href="/Disaster/html/index.html";
		}
	},1000);
</script>
</body>
</html>