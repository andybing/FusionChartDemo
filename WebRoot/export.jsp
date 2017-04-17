<%@page import="com.andy.util.ExcelUtil"%>
<%@page import="com.andy.dao.CourseDao"%>
<%@ page language="java" import="java.util.*,com.andy.dao.CourseDao,com.andy.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	List<HashMap<String,Object>> list = CourseDao.queryCourse();
	String path = request.getRealPath("/")+"course.xls";
	ExcelUtil.exportExcelData(list, path);
	out.print("<a href='/Arry_Chart/course.xls'>点击下载</a>");
%>