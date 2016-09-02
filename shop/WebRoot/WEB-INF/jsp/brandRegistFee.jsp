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
		    <li><a href="index.html">创业指导</a> <span class="divider">/</span></li>
		    <li><a href="products.html">商标注册</a> <span class="divider">/</span></li>
		    <li class="active">商标注册费用</li>
		</ul>
		
		<div class="content">
			<center><h1><strong>商标注册费用</strong></h1></center>
			<center><h5>资料提供者: <font color="red">商标注册网律师团队</font></h5></center>
			<p>&nbsp;</p>
　　			<span>
				<strong>导语</strong>：商标注册的费用会因申请途径的不同而有差异，个人到商标局自行申请办理注册，则按照国家商标局的规定收取费用千元即可;如果委托商标注册代理机构办理，则需要另外缴纳部分代理费用，每个代理机构费用标准也不同，通常在600-1000之间。
 			</span>
 			<p>&nbsp;</p>
 			<div>
　　				<strong>委托商标代理机构其实是最省钱的商标注册方式</strong>
			</div>
			<p>&nbsp;</p>
			<div>
　　				最省钱的商标注册方式，是委托商标注册代理公司，这么说，你是不是感觉特别不可思议，或者说无法相信，当然是有原因的。通过上面的了解，我们都知道官费那一千元，是固定的，谁也改变不了。
 			</div>
 			<p>&nbsp;</p>
			<div>		
　　				如果自己申请商标注册的话，那么最划算的方式可能会想到，就是自己去北京国家商标局递交申请材料。这是我们首先认为最省钱的，可来回的差旅费用，不一定会比600元少!如果在商标注册的过程当中，出现了意外，需要自己解决，比如商标注册中的补正，异议以及复审等诸多无法预测的未知风险，不具备扎实专业知识和没有丰富注册经验，自己单枪匹马解决这些紧急问题是非常困难的，而且都是需要成本的，暂且不说花费的金钱成本，在来回的奔波和消耗中，时间在悄然流失。这是商标注册最致命的事情，越晚就越多一分风险。			
 			</div>
 			<p>&nbsp;</p>
			<div>
　　				那我们再来看看委托商标注册代理机构的便利之处，您只需要交纳一些代理费用(600-1000元之间)然后签定合同，后续的注册细节和遇到的棘手问题都不用您操心。代理费用和差旅费用做个比较，哪个多，哪个少，您可以做个权衡。而且商标注册代理机构经验肯定比个人丰富的多，所以，综合下来，委托商标注册代理机构的费用并不会比您独自申请注册的费用更多，相反，委托商标代理机构会更省钱，时间也相对更快。
			</div>
			<p>&nbsp;</p>
 			<div>
　　				备注：(商标注册期间可能会出现，商标补正，商标异议，商标答辩，商标驳回复审，商标撤销，商标恶意抢注等各种情况发生，代理公司会时刻关注商标进展情况，定期给客户反馈注册进度)
 			</div>
 			<p>&nbsp;</p>
		</div>
			
	</div>
</div>

<!--footer-->
<%@ include file="footer.jsp" %>

</body>
</html>