<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html;" charset=UTF-8">
  <title>Welcome To  Vicarious REST Code !!!</title>
</head>
<body>
    <h1>>Welcome To  Vicarious REST Code  !!!</h1> 
    <form action="<c:url value='/v1/generate_number/'/>"method="post" >
        <input type="hidden" name="_method" value="GET">	  
        <input type="submit" value="GET">
    </form>  
     <form action="<c:url value='/v1/web/generate_number/'/>" method="post" >
	      <input id="min" name ="min"  type="number">
		 <input id="max" name= "max"  type="number"> 
        <input type="hidden" name="_method" value="POST">	  
        <input type="submit" value="POST">
    
    
    
    </form>  
    
    
    
    
    
<%--     <form action="<c:url value='/MyData'/>"   method="post" > --%>
<!--        <input id="min" type="number"> -->
<!--       <input id="max" type="number"> -->
<!--         <input type="submit" value="POST"> -->
<!--     </form>   -->
<%--     <form action="<c:url value='/MyData/654321'/>" --%>
<!-- 		  method="post" > -->
<!--         <input type="hidden" name="_method" value="DELETE">	   -->
<!--         <input type="submit" value="DELETE"> -->
<!--     </form>   -->
</body>
</html>
