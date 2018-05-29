<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>历史事件</title>
<style type="text/css">
	#myModal span{  line-height:35px;  }
	#myModal p{  line-height:35px;  }
</style>
</head>
<body>
    <div class="container-fluid" id="wrap">
        <div class="row">
            <h2 class="text-center">历史事件</h2>
            <div class="table-responsive col-md-12">
                <nav class="navbar navbar-default" id="query" role="navigation">
                    <div class="navbar-header col-md-2"><span class="navbar-brand">按照历史事件查询</span></div>
                    <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <label>事件类型 </label>
                                <select id="his_select_type" class="form-control" name="rhType">
									<option value="">请选择</option>
									<c:forEach items="${DataMap.SJLX }" var="type">
										<option value="${type.key }">${type.value }</option>
									</c:forEach>
		                        </select>
		                        <label>事件等级 </label>
		                        <select id="his_select_grade" class="form-control" name="rhGrade">
									<option value="">请选择</option>
									<c:forEach items="${DataMap.SJDJ }" var="grade">
										<option value="${grade.key }">${grade.value }</option>
									</c:forEach>
		                        </select>
                                <label>事件区域 </label>
                                <select id="his_select_region" class="form-control" name="rhAddress">
									<option value="">请选择</option>
									<c:forEach items="${DataMap.DQ }" var="region">
										<option value="${region.key }">${region.value }</option>
									</c:forEach>
		                        </select>
                            </div>
                            <button type="button" class="btn btn-default" id="query-btn">查询</button>
                        </form>
                    </div>
                </nav>
                <table class="table table-bordered table-hover table-striped" id="my_table">
                    <thead>
                    <tr>
                    	<th>事件名称</th>
                        <th>事件区域</th>
                        <th>事件类型</th>
                        <th>事件等级</th>
                        <th>调度人员姓名</th>
                        <th>调度人员电话</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
        <div class="row">
	        <div class="col-sm-6">
	            <div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">
	                <button type="button" class="btn btn-default" id="add_role">详细信息</button>
	            </div>
	        </div>
	        <div class="col-xm-6 col-md-6 col-sm-6 text-right pull-right">
	        	<!-- 分页开始 -->
				<nav class="text-center">
				 	<ul class="pagination" id="page_nav"></ul>
				</nav>
				<!-- 分页结束 -->
	        </div>
	    </div>
        
        <div class="row">
        <!-- 模态框 -->
            <div class="col-xs-6 col-md-6">
            	<!-- 添加角色 -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="width: 700px">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">事件详情</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                    	<div class="form-group div1 col-md-6">
                                    		<label class="col-sm-6 col-xs-3 control-label">事件名称:</label>
                                    		<span id="find_his_name"></span>
                                    		<br/><br/>
                                    		<label class="col-sm-6 col-xs-3 control-label">发生地区:</label>
                                    		<span id="find_his_region"></span>
                                    		<br/><br/>
                                    		<label class="col-sm-6 col-xs-3 control-label">详细地址:</label>
                                    		<span id="find_his_address"></span>
                                    		<br/><br/>
                                    		<label class="col-sm-6 col-xs-3 control-label">事件类型:</label>
                                    		<span id="find_his_type"></span>
                                    		<br/><br/>
                                    		<label class="col-sm-6 col-xs-3 control-label">事件等级:</label>
                                    		<span id="find_his_grade"></span>
                                    		<br/><br/>
                                    		<label class="col-sm-6 col-xs-3 control-label">上报时间:</label>
                                    		<span id="find_his_startDate"></span>
                                    		<br/><br/>
                                    		<label class="col-sm-6 col-xs-3 control-label">结束时间:</label>
                                    		<span id="find_his_endDate"></span>
                                    		<br/><br/>
                                    		<label class="col-sm-6 col-xs-3 control-label">上报人:</label>
                                    		<span id="find_his_rreporter"></span>
                                    		<br/><br/>
                                    		<label class="col-sm-6 col-xs-3 control-label">上报人电话:</label>
                                    		<span id="find_his_rreportTel"></span>
                                    		<br/><br/>
                                    		<label class="col-sm-6 col-xs-3 control-label">损失:</label>
                                    		<span id="find_his_rinitialLoss"></span>
                                    		<br/><br/>
                                    		<label class="col-sm-6 col-xs-3 control-label">伤亡人数:</label>
                                    		<span id="find_his_rinitialCasualties"></span>
                                    		<br/><br/>
                                    		<label class="col-sm-6 col-xs-3 control-label">灾情面积:</label>
                                    		<span id="find_his_rarea"></span>
                                    	</div>
                                    	<div class="form-group div2 col-md-6">
                                    		<label class="col-sm-4 col-xs-3 control-label">事件照片:</label>
                                    		<img src="" style="width: 200px;height: 230px;padding-left: 30px" id="find_his_img"/>
                                    		<br/><br/><br/><br/>
                                    		<label class="col-sm-4 col-xs-3 control-label">事件描述:</label>
                                    		<br/><br/>
                                    		<p id="find_his_rdesc" style="padding-left: 30px"></p>
                                    	</div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
    <input type="hidden" id="hid" value="0"/> 
    <script type="text/javascript">
    var total_page = 0;
	var page_no = 1;
    //显示所有员工分页信息
	/* function show_list(pageNo){
		$.ajax({
			date:{"pageNo":1},
			url:"/ZHDDXT/roleManager",
			success:function(msg){
				json_to_table(msg,"my_table",["userId","userRname","userGender","userName","userTel","userAddress"]);
				$("#hid").val("0");
			}
		});
	} */
	var updateTable = initTable(function (pageNo) {
		$.ajax({
			method:"post",
			url:"history/listpage.do",
			data:{pageNo:pageNo,rhType:$("#his_select_type").val(),rhGrade:$("#his_select_grade").val(),rhRegion:$("#his_select_region").val()},
			success:function(msg){
				init({
					"value":msg,
					"data":{id:"rhId", name:"rhName", region:"rhRegion", type:"rhType", grade:"rhGrade",RReporter:"rreporter",RReportTel:"rreportTel" },
					"func":updateTable
				});
			}
		});
	});
	//查看历史事件详情
	$("#add_role").click(function(){
		if($("#hid").val()==""){
			alertAiv($("#myModal_alert"), "请选择要查询的事件");
			return;
		}
		$.ajax({
			method:"post",
			url:"history/findById.do",
			data:{rhId:$("#hid").val()},
			success:function(msg){
				$("#find_his_name").html(msg.rhName);
				$("#find_his_region").html(msg.rhRegion);
				$("#find_his_address").html(msg.rhAddress);
				$("#find_his_type").html(msg.rhType);
				$("#find_his_grade").html(msg.rhGrade);
				$("#find_his_startDate").html(msg.rhStartDate);
				$("#find_his_endDate").html(msg.rhEndDate);
				$("#find_his_rreporter").html(msg.rreporter);
				$("#find_his_rreportTel").html(msg.rreportTel);
				$("#find_his_rinitialLoss").html(msg.rinitialLoss);
				$("#find_his_rinitialCasualties").html(msg.rinitialCasualties);
				$("#find_his_rarea").html(msg.rarea);
				$("#find_his_img").prop("src","http://192.168.1.67:8080/img/"+msg.rimage);
				$("#find_his_rdesc").html(msg.rdesc);
				$("#myModal").modal();
			}
		});
	});
	//模糊查询
	$("#query-btn").click(function(){
		updateTable(page_no);
	});
    </script>
</body>
</html>