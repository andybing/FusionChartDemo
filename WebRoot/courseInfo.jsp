<%@page import="com.andy.dao.CourseDao"%>
<%@ page language="java" import="java.util.*,com.andy.dao.CourseDao" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
	<head>
		<title></title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<meta name="keywords" content="">
		<meta name="description" content="">
		<style type="text/css">
			*{padding:0;margin:0;}
			body{font-size:12px;font-family:"微软雅黑";color:#666;}
			/*table starts*/
			.table{width:600px;text-align:center;margin:200px auto;border-collapse:collapse;}
			.table th{line-height:50px;font-size:20px;}
			.table .t_title{font-size:14px;font-weight:bold;}
			.table tr .t_id{width:80px;}
			.table tr td{border:1px solid red;line-height:30px;}
			.table tr td:hover{background:#66cc00;color:#fff;}
			/*end table*/
		</style>
	</head>

	<body>
		<% 
			List<HashMap<String,Object>> list = CourseDao.queryCourse();
			pageContext.setAttribute("courses", list);
		%>
		<!--table start-->
		<table class="table">
			<th colspan="3">从数据库导出数据</th>
			<tr class="t_title">
				<td>课程编号</td>
				<td>课程名称</td>
				<td>课程描述信息</td>
			</tr>
			<c:forEach var="course" items="${courses}">
				<tr class="t_title">
					<td>${course.id}</td>
					<td>${course.name}</td>
					<td>${course.desc}</td>
				</tr>
			</c:forEach>
			
		</table>
		<!--table end-->
		
		<a href="export.jsp">点击导出excel表格</a>
	</body>
</html>