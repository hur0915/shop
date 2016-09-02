<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html lang="en">
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
    
<style type="text/css">
.add_chose{width:105px;}
.add_chose a{float:left;margin:5px 0 0 0;display:block;width:15px;height:15px;line-height:99em;overflow:hidden;background:url(${pageContext.request.contextPath}/images/reduce-add.gif) no-repeat;}
.add_chose a.reduce{background-position:0 0;}
.add_chose a.reduce:hover{background-position:0 -16px;}
.add_chose a.add{background-position:-16px 0;}
.add_chose a.add:hover{background-position:-16px -16px;}
.add_chose .text{float:left;margin:0 5px;display:inline;border:solid 1px #ccc;padding:4px 3px 4px 8px;width:40px;line-height:18px;font-size:14px;color:#990000;font-weight:800;}
.count{line-height:2em;}
</style>
     
</head>

<body>
	<!--header-->
	<%@ include file="header.jsp" %>

	<!--content-->
	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="${pageContext.request.contextPath }/index.action">首页</a></li>
				  <li class="active">购物车</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">商品</td>
							<td class="description"></td>
							<td class="price">单价</td>
							<td class="quantity">数量</td>
							<td class="total">金额</td>
							<td class="delete">操作</td>
						</tr>
					</thead>
					<tbody>
						<s:iterator var="cartItem" value="#session.cart.cartItems">
						<tr>
							<td class="cart_product">
								<a href=""><img width="80" src="${pageContext.request.contextPath}/<s:property value="#cartItem.product.img"/>" class="img-responsive" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#cartItem.product.pid"/>"><s:property value="#cartItem.product.pname"/></a></h4>
								<p>编号：<s:property value="#cartItem.product.pid"/>，颜色： <s:property value="#cartItem.color"/>，尺码： <s:property value="#cartItem.size"/></p>
							</td>
							<td class="cart_price">
								<p>￥<s:property value="#cartItem.product.price"/></p>
							</td>
							<td class="cart_quantity">
								<div class="f_l add_chose">
									<a class="reduce" onClick="setAmount.reduce('#qty_item_1')" href="javascript:void(0)">
									-</a>
									<input type="text" name="count" value="<s:property value="#cartItem.count"/>" id="qty_item_1" onKeyUp="setAmount.modify('#qty_item_1')" class="text" />
									<a class="add" onClick="setAmount.add('#qty_item_1')" href="javascript:void(0)">
									+</a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">￥<s:property value="#cartItem.subtotal"/></p>
							</td>
							<td>
								<a class="cart_quantity_delete" href="${pageContext.request.contextPath }/cart_removeCart.action?pid=<s:property value="#cartItem.product.pid"/>"><i class="fa fa-times"></i></a>
							</td>
						</tr>
						</s:iterator>
						
						<tr>
                  			<td colspan="5" style="text-align:right"><strong>合计（不含运费）=</strong></td>
                  			<td style="display:block"><strong>￥<s:property value="#session.cart.total"/></strong></td>
                		</tr>
                		<tr>
                			<td><a href="${pageContext.request.contextPath }/cart_clearCart.action" id="clear" class="clear">清空购物车</a></td>
							<td><a href="${pageContext.request.contextPath }/order_saveOrder.action" id="submit" class="submit pull-right">提交订单</a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->


	<!--footer-->
	<%@ include file="footer.jsp" %>
	
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/price-range.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrollUp.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <script src="${pageContext.request.contextPath}/js/payfor.js"></script>

</body>
</html>