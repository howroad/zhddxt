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
<title>突发事件列表</title>
<style type="text/css">
	#myModal7_2 span,#myModal7_3 span,#myModal7_2 p,#myModal7_3 p{  line-height:35px;  }
	#tbody6 input{  height: 23px;  }
	#tbody6 span{  line-height:0;  }
	#table6{  width: 450px;margin-left: auto;margin-right: auto  }
	#table6 .input-group{  width: 100px;  }
</style>
</head>
<body>
    <div class="container-fluid" id="wrap">
        <div class="row">
            <h2 class="text-center">突发事件列表</h2>
            <div class="table-responsive col-md-12">
                <nav class="navbar navbar-default" id="query" role="navigation">
                    <div class="navbar-header col-md-2"><span class="navbar-brand">事件查询</span></div>
                    <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <label> 发生地区：</label>
                                <select id="r_region" class="form-control">
                                	<option value="">请选择</option>
	                                <c:forEach items="${DataMap.DQ }" var="item">
	                                	<option value="${item.key }">${item.value }</option>
	                                </c:forEach>
		                        </select>
		                        <label> 事件等级：</label>
                                <select id="r_grade" class="form-control">
									<option value="">请选择</option>
	                                <c:forEach items="${DataMap.SJDJ }" var="item">
	                                	<option value="${item.key }">${item.value }</option>
	                                </c:forEach>
		                        </select>
		                        <label> 事件类型：</label>
                                <select id="r_type" class="form-control">
									<option value="">请选择</option>
	                                <c:forEach items="${DataMap.SJLX }" var="item">
	                                	<option value="${item.key }">${item.value }</option>
	                                </c:forEach>
		                        </select>
                            </div>
                            <button type="button" class="btn btn-default" id="query-btn">查询</button>
                        </form>
                    </div>
                </nav>
                <div class="row">
	                <div class="btn-group btn-group-justified col-sm-12 choose_report">
					    <a href="javascript:void(0)" class="btn btn-primary" onclick="ck(1)" id="one_btn">未调度事件</a>
					    <a href="javascript:void(0)" class="btn btn-primary" onclick="ck(2)" id="two_btn">进行中事件</a>
			        </div>
                </div>
                <input type="hidden" id="hid" value="0"/> 
                <table class="table table-bordered table-hover table-striped">
                    <thead>
                    <tr>
                        <th>事件编号</th>
                        <th>事件名称</th>
                        <th>发生区域</th>
                        <th>事件等级</th>
                        <th>事件类型</th>
                        <th>发生时间</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
        <div class="row">
        	<!-- 模态框按钮位置 -->
	        <div class="col-sm-6">
	            <div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite"></div>
	        </div>
	    </div>
        
        <div class="row">
        <!-- 模态框 -->
            <div class="col-xs-6 col-md-6">
                <!-- 查看事件详情 -->
                <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="width: 700px">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">查看事件详情</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-sm-6">
		                                <label>事件编号：</label>
		                                <span class="report_code"></span>
		                                <br/><br/>
		                                <label>事件名称：</label>
		                                <span class="report_name"></span>
		                                <br/><br/>
		                                <label>发生地区：</label>
		                                <span class="report_region"></span>
		                                <br/><br/>
		                                <label>详细地址：</label>
		                                <span class="report_address"></span>
		                                <br/><br/>
		                                <label>事件等级：</label>
		                                <span class="report_grade"></span>
		                                <br/><br/>
		                                <label>事件类型：</label>
		                                <span class="report_type"></span>
		                                <br/><br/>
		                                <label>初步损失：</label>
		                                <span class="report_initialloss"></span>
		                                <br/><br/>
		                                <label>伤亡人数：</label>
		                                <span class="report_initialcasualties"></span>
		                                <br/><br/>
		                                <label>受灾面积：</label>
		                                <span class="report_area"></span>
		                            </div>
		                            <div class="col-sm-6">
		                                <img class="report_image" src="" width="200" height="206"/>
		                                <br/><br/><br/><br/>
		                                <label>上报时间：</label>
		                                <span class="report_date"></span>
		                                <br/><br/>
		                                <label>上报人员：</label>
		                                <span class="report_reporter"></span>
		                                <br/><br/>
		                                <label>上报电话：</label>
		                                <span class="report_reporttel"></span>
		                            </div>
		                            <div class="col-sm-12">
		                                <br/><label>事件描述：</label><p/>
		                                <div style="height: 50px">
		                                	<span class="report_desc"></span>
		                                </div>
		                            </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 结束事件 -->
                <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="width: 350px">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">结束事件</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <p class="text-center"><strong>！确认结束当前事件吗</strong></p>
                                </div>
                            </div>
                            <div class="modal-footer">
                            	<button type="button" class="btn btn-default close-btn" id="end_report">确认</button>
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 查看续报 -->
                <div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="width: 700px">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">查看续报</h4>
                            </div>
                            <div class="modal-body">
                            	<div class="row" style="margin-bottom: 20px">
                                    <div class="col-sm-6">
		                                <label>事件编号：</label>
		                                <span class="event_code"></span>
		                            </div>
		                            <div class="col-sm-6">
		                                <label>事件名称：</label>
		                                <span class="event_name"></span>
		                            </div>
                                </div>
                            	<input type="hidden" id="hid2" value="0"/> 
                                <table class="table table-bordered table-hover table-striped">
				                    <thead>
				                    <tr>
				                        <th>续报等级</th>
				                        <th>续报人</th>
				                        <th>续报人电话</th>
				                        <th>续报时间</th>
				                    </tr>
				                    </thead>
				                    <tbody id="tbody2"></tbody>
				                </table>
                            </div>
                            <div class="modal-footer">
                            	<button type="button" class="btn btn-default close-btn" id="renewal_detail">查看续报详情</button>
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 查看续报详情 -->
                <div class="modal fade" id="myModal4_1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="width: 600px">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">查看续报详情</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-sm-6">
		                                <label>续报人员：</label>
		                                <span class="rs_person"></span>
		                                <br/><br/>
		                                <label>续报等级：</label>
		                                <span class="rs_grade"></span>
		                                <br/><br/>
		                                <label>受灾面积：</label>
		                                <span class="rs_area"></span>
		                            </div>
		                            <div class="col-sm-6">
		                                <label>续报电话：</label>
		                                <span class="rs_tel"></span>
		                                <br/><br/>
		                                <label>续报时间：</label>
		                                <span class="rs_date"></span>
		                                <br/><br/>
		                                <label>伤亡人数：</label>
		                                <span class="rs_casualties"></span>
		                            </div>
		                            <div class="col-sm-12">
		                                <br/><label>续报描述：</label><p/>
		                                <div style="height: 50px">
		                                	<span class="rs_desc"></span>
		                                </div>
		                            </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 查看反馈 -->
                <div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="width: 700px">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">查看反馈</h4>
                            </div>
                            <div class="modal-body">
                            	<div class="row" style="margin-bottom: 20px">
                                    <div class="col-sm-6">
		                                <label>事件编号：</label>
		                                <span class="event_code"></span>
		                            </div>
		                            <div class="col-sm-6">
		                                <label>事件名称：</label>
		                                <span class="event_name"></span>
		                            </div>
                                </div>
                            	<input type="hidden" id="hid3" value="0"/> 
                                <table class="table table-bordered table-hover table-striped">
				                    <thead>
				                    <tr>
				                        <th>资源名称</th>
				                        <th>反馈人</th>
				                        <th>反馈人电话</th>
				                        <th>反馈时间</th>
				                    </tr>
				                    </thead>
				                    <tbody id="tbody3"></tbody>
				                </table>
                            </div>
                            <div class="modal-footer">
                            	<button type="button" class="btn btn-default close-btn" id="fb_detail">查看反馈详情</button>
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 查看续报详情 -->
                <div class="modal fade" id="myModal5_1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="width: 600px">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">查看反馈详情</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-sm-6">
		                                <label>资源名称：</label>
		                                <span class="res_name"></span>
		                                <br/><br/>
		                                <label>反馈人员：</label>
		                                <span class="fb_person"></span>
		                            </div>
		                            <div class="col-sm-6">
		                                <label>反馈电话：</label>
		                                <span class="fb_tel"></span>
		                                <br/><br/>
		                                <label>反馈时间：</label>
		                                <span class="fb_date"></span>
		                            </div>
		                            <div class="col-sm-12">
		                                <br/><label>反馈描述：</label><p/>
		                                <div style="height: 50px">
		                                	<span class="fb_details"></span>
		                                </div>
		                            </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 查看调度 -->
                <div class="modal fade" id="myModal6" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="width: 700px">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">查看调度</h4>
                            </div>
                            <div class="modal-body">
                            	<div class="row" style="margin-bottom: 20px">
                                    <div class="col-sm-6">
		                                <label>事件编号：</label>
		                                <span class="event_code"></span>
		                            </div>
		                            <div class="col-sm-6">
		                                <label>事件名称：</label>
		                                <span class="event_name"></span>
		                            </div>
                                </div>
                            	<input type="hidden" id="hid4" value="0"/> 
                                <table class="table table-bordered table-hover table-striped">
				                    <thead>
				                    <tr>
				                        <th>资源名称</th>
				                        <th>调度人员</th>
				                        <th>调度人数</th>
				                        <th>调度车辆</th>
				                        <th>调度时间</th>
				                        <th>调度状态</th>
				                    </tr>
				                    </thead>
				                    <tbody id="tbody4"></tbody>
				                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 选择预案 -->
                <div class="modal fade" id="myModal7" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="width: 800px">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">请选择预案</h4>
                            </div>
                            <div class="modal-body">
                            	<div class="row" style="margin-bottom: 20px">
                                    <div class="col-sm-6">
		                                <label>事件编号：</label>
		                                <span class="event_code"></span>
		                            </div>
		                            <div class="col-sm-6">
		                                <label>事件名称：</label>
		                                <span class="event_name"></span>
		                            </div>
                                </div>
                            	<input type="hidden" id="hid5" value="0"/> 
				                <table class="table table-bordered table-hover table-striped">
				                    <thead>
				                    <tr>
				                        <th>预案名称</th>
				                        <th>预案等级</th>
				                        <th>预案类型</th>
				                        <th>需要人数</th>
				                        <th>需要车辆</th>
				                    </tr>
				                    </thead>
				                    <tbody id="tbody5"></tbody>
				                </table>
                                <div class="row">
							        <div class="col-sm-5">
							            <div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">
							                <button type="button" class="btn btn-default  close-btn" data-dismiss="modal" id="choose_plan">确认预案</button>
							                <button type="button" class="btn btn-default" id="find_plan">查看预案</button>
							            </div>
							        </div>
							        <div class="col-xm-7 col-md-7 col-sm-7 text-right pull-right">
							        	<!-- 分页开始 -->
										<nav class="text-center">
										 	<ul class="pagination" id="page_nav"></ul>
										</nav>
										<!-- 分页结束 -->
							        </div>
							    </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 查看详情 -->
                <div class="modal fade" id="myModal7_2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                                                <label for="find_plan_name" class="col-sm-3 col-xs-3 control-label">预案名称</label>
                                                <span id="find_plan_name"></span>
                                            </div>
                                           	<div class="form-group div2">
                                            <div class="col-md-6">
                                                <label for="find_plan_type" class="col-sm-6 col-xs-3 control-label">预案类型</label>
                                                <span id="find_plan_type"></span>
                                            </div>
                                            <div class="col-md-6">
                                                <label for="find_plan_grade" class="col-sm-6 col-xs-3 control-label">预案等级</label>
                                                <span id="find_plan_grade"></span>
                                            </div>
                                            </div>
                                            <div class="form-group div3 row">
                                            	<div class="col-md-6">
                                                <label for="find_plan_peoplenum" class="col-sm-6 col-xs-3 control-label">推荐人数</label>
                                                <span id="find_plan_peoplenum"></span>
                                                </div>
                                                <div class="col-md-6">
                                                <label for="find_plan_carnum" class="col-sm-6 col-xs-3 control-label">推荐车数</label>
                                                <span id="find_plan_carnum"></span>
                                                </div>
                                            </div>
                                            <div class="form-group div4">
                                                <label for="fing_plan_describe" class="col-sm-3 col-xs-3 control-label">预案内容</label>
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
                <!-- 确认方案 -->
                <div class="modal fade" id="myModal7_3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="width: 600px">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">调度方案</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-10">
                                            <div class="form-group div1">
                                                <label for="show_plan_name" class="col-sm-3 col-xs-3 control-label">预案名称</label>
                                                <span id="show_plan_name"></span>
                                            </div>
                                           	<div class="form-group div2">
                                            <div class="col-md-6">
                                                <label for="show_plan_type" class="col-sm-6 col-xs-3 control-label">预案类型</label>
                                                <span id="show_plan_type"></span>
                                            </div>
                                            <div class="col-md-6">
                                                <label for="show_plan_grade" class="col-sm-6 col-xs-3 control-label">预案等级</label>
                                                <span id="show_plan_grade"></span>
                                            </div>
                                            </div>
                                            <div class="form-group div3 row">
                                            	<div class="col-md-6">
                                                <label for="show_plan_peoplenum" class="col-sm-6 col-xs-3 control-label">推荐人数</label>
                                                <span id="show_plan_peoplenum"></span>
                                                </div>
                                                <div class="col-md-6">
                                                <label for="show_plan_carnum" class="col-sm-6 col-xs-3 control-label">推荐车数</label>
                                                <span id="show_plan_carnum"></span>
                                                </div>
                                            </div>
                                            <div class="form-group div4">
                                                <label class="col-sm-3 col-xs-3 control-label">调度资源</label>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <input type="hidden" id="hid6" value="0"/> 
                                <table class="table table-bordered table-hover table-striped" id="table6">
				                    <thead>
				                    <tr>
				                        <th>资源名称</th>
				                        <th>调度人数</th>
				                        <th>调度车辆</th>
				                        <th>操作</th>
				                    </tr>
				                    </thead>
				                    <tbody id="tbody6">
				                    </tbody>
				                </table>
                            </div>
                            <div class="modal-footer">
                            	<button type="button" class="btn btn-default" id="choose-res">选择资源</button>
                            	<button type="button" class="btn btn-default" id="add-sche">确认调度</button>
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal" id="back-plan">返回</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 选择资源 -->
                <div class="modal fade" id="myModal7_4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" style="width: 700px">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">选择资源</h4>
                            </div>
                            <div class="modal-body">
                            	<form class="navbar-form navbar-right" role="search">
		                            <div class="form-group">
		                                <label> 资源地区：</label>
		                                <select id="res_region" class="form-control">
		                                	<option value="">请选择</option>
			                                <c:forEach items="${DataMap.DQ }" var="item">
			                                	<option value="${item.key }">${item.value }</option>
			                                </c:forEach>
				                        </select>
				                        <label> 资源类型：</label>
		                                <select id="res_type" class="form-control">
											<option value="">请选择</option>
			                                <c:forEach items="${DataMap.ZYLX }" var="item">
			                                	<option value="${item.key }">${item.value }</option>
			                                </c:forEach>
				                        </select>
		                            </div>
		                        </form>
		                        <input type="hidden" id="hid7" value="0"/> 
                                <table class="table table-bordered table-hover table-striped">
				                    <thead id="thead7">
				                    <tr>
				                        <th>资源名称</th>
				                        <th>资源地区</th>
				                        <th>资源类型</th>
				                        <th>负责人</th>
				                        <th>负责人电话</th>
				                    </tr>
				                    </thead>
				                    <tbody id="tbody7">
				                    </tbody>
				                </table>
                            </div>
                            <div class="modal-footer">
                            	<button type="button" class="btn btn-default" id='confirm-res'>确认选择</button>
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal" id="back-plan">返回</button>
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
    <script>
	var r_status = 1;
	$("#one_btn").addClass("active");
	/* 动态生成按钮 */
	function initBtn() {
		if(r_status==1) {
			$("#dataTables-example_info").html("<button type='button' class='btn btn-primary' onclick='eventScheduling()'>事件调度</button>\n"
					+"<button type='button' class='btn btn-primary' onclick='showEvent()'>查看事件</button>\n"
					+"<button type='button' class='btn btn-primary' onclick='showRenewal()'>查看续报</button>\n");
		} else {
			$("#dataTables-example_info").html("<button type='button' class='btn btn-primary' onclick='eventScheduling()'>再次调度</button>\n"
					+"<button type='button' class='btn btn-primary' onclick='showEvent()'>查看事件</button>\n"
					+"<button type='button' class='btn btn-primary' onclick='showRenewal()'>查看续报</button>\n"
	                +"<button type='button' class='btn btn-primary' onclick='showFeedBack()'>查看反馈</button>\n"
	                +"<button type='button' class='btn btn-primary' onclick='showScheduling()'>查看调度</button>\n"
	                +"<button type='button' class='btn btn-primary' onclick='endEvent()'>结束事件</button>\n");
		}
	}
	initBtn();
	/* 更新事件表 */
	var updateTable = initTable(function () {
		$.ajax({
			method:"post",
			url:"report/findAllReports",
			data:{RRegion:$("#r_region").val(), RGrade:$("#r_grade").val(), RType:$("#r_type").val(), RStatus:r_status},
			success:function(msg){
				initList({
					"value":msg,
					"data":{id:"rid", key1:"rcode", key2:"rname", key3:"rregion", key4:"rgrade", key5:"rtype", key6:"rdate"},
					"func":updateTable
				});
			}
		});
	});
	/* 根据事件状态查询 */
	function ck(val) {
		$(".choose_report a").removeClass("active");
		if(val==1) {
			$("#one_btn").addClass("active");
		} else {
			$("#two_btn").addClass("active");
		}
		r_status = val;
		initBtn();
		updateTable();
	}
	/* 模糊查询按钮 */
	$("#query-btn").click(function () {
		updateTable();
	});
	// 弹出查看模态框
	function showEvent() {
		var RId = $("#hid").val();
		if(RId==""){
			alertAiv($("#myModal_alert"), "请选择要查看的事件");
			return;
		}
		// 执行ajax查看
		$.ajax({
			url:"report/findReport",
			data:{"RId":RId},
			success:function(value){
				$(".report_code").html(value.rcode);
				$(".report_name").html(value.rname);
				$(".report_region").html(value.rregion);
				$(".report_address").html(value.raddress);
				$(".report_grade").html(value.rgrade);
				$(".report_type").html(value.rtype);
				$(".report_initialloss").html(value.rinitialLoss);
				$(".report_initialcasualties").html(value.rinitialCasualties);
				$(".report_area").html(value.rarea);
				$(".report_image").prop("src","http://192.168.1.67:8080/img/"+value.rimage);
				$(".report_date").html(value.rdate);
				$(".report_reporter").html(value.rreporter);
				$(".report_reporttel").html(value.rreportTel);
				$(".report_desc").html(value.rdesc);
				$("#myModal2").modal();
			}
		});
	}
	/* 结束事件窗口 */
	function endEvent() {
		var RId = $("#hid").val();
		if(RId==""){
			alertAiv($("#myModal_alert"), "请选择要结束的事件");
			return;
		}
		$("#myModal3").modal();
	}
	/* 结束事件 */
	$("#end_report").click(function () {
		$.ajax({
			url:"report/endReport",
			data:{"RId":$("#hid").val()},
			success:function(value){
				checkSuccess(value, $("#myModal_alert"), "结束事件", $("#myModal3"));
                updateTable();
			}
		});
	});
	/* 查看续报列表 */
	var updateTable2;
	function showRenewal() {
		var RId = $("#hid").val();
		if(RId==""){
			alertAiv($("#myModal_alert"), "请选择要查看的事件");
			return;
		}
		$.ajax({
			url:"report/findReport",
			data:{"RId":RId},
			success:function(value){
				$(".event_code").html(value.rcode);
				$(".event_name").html(value.rname);
			}
		});
		updateTable2 = initTable(function () {
			$.ajax({
				url:"renewal/findAllRenewals",
				data:{"RId":$("#hid").val()},
				success:function(value){
					initList({
						"value":value,
						"data":{id:"rsId", key1:"rsGrade", key2:"rsPerson", key3:"rsTel", key4:"rsDate"},
						"func":updateTable2,
						"tbodyObj":$("#tbody2"),
						"hidObj":$("#hid2")
					});
				}
			});
		});
		$("#myModal4").modal();
	}
	/* 查看续报详情 */
	$("#renewal_detail").click(function () {
		var rsId = $("#hid2").val();
		if(rsId==""){
			alertAiv($("#myModal_alert"), "请选择要查看的续报");
			return;
		}
		// 执行ajax查看
		$.ajax({
			url:"renewal/findRenewal",
			data:{"rsId":rsId},
			success:function(value){
				$(".rs_person").html(value.rsPerson);
				$(".rs_tel").html(value.rsTel);
				$(".rs_grade").html(value.rsGrade);
				$(".rs_area").html(value.rsArea);
				$(".rs_date").html(value.rsDate);
				$(".rs_casualties").html(value.rsCasualties);
				$(".rs_desc").html(value.rsDesc);
				$("#myModal4_1").modal();
			}
		});
	});
	/* 查看反馈列表 */
	var updateTable3;
	function showFeedBack() {
		var RId = $("#hid").val();
		if(RId==""){
			alertAiv($("#myModal_alert"), "请选择要查看的事件");
			return;
		}
		$.ajax({
			url:"report/findReport",
			data:{"RId":RId},
			success:function(value){
				$(".event_code").html(value.rcode);
				$(".event_name").html(value.rname);
			}
		});
		updateTable3 = initTable(function () {
			$.ajax({
				url:"feedBack/findAllFeedBacks",
				data:{"RId":$("#hid").val()},
				success:function(value){
					initList({
						"value":value,
						"data":{id:"fbId", key1:"resName", key2:"fbPerson", key3:"fbTel", key4:"fbDate"},
						"func":updateTable3,
						"tbodyObj":$("#tbody3"),
						"hidObj":$("#hid3")
					});
				}
			});
		});
		$("#myModal5").modal();
	}
	/* 查看反馈详情 */
	$("#fb_detail").click(function () {
		var fbId = $("#hid3").val();
		if(fbId==""){
			alertAiv($("#myModal_alert"), "请选择要查看的续报");
			return;
		}
		// 执行ajax查看
		$.ajax({
			url:"feedBack/findfeedBack",
			data:{"fbId":fbId},
			success:function(value){
				$(".res_name").html(value.resName);
				$(".fb_person").html(value.fbPerson);
				$(".fb_tel").html(value.fbTel);
				$(".fb_date").html(value.fbDate);
				$(".fb_details").html(value.fbDetails);
				$("#myModal5_1").modal();
			}
		});
	});
	/* 查看调度列表 */
	var status = ["未调度","已调度","资源不足","已归队"];
	var updateTable4;
	function showScheduling() {
		var RId = $("#hid").val();
		if(RId==""){
			alertAiv($("#myModal_alert"), "请选择要查看的事件");
			return;
		}
		$.ajax({
			url:"report/findReport",
			data:{"RId":RId},
			success:function(value){
				$(".event_code").html(value.rcode);
				$(".event_name").html(value.rname);
			}
		});
		updateTable4 = initTable(function () {
			$.ajax({
				url:"scheduling/findAllSchedulings",
				data:{"RId":$("#hid").val()},
				success:function(value){
					initList({
						"value":value,
						"data":{id:"schId", key1:"resName", key2:"userRname", key3:"schPerson", key4:"schCar", key5:"schDate", arr:[status,"schStatus"]},
						"func":updateTable4,
						"tbodyObj":$("#tbody4"),
						"hidObj":$("#hid4")
					});
				}
			});
		});
		$("#myModal6").modal();
	}
	/* 选择预案 */
	var page_size = 5;
	var total_page = 0;
	var page_no = 1;
	function eventScheduling() {
		var RId = $("#hid").val();
		if(RId==""){
			alertAiv($("#myModal_alert"), "请选择要调度的事件");
			return;
		}
		$.ajax({
			url:"report/findReport",
			data:{"RId":RId},
			success:function(value){
				$(".event_code").html(value.rcode);
				$(".event_name").html(value.rname);
				var updateTable5 = initTable(function (pageNo) {
					$.ajax({
						method:"post",
						url:"planning/boxpage",
						data:{pageNo:pageNo,pageSize:page_size,planType:value.rtype,planGrade:value.rgrade},
						success:function(msg) {
							init({
								"value":msg,
								"data":{id:"planId",planName:"planName", planGrade:"planGrade",planType:"planType",planPeopleNum:"planPeopleNum",planCarNum:"planCarNum"},
								"func":updateTable5,
								"tbodyObj":$("#tbody5"),
								"hidObj":$("#hid5")
							});
						}
					});
				});
			}
		});
		$("#myModal7").modal();
	}
	/* 查看预案 */
	$("#find_plan").click(function(){
		if($("#hid5").val()==""){
			alertAiv($("#myModal_alert"), "请选择要查看的预案");
			return;
		}
		$.ajax({
			method:"post",
			url:"planning/findById.do",
			data:{planId:$("#hid5").val()},
			success:function(msg){
				$("#find_plan_name").html(msg.planName);
				$("#find_plan_type").html(msg.planType);
				$("#find_plan_grade").html(msg.planGrade);
				$("#find_plan_peoplenum").html(msg.planPeopleNum);
				$("#find_plan_carnum").html(msg.planCarNum);
				$("#fing_plan_describe").html(msg.planDescribe);
				$("#myModal7_2").modal();
			}
		});
	}); 
	/* 查看预案 */
	$("#choose_plan").click(function(){
		if($("#hid5").val()==""){
			alertAiv($("#myModal_alert"), "请选择要查看的预案");
			return;
		}
		$.ajax({
			method:"post",
			url:"planning/findById.do",
			data:{planId:$("#hid5").val()},
			success:function(msg){
				$("#show_plan_name").html(msg.planName);
				$("#show_plan_type").html(msg.planType);
				$("#show_plan_grade").html(msg.planGrade);
				$("#show_plan_peoplenum").html(msg.planPeopleNum);
				$("#show_plan_carnum").html(msg.planCarNum);
			}
		});
		$("#myModal7_3").modal();
	}); 
	/* 返回预案选择  */
	$("#back-plan").click(function () {
		$("#myModal7").modal();
	});
	/* 操作资源数组 */
	var codeArr = [];
	function changeArr() {
		$("#tbody7 input:checked").each(function (i,obj) {
			codeArr.push($(this).val());
		});
		$(codeArr).each(function (i,obj) {
			if($("#tbody7 input[value='"+codeArr[i]+"']").prop("checked") == false) {
				codeArr.splice(i,1,0);
			}
		});
		codeArr = Array.from(new Set(codeArr));
	}
	/* 刷新资源列表 */
	var updateTable6 = initTable(function () {
		changeArr();
		$.ajax({
			url:"information/findInformations",
			data:{resRegion:$("#res_region").val(), resType:$("#res_type").val()},
			success:function(msg){
				initList({
					"value":msg,
					"data":{id:"resCode", key1:"resName", key2:"resRegion", key3:"resType", key4:"resPerson", key5:"resTel"},
					"func":updateTable6,
					"tbodyObj":$("#tbody7"),
					"hidObj":$("#hid7")
				});
				$("#tbody7 tr").each(function () {
					if($(this).attr('index') != null && $(this).attr('index') != '') {
						$(this).prepend("<td><input type='checkbox' value='"+$(this).attr('index')+"'></td>");
					}
				});
				if($("#thead7 th").length<6) {
					$("#thead7 tr").prepend("<th></th>");
				}
				$(codeArr).each(function (i,obj) {
					$("#tbody7 input[value='"+obj+"']").prop("checked", true);
				});
			}
		});
	});
	/* 选择资源 */
	$("#choose-res").click(function () {
		$.ajax({
			url:"report/findReport",
			data:{"RId":$("#hid").val()},
			success:function(value){
				$("#res_region").val(value.rregionKey);
				updateTable6();
				$("#myModal7_4").modal();
			}
		});
	});
	/* 选择资源类型/地区 */
	$("#res_type").change(function () {
		updateTable6();
	});
	$("#res_region").change(function () {
		updateTable6();
	});
	/* 确认选择资源 */
	$("#confirm-res").click(function () {
		changeArr();
		$.ajax({
			url:"http://192.168.1.188:8080/YJBZXT/findResByCodes/",
			data:{list:codeArr+""},
			type: "GET",
			dataType:'jsonp',
            jsonp:'callback',
            jsonpCallback:"successCallback",
			success:function(value){
				var str = "";
				$(value).each(function (i,obj) {
					str+="<tr index='"+obj[0]+"'><td>"+obj[1]+"</td>"+
					"<td><div class='input-group numDiv'><input type='text' class='form-control count count1'><span class='input-group-addon'>/ "+obj[2]+"</span></div></td>"+
					"<td><div class='input-group numDiv'><input type='text' class='form-control count count2'><span class='input-group-addon'>/ "+obj[3]+"</span></div></td>"+
					"<td><a href='javascript:del()'>移除</a></td></tr>";
				});
				$("#myModal7_4").modal('hide');
				$("#tbody6").html(str);
				//给绑定表格2绑定点击事件
				$("#hid6").val("");
				$("#tbody6 tr").mouseup(addTrClass);
				function addTrClass() {
					$("#tbody6 tr").removeClass("as");
					$(this).addClass("as");
					$("#hid6").val($(this).attr("index"));
				}
				$("#tbody6 input").focus(function () {
					$("#tbody6 tr").removeClass("as");
					$(this).parent().parent().parent().addClass("as");
					$(this).parent().removeClass("has-success has-error");
					$("#hid6").val($(this).parent().parent().parent().attr("index"));
				});
				//给领用数量框绑定事件
				$(".count1").blur(updateCount);
				$(".count2").blur(updateCount);
				var list = ["","",""];
				$.ajax({type:"post",url:"scheduling/updateCount",data:{"list":list}});
			}
		});
	});
	//验证数量
	function checkNum(obj) {
		var flag = true;
		var reg = /^[0-9]+$/;
		if(obj==null) {
			$(".count").each(function () {
				if(!reg.test($(this).val())){
					$(this).parent().addClass("has-error");
					flag = false;
					return;
				}
				if(parseInt($(this).next().text().trim().slice(1)) < parseInt($(this).val())) {
					$(this).parent().addClass("has-error");
					flag = false;
					return;
				}
				$(this).parent().addClass("has-success");
			});
			return flag;
		}
		if(!reg.test(obj.val())){
			obj.parent().addClass("has-error");
			flag = false;
			return flag;
		}
		if(parseInt(obj.next().text().trim().slice(1)) < parseInt(obj.val())) {
			obj.parent().addClass("has-error");
			flag = false;
			return flag;
		}
		obj.parent().addClass("has-success");
		return flag;
	}
	//修改领用数量
	function updateCount() {
		if(!checkNum($(this))) {
			return;
		}
		var code = $("#hid6").val();
		var peoCount = $("#tbody6 tr[index='"+code+"'] .count1").val();
		var carCount = $("#tbody6 tr[index='"+code+"'] .count2").val();
		var list = [code,peoCount,carCount];
		$.ajax({type:"post",url:"scheduling/updateCount",data:{"list":list}});
	}
	//移除资源
	function del() {
		var orgCode = $("#hid6").val();
		$.ajax({type:"post",url:"scheduling/delRes",data:{orgCode:orgCode},
			success:function(value) {
				$(codeArr).each(function (i,obj) {
					if(orgCode == obj) {
						codeArr.splice(i,1,0);
					}
				});
				codeArr = Array.from(new Set(codeArr));
				$("#tbody6 tr").remove("[index='"+orgCode+"']");
				$("#tbody7 input[value='"+orgCode+"']").prop("checked", false);
			}
		});
	}
	//确认调度
	$("#add-sche").click(function () {
		if(!checkNum()) {
			alertAiv($("#myModal_alert"),"请输入正确的调度数量");
			return;
		}
		if($("#tbody6 tr").length==0) {
			alertAiv($("#myModal_alert"),"请选择要调度的资源");
			return;
		}
		$.ajax({
			method:"post",
			url:"scheduling/addSchedulings",
			data:{"RId":$("#hid").val(),"planId":$("#hid5").val()},
			success:function(value) {
				$("#tbody6").html("");
				codeArr = [];
				$("#tbody7 input[type='checkbox']").prop("checked", false);
				checkSuccess(value, $("#myModal_alert"), "调度", $("#myModal7_3"));
				updateTable();
			}
		});
	});
    </script>
</body>
</html>