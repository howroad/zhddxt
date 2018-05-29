<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆指挥调度系统</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/font-awesome.css"/>
<style>
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #0238D0;
	background: url("img/1.jpg");
	background-size: cover;
}
.center-div{
	margin-left: auto;
    margin-right: auto;
}

.container {
	margin-top: 50px;
	background: url(img/bg-white-lock.png) repeat;
    width: 370px;
    height: 420px;
    margin-top: 50px;
    margin-left: auto;
    margin-right: auto;
    padding: 30px;
    padding-top: 20px;
    padding-bottom: 15px;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	font-size: 16px;
	height: auto;
	padding: 10px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: -1px;
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

#check_code {
	font-size: 30px;
	line-height: 40px;
	margin: 0 0 0 20px;
}

.red {
	color: red;
}

.blue {
	color: green;
}

#login_btn {
	position: relative;
	left: 180px;
}

.left i{
	color: #ccc;
    display: block !important;
    position: absolute !important;
    z-index: 1;
    margin: 9px 2px 4px 10px;
    width: 16px;
    height: 16px;
    font-size: 16px;
    text-align: center;
}
.left input{
	padding-left: 33px !important;
}
.text{
	margin-bottom: 20px !important;
}
</style>

</head>

<body>
	<div class="container">

		<form class="form-horizontal " role="form" action="user/login"
			method="post" id="form1">
			<h3 class="form-signin-heading" align="center">登陆指挥系统</h3>
			<br />
			<br />
			<div class="row">
				<div class="input-icon left">
					<div class="col-sm-12 text">
						<i class="icon-user"></i>
						<input class="m-wrap placeholder-no-fix form-control" id="username" type="text" placeholder="请输入账号" name="userName">
					</div>
				</div>
				<div class="input-icon left">
					<div class="col-sm-12 text">
						<i class="icon-lock"></i>
						<input class="m-wrap placeholder-no-fix form-control" id="password" type="password" placeholder="请输入密码" name="userPassword">
					</div>
				</div>
				<div class="input-icon left">
					<div class="col-sm-12 text">
						<i class="icon-lock"></i>
						<input id="code" class="m-wrap placeholder-no-fix form-control" type="text" placeholder="请输入验证码" name="code">
					</div>
				</div>
				<div class="col-sm-12" align="center">
					<img src="code/getCode" id="code_img" class="img-thumbnail" /><a
						href="javascript:change_code()">看不清楚，换一张</a><span id="check_code" class="glyphicon glyphicon-remove"></span>
				</div>
			</div>
			<br />
			<button class="btn btn-default" type="submit" id="login_btn">登陆</button>
		</form>
		<!-- 提醒弹出框  -->
	    <div class="modal fade" id="myModal_alert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog" style="width:200px;">
		    <div class="modal-content">
		      <div class="modal-body">
		        <p class="text-center"><strong></strong></p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default btn-" data-dismiss="modal">关闭</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div>
	</div>

	<script type="text/javascript" src="js/jQuery-2.2.2-min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/group2-commoms.js"></script>
	<script>
		$("#form1").submit(check_form);
		$("#code").keyup(function() {
			check_code();
		});
		//验证码状态
		var check_flag = false;
		//检查表单
		function check_form() {
			if ($("#username").val() == null
					|| $("#username").val().length == 0) {
				alertAiv($("#myModal_alert"), "用户名不能为空!");
				return false;
			}
			if ($("#password").val() == null
					|| $("#password").val().length == 0) {
				alertAiv($("#myModal_alert"), "密码不能为空!");
				return false;
			}
			check_code();
			if (!check_flag) {
				alertAiv($("#myModal_alert"), "验证码不正确!");
				return false;
			}
		}
		//更换验证码
		function change_code() {
			$("#code_img").attr("src",
					"code/getCode?ID=" + Math.random());
		}
		//检查验证码
		function check_code() {
			$.ajax({
				method : "post",
				url : "code/checkCode",
				data : {"code":$("#code").val()},
				success : function(msg) {
					if (msg) {
						check_flag = true;
						$("#check_code").removeClass(
								"glyphicon glyphicon-remove red");
						$("#check_code")
								.addClass("glyphicon glyphicon-ok blue");
					} else {
						check_flag = false;
						$("#check_code").removeClass(
								"glyphicon glyphicon-ok blue");
						$("#check_code").addClass(
								"glyphicon glyphicon-remove red");
					}
				}
			});
		}
	</script>
</body>
</html>