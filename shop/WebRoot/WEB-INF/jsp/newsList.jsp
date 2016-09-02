<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>productList</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="shop" />
<script type="application/x-javascript"> 
	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--fonts-->
<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
<!--//fonts-->
<!-- start menu -->
<link href="${pageContext.request.contextPath}/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/memenu.js"></script>
<script>
	$(document).ready(function(){$(".memenu").memenu();});
</script>
<script src="${pageContext.request.contextPath}/js/simpleCart.min.js"> </script>
</head>
<body>
<!--header-->
<%@ include file="header.jsp" %>

<!--content-->
<div class="product">
	<div class="container">

<!--initiate accordion-->
<script type="text/javascript">
$(function() {
    var menu_ul = $('.menu > li > ul'),
           menu_a  = $('.menu > li > a');
    menu_ul.hide();
    menu_a.click(function(e) {
        e.preventDefault();
        if(!$(this).hasClass('active')) {
            menu_a.removeClass('active');
            menu_ul.filter(':visible').slideUp('normal');
            $(this).addClass('active').next().stop(true,true).slideDown('normal');
        } else {
            $(this).removeClass('active');
            $(this).next().stop(true,true).slideUp('normal');
        }
    });

});
</script>

	
		<!--productList-->
		<ul class="breadcrumb">
		    <li><a href="index.html">Home</a> <span class="divider">/</span></li>
		    <li><a href="products.html">Products</a> <span class="divider">/</span></li>
		    <li class="active">资讯</li>
		</ul>
		
		<div class="product1">
			<div class="bottom-product">
			<s:iterator var="n" value="neList">
				<a href="#"><s:property value="#n.title"/></a>
				<s:property value="#n.time"/><br/>
			</s:iterator>
			<div class="clearfix"> </div>		
			</div>
		</div>
		<div class="clearfix"> </div>
			
	</div>
</div>

<!--footer-->
<%@ include file="footer.jsp" %>

</body>
</html>