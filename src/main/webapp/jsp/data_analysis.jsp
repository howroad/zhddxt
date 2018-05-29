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
<title>数据分析</title>
</head>
<body>
<div class="container-fluid" id="wrap">
        <div class="row">
            <h2 class="text-center">数据分析</h2>
            <div class="table-responsive col-md-12">
                <nav class="navbar navbar-default" id="query" role="navigation">
                    <div class="navbar-header col-md-3"><span class="navbar-brand">选择数据分析类型</span></div>
                    <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <label for="his_select_type">数据类型 </label>
                                <select id="his_select_type" class="form-control" name="rhType">
									<option value="">请选择</option>
									<option value="SJLX">事件类型</option>
									<option value="SJDJ">事件等级</option>
									<option value="DQ">事件区域</option>
		                        </select>
                            </div>
                            <button type="button" class="btn btn-default" id="query-btn">查看</button>
                        </form>
                    </div>
                </nav>
            </div>
        </div>
		<div class="row">
			<div id="picturePlace" class="col-md-6" style="height: 500px;"></div>
			<div id="picturePlace2" class="col-md-6" style="height: 500px;"></div>
		</div>
	</div>
	<script>
		// 基于准备好的dom，初始化echarts图表  
		var myChart = echarts.init($("#picturePlace")[0]);
		myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
		var myChart2 = echarts.init($("#picturePlace2")[0]);
		myChart2.showLoading();
		$("#his_select_type").change(function name() {
			if($("#his_select_type").val()!=""){
				/*   app.title = '坐标轴刻度与标签对齐'; */
				$.ajax({
					url : "dataAnalysis/ceshi.do",
					data : {
						dataType : $("#his_select_type").val()
					},
					success : function(value) {
						var option = {
							color : [ '#3398DB' ],
							tooltip : {
								trigger : 'axis',
								axisPointer : { // 坐标轴指示器，坐标轴触发有效
									type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							grid : {
								left : '3%',
								right : '4%',
								bottom : '3%',
								containLabel : true
							},
							xAxis : [ {
								type : 'category',
								data : value[0],
								axisTick : {
									alignWithLabel : true
								}
							} ],
							yAxis : [ {
								type : 'value'
							} ],
							series : [ {
								name : '直接访问',
								type : 'bar',
								barWidth : '60%',
								data : value[1]
							} ]
						};
						var arr = [];
						for(var i =0; i < value[0].length;i++){
							arr.push({
								name : value[0][i],
								value : value[1][i]
							})
						}
						var options = {
							    backgroundColor: '#ffffff',

							    title: {
							        text: 'Customized Pie',
							        left: 'center',
							        top: 20,
							        textStyle: {
							            color: '#ccc'
							        }
							    },

							    tooltip : {
							        trigger: 'item',
							        formatter: "{a} <br/>{b} : {c} ({d}%)"
							    },

							    visualMap: {
							        show: false,
							        min: 80,
							        max: 600,
							        inRange: {
							            colorLightness: [0, 1]
							        }
							    },
							    series : [
							        {
							            name:'访问来源',
							            type:'pie',
							            radius : '55%',
							            center: ['50%', '50%'],
							            data:arr.sort(function (a, b) { return a.value - b.value; }),
							            roseType: 'radius',
							            label: {
							                normal: {
							                    textStyle: {
							                        color: 'rgba(0, 0, 0, 0.5)'
							                    }
							                }
							            },
							            labelLine: {
							                normal: {
							                    lineStyle: {
							                        color: 'rgba(0, 0, 0, 0.5)'
							                    },
							                    smooth: 0.2,
							                    length: 10,
							                    length2: 20
							                }
							            },
							            itemStyle: {
							                normal: {
							                    color: '#c23531',
							                    shadowBlur: 10,
							                    shadowColor: 'rgba(0, 0, 0, 0.5)'
							                }
							            },

							            animationType: 'scale',
							            animationEasing: 'elasticOut',
							            animationDelay: function (idx) {
							                return Math.random() * 200;
							            }
							        }
							    ]
							};
						myChart.hideLoading();    //隐藏加载动画
						myChart.setOption(option);
						myChart2.hideLoading();    //隐藏加载动画
						myChart2.setOption(options);
					}
				});
			}else{
				return false;
			}
		});
		
		
		  
		

		/* myChart.setOption({
		    title: {
		        text: '异步数据加载示例'
		    },
		    tooltip: {},
		    legend: {
		        data:['销量']
		    },
		    xAxis: {
		        data: []
		    },
		    yAxis: {},
		    series: [{
		        name: '销量',
		        type: 'bar',
		        data: []
		    }]
		});
		
		myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
		
		var names=[];    //类别数组（实际用来盛放X轴坐标值）
		var nums=[];    //销量数组（实际用来盛放Y坐标值）
		
		$.ajax({
		method : "post",
		async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
		url : "/ZHDDXT/dataAnalysis/ceshi.do",    //请求发送到TestServlet处
		success : function(result) {
		    //请求成功时执行该函数内容，result即为服务器返回的json对象
		    if (result) {
		           for(var i=0;i<result.length;i++){       
		              names.push(result.get(i).get(0));    //挨个取出类别并填入类别数组
		            }
		           for(var i=0;i<result.length;i++){       
		               nums.push(result.get(i).get(1));    //挨个取出销量并填入销量数组
		             }
		           myChart.hideLoading();    //隐藏加载动画
		           myChart.setOption({        //加载数据图表
		               xAxis: {
		                   data: names
		               },
		               series: [{
		                   // 根据名字对应到相应的系列
		                   name: '销量',
		                   data: nums
		               }]
		           });
		           
		    }
		
		},
		error : function(errorMsg) {
		    //请求失败时执行该函数
		alert("图表请求数据失败!");
		myChart.hideLoading();
		}
		}) */

		/* var option = {
			    title: {
			        text: '折线图堆叠'
			    },
			    tooltip: {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    toolbox: {
			        feature: {
			            saveAsImage: {}
			        }
			    },
			    xAxis: {
			        type: 'category',
			        boundaryGap: false,
			        data: ['周一','周二','周三','周四','周五','周六','周日']
			    },
			    yAxis: {
			        type: 'value'
			    },
			    series: [ */
		/* {
		 name: '销量',
		 type: 'bar',
		 data: []
			} */
		/*    	         {
		   	            name:'邮件营销',
		   	            type:'line',
		   	            stack: '总量',
		   	            data:[120, 132, 101, 134, 90, 230, 210]
		   	        },
		   	        {
		   	            name:'联盟广告',
		   	            type:'line',
		   	            stack: '总量',
		   	            data:[220, 182, 191, 234, 290, 330, 310]
		   	        },
		   	        {
		   	            name:'视频广告',
		   	            type:'line',
		   	            stack: '总量',
		   	            data:[150, 232, 201, 154, 190, 330, 410]
		   	        },
		   	        {
		   	            name:'直接访问',
		   	            type:'line',
		   	            stack: '总量',
		   	            data:[320, 332, 301, 334, 390, 330, 320]
		   	        },
		   	        {
		   	            name:'搜索引擎',
		   	            type:'line',
		   	            stack: '总量',
		   	            data:[820, 932, 901, 934, 1290, 1330, 1320]
		   	        } 
		   	    ]
		   	}
		   myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
		   myChart.hideLoading();    //隐藏加载动画
		   myChart.setOption(option)  */
		/*  var nums = [];
		 var num = [];
		 // 为echarts对象加载数据   
		 $.ajax({
		 	    		method:"post",
		 	    		url:"/ZHDDXT/dataAnalysis/ceshi.do",
		 	    		data:{dataName:"bkk"},
		 	    		success:function(msg){
		 	    			console,info(msg)
		 	    			for(var i = 0;i < msg.size;i++){
		 	    				nums.push(msg.get(i).get("name"))
		 	    			}
		 	    			for(var i = 0;i < msg.size;i++){
		 	    				num.push(msg.get(i).get("data"))
		 	    			}
		 	    			console.info()
		 	    			 myChart.setOption({        //加载数据图表
		 	    	                xAxis: {
		 	    	                    data: nams
		 	    	                },
		 	    	                series: [{
		 	    	                    // 根据名字对应到相应的系列
		 	    	                    name: '销量',
		 	    	                    data: num
		 	    	                }]
		 	    	            });   
		 	    		}
		 	    	}) */
	</script>
</body>
</html>