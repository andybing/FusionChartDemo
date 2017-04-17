<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head>
		<title>ERP</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<meta name="keywords" content="ERP">
		<meta name="description" content="ERP">
		<style type="text/css">
			*{padding:0;margin:0;}
			body{background:#966;font-size:12px;font-family:"微软雅黑";color:#666;}
			.chart{width:300px;height:100px;margin:100px auto;background:#cc33ff;font-size:16px;color:#000000;}
			.content{width:100%;height:300px;background:#69f;}
		</style>
		<link type="text/css" rel="stylesheet" href="css/animate.css"></link>
	</head>

	<body>
		
		<div class="chart">
			查看不同类型的统计报表
			<select onchange="change_chart(this)">
				<option value="line" selected="selected">曲线图</option>
				<option value="area2d">区域图</option>
				<option value="bar3d">饼状图</option>
				<option value="doughnut2d">饼3D图</option>
				<option value="stackedcolumn3dline">曲线2D</option>
				<option value="stackedbar2d">曲线图</option>
			</select>
		</div>
		<div class="content animated bounceIn" id="chartContainer"></div>
		
		<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="js/fusioncharts.js"></script>
		<script type="text/javascript" src="js/themes/fusioncharts.theme.fint.js"></script>

		<script type="text/javascript">
			$(function(){
				loadChart("line");
			});
			//选择统计图
			function change_chart(obj){
				
				loadChart(obj.value);
			}
			function loadChart(type){
				FusionCharts.ready(function(){
					var revenueChart = new FusionCharts({
					"type": type,
					"renderAt": "chartContainer",
					"width": "100%",
					"height": "300",
					"dataFormat": "xml",
					"dataSource":
						
						"<chart caption='Half Yearly Revenue Analysis' yaxisname='Revenue' numberprefix='$' yaxismaxvalue='250000' showborder='0' theme='fint'>"+
						"<set label='Jul' value='150000' tooltext='Occupancy: 67%{br}Revenue:$150k{br}3 conferences hosted!' />"+
						"<set label='Aug' value='130000' tooltext='Occupancy: 64%{br}Revenue:$130k{br}Lean summer period!' />"+
						"<set label='Sep' tooltext='Occupancy: 44%{br}Revenue: $80k{br}Reason: Renovating the Lobby' value='95000' />"+
						"<set label='Oct' value='170000' tooltext='Occupancy: 73%{br}Revenue:$170k{br}Anniversary Discount: 25%' />"+
						"<set label='Nov' value='155000' tooltext='Occupancy: 70%{br}Revenue:$155k{br}2 conferences cancelled!' />"+
						"<set label='Dec' value='230000' tooltext='Occupancy: 95%{br}Revenue:$230k{br}Crossed last year record!' />"+
						"</chart>"});
					 
				     revenueChart.render();
					 });
			}
		</script>
	</body>
</html>