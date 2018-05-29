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
<title>资源管理</title>
</head>
<body>
    <div class="container-fluid" id="wrap">
        <div class="row">
            <h2 class="text-center">资源管理</h2>
            <div class="table-responsive col-md-12">
                <nav class="navbar navbar-default" id="query" role="navigation">
                    <div class="navbar-header col-md-2"><span class="navbar-brand">按照资源查询</span></div>
                    <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <label>资源类型 </label>
                                <select id="inf_select_type" class="form-control" name="resType">
									<option value="">请选择</option>
									<c:forEach items="${DataMap.ZYLX }" var="type">
										<option value="${type.key }">${type.value }</option>
									</c:forEach>
		                        </select>
		                        <label>资源区域 </label>
                                <select id="inf_select_Region" class="form-control" name="resRegion">
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
                        <th>资源名称</th>
                        <th>资源类型</th>
                        <th>资源区域</th>
                        <th>负责人姓名</th>
                        <th>负责人电话</th>
                        <th>组织机构代码</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
        <div class="row">
	        <div class="col-sm-6">
	            <div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">
	                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" id="add_role">导入资源</button>
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
            	<!-- 导入资源 -->
                <div class="modal fade small_font" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">导入资源</h4>
                            </div>
                            <form action="information/uploadInformation" method="post" enctype="multipart/form-data" class="form-horizontal" role="form" id="add_dlog_form">
	                            <div class="modal-body">
	                                <div class="row">
	                                    <div class="col-sm-12" align="center">
	                                    	<input type="file" class="btn btn-default" id="xls" name="xlsFile"/>
	                                    </div>
	                                </div>
	                            </div>
	                            <div class="modal-footer">
	                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
	                                <button type="submit" class="btn btn-primary add-btn" id="add_dlog_submit">确认导入</button>
	                            </div>
                            </form>
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
	var updateTable = initTable(function (pageNo) {
		$.ajax({
			method:"post",
			url:"information/listpage.do",
			data:{pageNo:pageNo,resType:$("#inf_select_type").val(),resRegion:$("#inf_select_Region").val()},
			success:function(msg){
				init({
					"value":msg,
					"data":{id:"resId", resName:"resName", resType:"resType", resRegion:"resRegion", resPerson:"resPerson", resTel:"resTel", resCode:"resCode"},
					"func":updateTable
				});
			}
		});
	});
	//模糊查询
	$("#query-btn").click(function(){
		updateTable(page_no);
	});
	/* 上传文件 */
	$("#add_dlog_form").submit(function() {
		if(!checkXls($("#xls").val(),$("#myModal_alert"))) {
    		return false;
    	}
		var form = this;
		var formData = new FormData(form);
		$.ajax({
			url:this.action,
			method:"post",
			data:formData,
			dataType:"JSON",
			processData:false,
			contentType:false,
			success:function(value) {
				checkSuccess(value, $("#myModal_alert"), "上传", $("#myModal"));
				updateTable(1);
			}
		});
		return false;
	});
    </script>
</body>
</html>