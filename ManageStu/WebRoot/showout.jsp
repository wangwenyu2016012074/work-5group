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
    
    <title>My JSP 'showout.jsp' starting page</title>
    
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
     <table>
   	   <c:forEach items="${nresult}" var="nresult">  
    	   <tr>    	   	  	    	 
    	   	 <td>${nresult.id}</td>
    	   	 <td>${nresult.name}</td>
    	   	 <td>${nresult.birDate}</td>
    	   	 <td>${nresult.gender}</td>
   
   			<c:choose>  
		       <c:when test="${edit==null}">  		  
		       </c:when>  
		       <c:otherwise>  		               
		           <td><a href="StuServlet?flag=geted&id=${nresult.id}"/>修改</td> 	         
		       </c:otherwise> 		          
     		</c:choose>	
     		
     		<c:choose>  
		       <c:when test="${del==null}">  		  
		       </c:when>  
		       <c:otherwise>  		               
		           <td><a href="StuServlet?flag=del&id=${nresult.id}"/>删除</td> 	         
		       </c:otherwise> 		          
     		</c:choose>	
   
    	   </tr>
       </c:forEach>  	       
     </table>
     <a href="index.jsp">退出</a>
      <div>  
                       第${currentPage}页/共${totalPage}页
         <a href="StuServlet?currentPage=1&totalPage=${totalPage}&flag=all&edit=${edit}&del=${del}">首页</a>          
         <c:choose>  
             <c:when test="${currentPage==1}">  
                                          上一页  
             </c:when>  
	         <c:otherwise>  		               
	               <a href="StuServlet?currentPage=${currentPage-1}&totalPage=${totalPage}&flag=all&edit=${edit}&del=${del}">上一页</a>   	         
	         </c:otherwise> 		          
         </c:choose> 
         
         <c:choose>  
             <c:when test="${currentPage==totalPage}">  
                                         下一页  
             </c:when>  
	         <c:otherwise>  
	             <a href="StuServlet?currentPage=${currentPage+1}&totalPage=${totalPage}&flag=all&edit=${edit}&del=${del}">下一页</a>  
	         </c:otherwise>  	         
         </c:choose> 
         <a href="StuServlet?currentPage=${totalPage}&totalPage=${totalPage}&flag=all&edit=${edit}&del=${del}">尾页</a>  
         <form action="StuServlet?flag=all&edit=${edit}&del=${del}" method="post">
                                跳转到<input type="text" name="currentPage"/>页  
            <input type="hidden" name="totalPage" value="${totalPage}"/>
             <input type="submit" value="go"/>               
         </form>
       </div>  
  </body>
</html>
