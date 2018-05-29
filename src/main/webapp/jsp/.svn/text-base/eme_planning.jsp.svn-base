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
<title>预案管理</title>
<style type="text/css">
	#myModal3 span,#myModal3 p,#myModal2 span,#myModal2 p{  line-height:35px;  }
	.container .btn{  padding: 4px 12px; border: 1px solid #bbb;  }
	.container .btn-toolbar{  margin-bottom: 0; margin-top: 10px;  }
</style>
</head>
<body>
    <div class="container-fluid" id="wrap">
        <div class="row">
            <h2 class="text-center">预案管理</h2>
            <div class="table-responsive col-md-12">
                <nav class="navbar navbar-default" id="query" role="navigation">
                    <div class="navbar-header col-md-2"><span class="navbar-brand">按照预案查询</span></div>
                    <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <label>预案类型 </label>
                                <select id="plan_select_type" class="form-control" name="planType">
									<option value="">请选择</option>
									<c:forEach items="${DataMap.SJLX }" var="type">
										<option value="${type.key }">${type.value }</option>
									</c:forEach>
		                        </select>
		                        <label>预案等级 </label>
                                <select id="plan_select_grade" class="form-control" name="planGrade">
									<option value="">请选择</option>
									<c:forEach items="${DataMap.SJDJ }" var="grade">
										<option value="${grade.key }">${grade.value }</option>
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
                        <th>预案名称</th>
                        <th>预案类型</th>
                        <th>预案等级</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
        <div class="row">
	        <div class="col-sm-6">
	            <div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">
	                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" id="add_plan">添加预案</button>
	                <button type="button" class="btn btn-default" id="del_btn">删除预案</button>
	                <button type="button" class="btn btn-default" id="update_plan">修改预案</button>
	                <button type="button" class="btn btn-default" id="find_plan">查看详情</button>
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
            <div class="col-xs-6 col-md-6" id="sample">
            	<!-- 添加预案 -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">添加预案</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-10">
                                            <div class="form-group div1">
                                                <label for="add_role_name" class="col-sm-3 col-xs-3 control-label">预案名称</label>
                                                <div>
                                                    <input type="text" style="width: 350px" class="form-control" id="add_plan_name" placeholder="请输入" name="not-none-check">
                                                </div>
                                            </div>
                                           	<div class="form-group div2">
                                            <div class="col-md-6">
                                                <label for="add_role_desc" class="col-sm-6 col-xs-3 control-label">预案类型</label>
                                                <div>
													<select name="planType" id="add_plan_type" class="form-control" style="width: 100px">
                                                        <option value="">请选择</option>
                                                        <c:forEach items="${DataMap.SJLX }" var="type">
															<option value="${type.key }">${type.value }</option>
														</c:forEach>
                                                    </select>                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <label for="add_role_desc" class="col-sm-6 col-xs-3 control-label">预案等级</label>
                                                <div>
													<select name="planGrade" id="add_plan_grade" class="form-control" style="width: 100px">
                                                        <option value="">请选择</option>
                                                        <c:forEach items="${DataMap.SJDJ }" var="grade">
															<option value="${grade.key }">${grade.value }</option>
														</c:forEach>
                                                    </select>                                                </div>
                                            </div>
                                            </div>
                                            <div class="form-group div3 row">
                                            	<div class="col-md-6">
                                                <label for="add_role_name" class="col-sm-6 col-xs-3 control-label">推荐人数</label>
                                                <div>
                                                    <input type="text" style="width: 100px" class="form-control" id="add_plan_peopleNum" placeholder="请输入" name="not-none-check">
                                                </div>
                                                </div>
                                                <div class="col-md-6">
                                                <label for="add_role_name" class="col-sm-6 col-xs-3 control-label">推荐车数</label>
                                                <div>
                                                    <input type="text" style="width: 100px" class="form-control" id="add_plan_carNum" placeholder="请输入" name="not-none-check">
                                                </div>
                                                </div>
                                            </div>
                                            <div class="form-group div4">
                                                <label for="add_role_powers" class="col-sm-3 col-xs-3 control-label">预案内容</label><br/>
                                                <div class="row" style="margin-left: 35px">
                                                <div class="container" style="width: 450px;">
												    <div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor2">
												      <div class="btn-group" style="margin-left: 5px">
												        <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font"><i class="icon-font"></i><b class="caret"></b></a>
												          <ul class="dropdown-menu">
												          </ul>
												        </div>
												      <div class="btn-group">
												        <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font Size"><i class="icon-text-height"></i>&nbsp;<b class="caret"></b></a>
												          <ul class="dropdown-menu">
												          <li><a data-edit="fontSize 5"><font size="5">Huge</font></a></li>
												          <li><a data-edit="fontSize 3"><font size="3">Normal</font></a></li>
												          <li><a data-edit="fontSize 1"><font size="1">Small</font></a></li>
												          </ul>
												      </div>
												      <div class="btn-group">
												        <a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)"><i class="icon-bold"></i></a>
												        <a class="btn" data-edit="italic" title="Italic (Ctrl/Cmd+I)"><i class="icon-italic"></i></a>
												        <a class="btn" data-edit="strikethrough" title="Strikethrough"><i class="icon-strikethrough"></i></a>
												        <a class="btn" data-edit="underline" title="Underline (Ctrl/Cmd+U)"><i class="icon-underline"></i></a>
												      </div>
												      <div class="btn-group">
												        <a class="btn" data-edit="insertunorderedlist" title="Bullet list"><i class="icon-list-ul"></i></a>
												        <a class="btn" data-edit="insertorderedlist" title="Number list"><i class="icon-list-ol"></i></a>
												        <a class="btn" data-edit="outdent" title="Reduce indent (Shift+Tab)"><i class="icon-indent-left"></i></a>
												        <a class="btn" data-edit="indent" title="Indent (Tab)"><i class="icon-indent-right"></i></a>
												      </div>
												      <div class="btn-group">
												        <a class="btn" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)"><i class="icon-align-left"></i></a>
												        <a class="btn" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"><i class="icon-align-center"></i></a>
												        <a class="btn" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"><i class="icon-align-right"></i></a>
												        <a class="btn" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i class="icon-align-justify"></i></a>
												      </div>
												      <div class="btn-group">
												        <a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)"><i class="icon-undo"></i></a>
												        <a class="btn" data-edit="redo" title="Redo (Ctrl/Cmd+Y)"><i class="icon-repeat"></i></a>
												      </div>
												    </div>
												    <div id="editor" class="editor2" style="height: 100px;"></div>
												</div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary add-btn" id="add_dlog_submit">确认添加</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 查看详情 -->
                <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">详细信息</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-10">
                                            <div class="form-group div1">
                                                <label for="add_role_name" class="col-sm-3 col-xs-3 control-label">预案名称</label>
                                                <span id="find_plan_name"></span>
                                            </div>
                                           	<div class="form-group div2">
                                            <div class="col-md-6">
                                                <label for="add_role_desc" class="col-sm-6 col-xs-3 control-label">预案类型</label>
                                                <span id="find_plan_type"></span>
                                            </div>
                                            <div class="col-md-6">
                                                <label for="add_role_desc" class="col-sm-6 col-xs-3 control-label">预案等级</label>
                                                <span id="find_plan_grade"></span>
                                            </div>
                                            </div>
                                            <div class="form-group div3 row">
                                            	<div class="col-md-6">
                                                <label for="add_role_name" class="col-sm-6 col-xs-3 control-label">推荐人数</label>
                                                <span id="find_plan_peoplenum"></span>
                                                </div>
                                                <div class="col-md-6">
                                                <label for="add_role_name" class="col-sm-6 col-xs-3 control-label">推荐车数</label>
                                                <span id="find_plan_carnum"></span>
                                                </div>
                                            </div>
                                            <div class="form-group div4">
                                                <label for="add_role_powers" class="col-sm-3 col-xs-3 control-label">预案内容</label>
                                                <p id="fing_plan_describe"></p>
                                            </div>
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
                <!-- 修改预案 -->
                <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="width: 600px">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">修改预案</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-10">
                                            <div class="form-group div1">
                                                <label for="add_role_name" class="col-sm-3 col-xs-3 control-label">预案名称</label>
                                                <span id="upd_plan_name"></span>
                                                <!-- <div>
                                                    <input type="text" value="火灾应急调度预案" disabled="disabled" style="width: 350px" class="form-control" id="add_plan_name" placeholder="请输入" name="not-none-check">
                                                </div> -->
                                            </div>
                                           	<div class="form-group div2">
                                            <div class="col-md-6">
                                                <label for="add_role_desc" class="col-sm-6 col-xs-3 control-label">预案类型</label>
                                                <span id="upd_plan_type"></span>
                                                <%-- <div>
													<select name="planType" id="add_role_powers" class="form-control" style="width: 100px">
                                                        <option value="0">请选择</option>
                                                        <c:forEach items="${DataMap.SJLX }" var="type">
															<option value="${type.key }">${type.value }</option>
														</c:forEach>
                                                    </select>                                                
                                               </div> --%>
                                            </div>
                                            <div class="col-md-6">
                                                <label for="add_role_desc" class="col-sm-6 col-xs-3 control-label">预案等级</label>
                                                <div>
													<select name="planGrade" id="upd_plan_grade" class="form-control" style="width: 100px">
                                                        <option value="">请选择</option>
                                                        <c:forEach items="${DataMap.SJDJ }" var="grade">
															<option value="${grade.key }">${grade.value }</option>
														</c:forEach>
                                                    </select>                                                
                                                </div>
                                            </div>
                                            </div>
                                            <div class="form-group div3 row">
                                            	<div class="col-md-6">
                                                <label for="add_role_name" class="col-sm-6 col-xs-3 control-label">推荐人数</label>
                                                <div>
                                                    <input type="text" style="width: 100px" class="form-control" id="upd_plan_peoplenum" placeholder="请输入" name="not-none-check">
                                                </div>
                                                </div>
                                                <div class="col-md-6">
                                                <label for="add_role_name" class="col-sm-6 col-xs-3 control-label">推荐车数</label>
                                                <div>
                                                    <input type="text" style="width: 100px" class="form-control" id="upd_plan_carnum" placeholder="请输入" name="not-none-check">
                                                </div>
                                                </div>
                                            </div>
                                            <div class="form-group div4" >
                                                <label for="add_role_powers" class="col-sm-3 col-xs-3 control-label">预案内容</label><br/>
                                                <div class="row" style="margin-left: 35px">
                                                <div class="container" style="width: 450px;">
												    <div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor">
												      <div class="btn-group" style="margin-left: 5px">
												        <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font"><i class="icon-font"></i><b class="caret"></b></a>
												          <ul class="dropdown-menu">
												          </ul>
												        </div>
												      <div class="btn-group">
												        <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font Size"><i class="icon-text-height"></i>&nbsp;<b class="caret"></b></a>
												          <ul class="dropdown-menu">
												          <li><a data-edit="fontSize 5"><font size="5">Huge</font></a></li>
												          <li><a data-edit="fontSize 3"><font size="3">Normal</font></a></li>
												          <li><a data-edit="fontSize 1"><font size="1">Small</font></a></li>
												          </ul>
												      </div>
												      <div class="btn-group">
												        <a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)"><i class="icon-bold"></i></a>
												        <a class="btn" data-edit="italic" title="Italic (Ctrl/Cmd+I)"><i class="icon-italic"></i></a>
												        <a class="btn" data-edit="strikethrough" title="Strikethrough"><i class="icon-strikethrough"></i></a>
												        <a class="btn" data-edit="underline" title="Underline (Ctrl/Cmd+U)"><i class="icon-underline"></i></a>
												      </div>
												      <div class="btn-group">
												        <a class="btn" data-edit="insertunorderedlist" title="Bullet list"><i class="icon-list-ul"></i></a>
												        <a class="btn" data-edit="insertorderedlist" title="Number list"><i class="icon-list-ol"></i></a>
												        <a class="btn" data-edit="outdent" title="Reduce indent (Shift+Tab)"><i class="icon-indent-left"></i></a>
												        <a class="btn" data-edit="indent" title="Indent (Tab)"><i class="icon-indent-right"></i></a>
												      </div>
												      <div class="btn-group">
												        <a class="btn" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)"><i class="icon-align-left"></i></a>
												        <a class="btn" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"><i class="icon-align-center"></i></a>
												        <a class="btn" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"><i class="icon-align-right"></i></a>
												        <a class="btn" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i class="icon-align-justify"></i></a>
												      </div>
												      <div class="btn-group">
												        <a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)"><i class="icon-undo"></i></a>
												        <a class="btn" data-edit="redo" title="Redo (Ctrl/Cmd+Y)"><i class="icon-repeat"></i></a>
												      </div>
												    </div>
												    <div id="editor" class="editor" style="height: 100px;"></div>
												</div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary add-btn" id="upd_dlog_submit">确认修改</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 结束事件 -->
                <div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="width: 350px">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">删除预案</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <p class="text-center"><strong>！确认结束当前预案吗</strong></p>
                                </div>
                            </div>
                            <div class="modal-footer">
                            	<button type="button" class="btn btn-default close-btn" id="del_plan">确认</button>
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
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div>
    </div>
    
    <input type="hidden" id="hid" value="0"/> 
    <script type="text/javascript">
    var total_page = 0;
	var page_no = 1; 
	var page_size = 5;
	var updateTable = initTable(function (pageNo) {
		$.ajax({
			method:"post",
			url:"planning/listpage.do",
			data:{pageNo:pageNo,pageSize:page_size,planType:$("#plan_select_type").val(),planGrade:$("#plan_select_grade").val()},
			success:function(msg){
				init({
					"value":msg,
					"data":{id:"planId",planName:"planName" ,planType:"planType", planGrade:"planGrade"},
					"func":updateTable
				});
			}
		});
	});
	//添加预案
	 $("#add_dlog_submit").click(function(){
		 var boo = true;
		 $("#myModal input").each(function (i,obj) {
			 if($(this).val()=="") {
				 boo = false;
				 return false;
			 }
		});
		 $("#myModal select").each(function (i,obj) {
			 if($(this).val()==""||$(this).val()=="0") {
				 boo = false;
				 return false;
			 }
		});
		 if(!boo) {  
			 alertAiv($("#myModal_alert"), "输入框和下拉栏值不能为空！"); 
			 return;
		}
		$.ajax({
			method:"post",
			url:"planning/add.do",
			data:{planName:$("#add_plan_name").val(),
				planType:$("#add_plan_type").val(),
				planGrade:$("#add_plan_grade").val(),
				planDescribe:$(".editor2").html(),
				planPeopleNum:$("#add_plan_peopleNum").val(),
				planCarNum:$("#add_plan_carNum").val(),
			},
			success:function(msg){
				checkSuccess(msg, $("#myModal_alert"), "添加", $("#myModal"));
				updateTable(total_page);
			}
		})
	}); 
	//修改预案
	  $("#update_plan").click(function(){
		  if($("#hid").val()==""){
				alertAiv($("#myModal_alert"), "请选择要修改的预案");
				return;
			}
		$.ajax({
			method:"post",
			url:"planning/findById.do",
			data:{planId:$("#hid").val()},
			success:function(msg){
				$("#upd_plan_name").html(msg.planName);
				$("#upd_plan_type").html(msg.planType);
				var grade = "";
				for (var i = 0; i < $("#upd_plan_grade option").length; i++) {
					if($("#upd_plan_grade option").eq(i).html() == msg.planGrade) {
						grade = $("#upd_plan_grade option").eq(i).val();
					}
				}
				$("#upd_plan_grade").val(grade);
				$("#upd_plan_peoplenum").val(msg.planPeopleNum);
				$("#upd_plan_carnum").val(msg.planCarNum);
				$(".editor").html(msg.planDescribe);
				$("#myModal2").modal();
			}
		})
	});  
	
	  $("#upd_dlog_submit").click(function(){
		  var boo = true;
			 $("#myModal2 input").each(function (i,obj) {
				 if($(this).val()=="") {
					 boo = false;
					 return false;
				 }
			});
			 $("#myModal2 select").each(function (i,obj) {
				 if($(this).val()==""||$(this).val()=="0") {
					 boo = false;
					 return false;
				 }
			});
			 if(!boo) {  
				 alertAiv($("#myModal_alert"), "输入框和下拉栏值不能为空！"); 
				 return;
			}
		$.ajax({
			method:"post",
			url:"planning/update.do",
			data:{
				planId:$("#hid").val(),
				planGrade:$("#upd_plan_grade").val(),
				planDescribe:$(".editor").html(),
				planPeopleNum:$("#upd_plan_peoplenum").val(),
				planCarNum:$("#upd_plan_carnum").val(),
			},
			success:function(msg){
				checkSuccess(msg, $("#myModal_alert"), "修改", $("#myModal2"));
				updateTable(page_no);
			}
		})
	});  
	  $("#del_btn").click(function () {
		  if($("#hid").val()==""){
				alertAiv($("#myModal_alert"), "请选择要删除的预案");
				return;
		}
		  $("#myModal4").modal();
	});
	  
	 $("#del_plan").click(function(){
		$.ajax({
			method:"post",
			url:"planning/del.do",
			data:{planId:$("#hid").val()},
			success:function(msg){
				updateTable(page_no);
				checkSuccess(msg, $("#myModal_alert"), "删除", $("#myModal4"));
			}
	}) 
});
	//查看详情
	 $("#find_plan").click(function(){
		 if($("#hid").val()==""){
				alertAiv($("#myModal_alert"), "请选择要查看的预案");
				return;
			}
		$.ajax({
			method:"post",
			url:"planning/findById.do",
			data:{planId:$("#hid").val()},
			success:function(msg){
				$("#find_plan_name").html(msg.planName);
				$("#find_plan_type").html(msg.planType);
				$("#find_plan_grade").html(msg.planGrade);
				$("#find_plan_peoplenum").html(msg.planPeopleNum);
				$("#find_plan_carnum").html(msg.planCarNum);
				$("#fing_plan_describe").html(msg.planDescribe);
				$("#myModal3").modal();
			}
			})
	}); 
	//模糊查询
	$("#query-btn").click(function(){
		updateTable(page_no);
	});
	/* 文本域 */
	$(function(){
	    function initToolbarBootstrapBindings() {
	      var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier', 
	            'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
	            'Times New Roman', 'Verdana'],
	            fontTarget = $('[title=Font]').siblings('.dropdown-menu');
	      $.each(fonts, function (idx, fontName) {
	          fontTarget.append($('<li><a data-edit="fontName ' + fontName +'" style="font-family:\''+ fontName +'\'">'+fontName + '</a></li>'));
	      });
	      $('a[title]').tooltip({container:'body'});
	    	$('.dropdown-menu input').click(function() {return false;})
			    .change(function () {$(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');})
	        .keydown('esc', function () {this.value='';$(this).change();});

	      $('[data-role=magic-overlay]').each(function () { 
	        var overlay = $(this), target = $(overlay.data('target')); 
	        overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
	      });
	      $('#voiceBtn').hide();
	    };
	    initToolbarBootstrapBindings();  
	    $('#editor').wysiwyg();
	    window.prettyPrint && prettyPrint();
	  });
	</script> 
</body>
</html>