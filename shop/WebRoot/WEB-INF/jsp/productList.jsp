<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="hur" content="">
    <title>productList</title>
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

	<!--content-->
	<section id="advertisement">
		<div class="container">
			<img src="${pageContext.request.contextPath}/images/advertisement.jpg" alt="" />
		</div>
	</section>
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>分类</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<s:iterator var="c" value="#session.cList">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#products">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											<s:property value="#c.cname"/>
										</a>
									</h4>
								</div>
								<div id="products" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<s:iterator var="cs" value="#c.categorySeconds">
											<li><a href="${pageContext.request.contextPath}/product_findByCsid.action?csid=<s:property value="#cs.csid"/>&page=1"><s:property value="#cs.csname"/> </a></li>
											</s:iterator>
										</ul>
									</div>
								</div>
							</div>
							</s:iterator>
						</div><!--/category-productsr-->
					
						<div class="brands_products"><!--brands_products-->
							<h2>品牌</h2>
							<div class="brands-name">
								<ul class="nav nav-pills nav-stacked">
								<s:iterator var="s" value="sList">
									<li><a href=""> <span class="pull-right">(50)</span><s:property value="#s.sname"/></a></li>
								</s:iterator>
								</ul>
							</div>
						</div><!--/brands_products-->
						
						<div class="price-range"><!--price-range-->
							<h2>Price Range</h2>
							<div class="well">
								 <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5" data-slider-value="[250,450]" id="sl2" ><br />
								 <b>$ 0</b> <b class="pull-right">$ 600</b>
							</div>
						</div><!--/price-range-->
						
						<div class="shipping text-center"><!--shipping-->
							<img src="${pageContext.request.contextPath}/images/shipping.jpg" alt="" />
						</div><!--/shipping-->
						
					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">所有商品</h2>
						<s:iterator var="p" value="pageBean.list">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img class="img-responsive" src="${pageContext.request.contextPath}/<s:property value="#p.img"/>" alt="" />
										<h2>￥<s:property value="#p.price"/></h2>
										<p><s:property value="#p.pname"/></p>
										<a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid"/>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2>￥<s:property value="#p.price"/></h2>
											<p><s:property value="#p.pname"/></p>
											<a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#p.pid"/>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
										</div>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href=""><i class="fa fa-plus-square"></i>加入心愿单</a></li>
										<li><a href=""><i class="fa fa-plus-square"></i>加入对比</a></li>
									</ul>
								</div>
							</div>
						</div>
						</s:iterator>
						
						<ul class="pagination pull-right">
						<s:if test="cid != null">
							<s:if test="pageBean.page != 1">
								<li><a href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page-1"/>">«</a></li>
							</s:if>
							<s:iterator var="i" begin="1" end="pageBean.totalPage">
								<s:if test="pageBean.page != #i">
									<li><a href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="#i"/>"><s:property value="#i"/></a></li>
								</s:if>
								<s:else>
									<li class="active"><a href="#"><s:property value="#i"/></a></li>
								</s:else>
							</s:iterator>
							<s:if test="pageBean.page != pageBean.totalPage">
							<li><a href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page+1"/>">»</a></li>
							</s:if>
						</s:if>
						
						<s:if test="csid != null">
							<s:if test="pageBean.page != 1">
								<li><a href="${pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page-1"/>">«</a></li>
							</s:if>
							<s:iterator var="i" begin="1" end="pageBean.totalPage">
								<s:if test="pageBean.page != #i">
									<li><a href="${ pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="#i"/>"><s:property value="#i"/></a></li>
								</s:if>
								<s:else>
									<li class="active"><a href="#"><s:property value="#i"/></a></li>
								</s:else>
							</s:iterator>
							<s:if test="pageBean.page != pageBean.totalPage">
							<li><a href="${pageContext.request.contextPath }/product_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page+1"/>">»</a></li>
							</s:if>
						</s:if>
						&nbsp;&nbsp;&nbsp;&nbsp;第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页
					 	</ul> 
					</div><!--features_items-->
				</div>
			</div>
		</div>
	</section>
	
	<!--footer-->
	<%@ include file="footer.jsp" %>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/price-range.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrollUp.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>

</body>
</html>