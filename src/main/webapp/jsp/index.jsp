<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="XXXX系统">
    <meta name="author" content="luhao">
    <title>指挥调度系统</title>
    <!-- 文本框 -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/sb-admin-2.css"/>
    <!-- Custom Fonts -->
    <link rel="stylesheet" href="css/font-awesome.min.css"/>
    <!--zzm-->
    <link rel="stylesheet" href="css/zzmcss.css">
    <!--luhao-->
    <link rel="stylesheet" href="css/lu.css"/>
<body>
    <div id="wrapper">
        <!-- 头部导航栏 -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" id="header">
            <div class="navbar-header" id="group2-title">
                <a class="navbar-brand" href="jsp/index.jsp">指挥调度系统</a>
            </div>
            <!-- /.标题结束 -->
            <ul class="nav navbar-top-links navbar-right" id="hover-color">
                <!--个人信息按钮-->
                <li class="dropdown">
                    <a class="dropdown-toggle tip" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw write-title"></i>  <i class="fa fa-caret-down write-title"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="javascript:void(0)"><i class="fa fa-user fa-fw"></i> 个人信息</a>
                        </li>
                        <li><a href="javascript:void(0)"><i class="fa fa-gear fa-fw"></i> 设置</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="javascript:login_out()"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
                        </li>
                    </ul>
                </li>
                <!-- /.个人信息按钮结束 -->
            </ul>
            <!-- /.头部结束 -->

            <!--左边导航栏-->
            <div class="navbar-default sidebar" role="navigation" id="left_nav">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <!--搜索框-->
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="搜索...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                        </li>
                        <!-- /搜索框结束 -->
                        <!--资料管理-->
                        <shiro:hasPermission name="scheduling:*">
                        <li>
                            <a href="javascript:void(0)" id="dis_report"><i class="fa fa-dashboard fa-fw"></i> 突发事件列表</a>
                        </li> 
                        </shiro:hasPermission>
                        <shiro:hasPermission name="planning:*">
                        <li>
                            <a href="javascript:void(0)" id="eme_planning"><i class="fa fa-dashboard fa-fw"></i> 预案管理</a>
                        </li> 
                        </shiro:hasPermission>
                        <shiro:hasPermission name="resources:*">
                        <li>
                            <a href="javascript:void(0)" id="information"><i class="fa fa-dashboard fa-fw"></i> 资源总览</a>
                        </li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="analysis:*">
                        <li>
                            <a href="javascript:void(0)" id="data_analysis"><i class="fa fa-bar-chart-o fa-fw"></i> 数据分析</a>
                        </li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="power:*">
                        <li>
                            <a href="javascript:void(0)" id="role_manager"><i class="fa fa-dashboard fa-fw"></i> 角色管理</a>
                        </li>
                        </shiro:hasPermission>
           				<shiro:hasPermission name="history:*">
           				<li>
                            <a href="javascript:void(0)" id="history"><i class="fa fa-sitemap fa-fw"></i> 历史事件查询</a>
                        </li>  
           				</shiro:hasPermission>
                    </ul>
                </div>
            </div>
            <!--左边导航栏结束-->
        </nav>
        <!--导航栏结束-->
        <!--内容部分-->
        <div id="page-wrapper" class="bgchange1"></div>
        <!--内容部分结束-->
        <!--尾部-->
        <div class="footer">
            <div class="footer_content">
                <p>
                    &nbsp;&copy;2018-2018 AUTHOR：<a href="#">J153二组</a>
                </p>
                <p>
                    组长：<a href="#">路昊</a><span>|</span>
                    资料管理：<a href="#">柯强林</a><span>|</span>
                    灾情防治：<a href="#">路昊</a><span>|</span>
                    专家会商：<a href="#">赵子墨</a><span>|</span>
                    药剂器械出库管理：<a href="#">伍宸汉</a><span>|</span>
                    系统信息：<a href="#">陈韵蕊</a><span>|</span>
                </p>
                <p>
                    蜀ICP备8888-6666号-1<span>|</span>
                    增值电信业务经营许可证蜀C-20180302<span>|</span>
                    蜀公网安备 86861234567号
                </p>
            </div>
        </div>
          <!-- 提醒弹出框  -->
	    <div class="modal fade" id="myModal_alert2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog" style="width:300px;">
		    <div class="modal-content">
		      <div class="modal-body">
		        <p class="text-center"><strong></strong></p>
		      </div>
		      <div class="modal-footer">
		      	<button type="button" class="btn btn-default btn-" data-dismiss="modal" id="jump-btn">跳转</button>
		        <button type="button" class="btn btn-default btn-" data-dismiss="modal">关闭</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div>
    </div>
<script src="js/sockjs.min.js"></script>
<script src="js/stomp.min.js"></script>
<!-- jQuery -->
<script src="js/jQuery-2.2.2-min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="js/metisMenu.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="js/sb-admin-2.js"></script>

<script src="js/group2-commoms.js"></script>

<script src="js/jquery.hotkeys.js"></script>
<script src="js/bootstrap-wysiwyg.js"></script>

<script src="js/echarts.js"></script>

<script>
	//提示权限不足的tooltips
	$(function () { $("[data-toggle='tooltip']").tooltip(); });
    var content = $("#page-wrapper");
    content.load("jsp/dis_report.jsp");
  	//事件调度
    $("#dis_report").click(function(){
        content.load("jsp/dis_report.jsp");
    });
    //角色管理
    $("#role_manager").click(function(){
        content.load("jsp/role_manager.jsp");
    });
    //预案管理
    $("#eme_planning").click(function(){
        content.load("jsp/eme_planning.jsp");
    });
    //历史事件
    $("#history").click(function(){
        content.load("jsp/history.jsp");
    });
    //资源管理
    $("#information").click(function(){
        content.load("jsp/information.jsp");
    });
    //数据分析
    $("#data_analysis").click(function(){
    	content.load("jsp/data_analysis.jsp");
    })
    //退出
    function login_out(){
    	window.location.href="user/logout";
    }
    
    function refresh() {
		$.ajax({
			url:"reload",
		});
	}
    
    $("#jump-btn").click(function () {
    	content.load("jsp/dis_report.jsp");
	});
    
	var ws = $(function() {
		ws = new WebSocket("ws://192.168.1.156:8080/ZHDDXT/dunHandler");
		ws.onopen = function() {
			console.info("已经链接");
		}
		ws.onclose = function() {
			console.log("onclose");
		}
		ws.onmessage = function(msg) {
			$(".modal").modal('hide');
			alertAiv($("#myModal_alert2"), "有新事件，是否跳转到突发事件列表");
		}
	});
</script>
</body>

</html>
