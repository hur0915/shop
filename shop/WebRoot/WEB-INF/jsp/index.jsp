<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="hur" content="">
    <title>shop</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/prettyPhoto.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/price-range.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/js/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/js/respond.min.js"></script>
    <![endif]-->       
</head>
<body>
<!--header-->
<%@ include file="header.jsp" %>

<section id="slider">
  <!--slider-->
  <div class="container">
    <div class="row">
      <div class="col-sm-12">
        <div id="slider-carousel" class="carousel slide" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
            <li data-target="#slider-carousel" data-slide-to="1"></li>
            <li data-target="#slider-carousel" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner">
            <div class="item active" align="center">
              <img src="images/j1.jpg" class="girl img-responsive" alt="" /> 
            </div>
            <div class="item" align="center">
              <img src="images/j2.jpg" class="girl img-responsive" alt="" /> 
            </div>
            <div class="item" align="center">
              <img src="images/j3.jpg" class="girl img-responsive" alt="" /> 
            </div>
          </div>
          <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev"> <i class="fa fa-angle-left"></i> </a> <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next"> <i class="fa fa-angle-right"></i> </a> </div>
      </div>
    </div>
  </div>
</section>
<!--/slider-->


<!--content-->
<div class="container">
    <div class="row">
	    <div class="col-sm-11">
	    	<div class="left-sidebar">
	        	<h2>为你推荐</h2>
	        </div>
	    </div>
	    <div class="col-sm-1 hidden-xs hidden-sm">
	    	<div class="left-sidebar">
	        	<p style="color:red">换一换<p>
	        </div>
	    </div>
	</div>
</div>
<div class="container">
    <div class="row">
		<div class="grid-in">
		<s:iterator var="p" value="hList">
			<div class="col-md-3 grid-top">
				<a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid"/>" class="b-link-stripe b-animate-go  thickbox">
					<img class="img-responsive" src="${pageContext.request.contextPath}/<s:property value="#p.img"/>" alt="">
					<div class="b-wrapper">
						<h3 class="b-animate b-from-left b-delay03 ">
							<span><s:property value="#p.categorySecond.csname"/></span>	
						</h3>
					</div>
				</a>
				<p><a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid"/>"><s:property value="#p.pname"/></a></p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
			</div>
		</s:iterator>
		</div>	
		<div class="clearfix"> </div>
	</div>
</div>

<div class="container">
    <div class="row">
    	<div class="left-sidebar">
        	<h2>平台商品</h2>
        </div>
	</div>
</div>
<div class="container">
    <div class="row">
    	<ul class="nav nav-tabs">
			<li class="active"><a href="#">精品商品</a></li>
		   	<li><a href="#">最新商品</a></li>
		   	<li><a href="#">全部商品</a></li>
		</ul>
		<div class="grid-in" style="padding-top:30px">
		<s:iterator var="p" value="hList">
			<div class="col-md-3 grid-top">
				<a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid"/>" class="b-link-stripe b-animate-go  thickbox">
					<img class="img-responsive" src="${pageContext.request.contextPath}/<s:property value="#p.img"/>" alt="">
					<div class="b-wrapper">
						<h3 class="b-animate b-from-left b-delay03 ">
							<span><s:property value="#p.categorySecond.csname"/></span>	
						</h3>
					</div>
				</a>
				<p><a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid"/>"><s:property value="#p.pname"/></a></p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
			</div>
		</s:iterator>
		</div>	
		<div class="clearfix"> </div>
	</div>
</div>


<!--footer-->
<%@ include file="footer.jsp" %>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/price-range.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>

</body>
</html>