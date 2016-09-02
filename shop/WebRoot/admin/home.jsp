<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> 
	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<script src="${pageContext.request.contextPath }/js/jquery-2.1.1.min.js"></script> 
<link href="${pageContext.request.contextPath }/css/font-awesome.css" rel="stylesheet"> 
</head>
<body>	
<div class="page-container">	
	<div class="left-content">
		<div class="mother-grid-inner">
	   	
		   	<!--header start here-->
		   	<%@ include file="top.jsp" %>
		   
		   	<!--inner block start here-->
			<div class="inner-block">
				<center>  	
    				<img class="img-responsive" src="${pageContext.request.contextPath }/images/welcome.jpg" alt="">
    			</center>
			</div>
			<div class="copyrights">
	 			<p>Copyright &copy; 2016.hur All rights reserved.</p>
			</div>	
	   </div>
	</div>
	
	<!--slider menu-->
	<%@ include file="sidebar.jsp" %>
</div>

	<script src="${pageContext.request.contextPath }/js/jquery.nicescroll.js"></script>
	<script src="${pageContext.request.contextPath }/js/scripts.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.js"> </script>
	
</body>
</html>
