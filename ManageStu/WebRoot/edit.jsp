<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <form action="StuServlet?flag=edit" method="post">
    	<table>
    	   <tr>
    	   	 <td>学号</td>
    	   	 <td><input type="text" name="id" value="${id}"/></td>
    	   </tr>
    	   <tr>
    	   	 <td>姓名</td>
    	   	 <td><input type="text" name="name" value="${name}"/></td>
    	   </tr>
    	   <tr>
    	   	 <td>出生日期</td>
    	   	 <td><input type="text" name="birDate" value="${birDate}"/></td>
    	   </tr>
    	   <tr>
    	   	 <td>性别</td>
    	   	 <td><input type="text" name="gender" value="${gender}"/></td>
    	   </tr>
    	   <tr>
    	   	 <td><input type="submit" value="修改"/></td>
    	   </tr>
    	</table>
    </form>
    <a href="index.jsp">退出</a>
    <a href="StuServlet?flag=all&edit=y">返回</a>
  </body>
</html>
