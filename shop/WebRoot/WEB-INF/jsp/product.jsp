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
	<link href="${pageContext.request.contextPath}/css/ui-choose.css" rel="stylesheet" />
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/js/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/js/respond.min.js"></script>
    <![endif]-->
    
<style type="text/css">
.f_l{float:left;}
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
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-8">
				<s:iterator var="pi" value="piList">
					<img class="img-responsive" src="${pageContext.request.contextPath }/<s:property value="#pi.image"/>" />
				</s:iterator>
				</div>
				<div class="col-sm-4">
					<h2><s:property value="model.store.sname"/></h2>
					<h2><s:property value="model.pname"/></h2>
					<h5>价格/&nbsp;￥：<s:property value="model.price"/>元</h5>
					<form id="cartForm" action="${pageContext.request.contextPath }/cart_addCart.action" method="post">
						<input type="hidden" name="pid" value="<s:property value="model.pid"/>"/>
						<div class="color">颜色：
						<select class="ui-choose" id="uc_02" name="color">
							<s:iterator var="pc" value="pcList">
						<option><s:property value="#pc.color"/></option>
							</s:iterator>
						</select>
						</div><br/>
						<div class="size">尺码：
						<select class="ui-choose" id="uc_02" name="size">
							<s:iterator var="ps" value="psList">
						<option><s:property value="#ps.size"/></option>
							</s:iterator>
						</select>
						</div><br/>
						<div class="f_l count">
							数量：
						</div>
						<div class="f_l add_chose">
							<a class="reduce" onClick="setAmount.reduce('#qty_item_1')" href="javascript:void(0)">
							-</a>
							<input type="text" name="count" value="1" id="qty_item_1" onKeyUp="setAmount.modify('#qty_item_1')" class="text" />
							<a class="add" onClick="setAmount.add('#qty_item_1')" href="javascript:void(0)">
							+</a>
						</div>
						<br/>
						<button type="submit" id="addCart" class="btn btn-large btn-primary pull-right" onclick="saveCart()">加入购物车<i class=" icon-shopping-cart"></i></button>
					</form>
					<div class="reco">
					<h2>推荐理由</h2>
					<s:property value="model.preco"/>
					</div>
					<div class="store">
					<h2>店铺简介</h2>
					<s:property value="model.store.sdesc"/>
					</div>
					<div class="desc">
					<h2>商品描述</h2>
					<s:property value="model.pdesc"/>
					</div>
					<div class="guide">
					<h2>购物指南</h2>
					所有商品均为正品保证。<br/>
					下单后四个工作日内发货。<br/>
					中国大陆地区免运费，默认商家合作快递。<br/>
					如出现产品质量问题请在签收后72小时内联系客服。
					</div>
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
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/ui-choose.js"></script>
    <script src="${pageContext.request.contextPath}/js/payfor.js"></script>
    <script>
	// 将所有.ui-choose实例化
	$('.ui-choose').ui_choose();

	// uc_01 ul 单选
	var uc_01 = $('#uc_01').data('ui-choose'); // 取回已实例化的对象
	uc_01.click = function(index, item) {
	    console.log('click', index, item.text())
	}
	uc_01.change = function(index, item) {
	    console.log('change', index, item.text())
	}

	// uc_02 select 单选
	var uc_02 = $('#uc_02').data('ui-choose');
	uc_02.click = function(value, item) {
	    console.log('click', value);
	};
	uc_02.change = function(value, item) {
	    console.log('change', value);
	};
	</script>
    
</body>
</html>