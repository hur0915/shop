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
		    <li class="active">商标注册流程</li>
		</ul>
		
		<div class="content">
			<center><h1><strong>商标注册流程</strong></h1></center>
			<center><h5>资料提供者: <font color="red">商标注册网律师团队</font></h5></center>
			<p>&nbsp;</p>
　　			<span>
				<strong>导语</strong>：商标注册是商标使用人取得商标专用权的前提和条件，只有经核准注册的商标，才受法律保护。商标注册原则是确定商标专用权的基本准则，不同的注册原则的选择，是各国立法者在这一个问题中对法律的确定性和法律的公正性二者关系进行权衡的结果。那么如何注册商标呢？
 			</span>
 			<p>&nbsp;</p>
 			<div>
　　				<strong>商标注册流程：</strong>
			</div>
			<p>&nbsp;</p>
			<div>
　　				商标查询（2天内）→申请文件准备（3天内）→提交申请（2天内）→商标形式审查（3~4个月）→下发商标受理通知书→商标实质审查（12个月左右）→初审公告（3个月）→领取商标注册证
 			</div>
 			<p>&nbsp;</p>
			<div>		
　　				<strong>一、商标查询（2天内）</strong><br/>
　　				商标查询是一项专业的工作，可以委托商标代理人(如商标注册网)代为查询，将会得到更准确的建议。			
 			</div>
 			<p>&nbsp;</p>
			<div>
　　				<strong>二、申请文件准备（3天内）</strong><br/>
　　				(1)自然人申请需出示您身份证及递交个体工商户、个人合伙等经营主体的营业执照复印件等。<br/>
　　				企业申请需出示企业《营业执照》副本及提供经发证机关签章的《营业执照》复印件。盖有单位公章及个人签字的填写完整的商标注册申请书等。<br/>
　　				(2)商标图样10张(指定颜色的彩色商标，应交着色图样10张，黑白墨稿1张)。
			</div>
			<p>&nbsp;</p>
 			<div>
　　				<strong>三、提交申请（2天内）</strong><br/>
　　				我国商标法执行的是商品国际分类，申请商标注册时，应按商品与服务分类表的分类确定使用商标的商品或服务类别。 
 			</div>
 			<p>&nbsp;</p>
 			<div>
　　				<strong>四、形式审查（3~4个月）</strong><br/>
　　				形式审查是商标注册主管机关对商标注册申请的书面文件以及一些形式要件，如申请书、委托书上是否有差错进行审查。
 			</div>
 			<p>&nbsp;</p>
 			<div>
　　				<strong>五、实质审查（12 个月左右）</strong><br/>
　　				实质审查是商标注册主管机关对商标注册申请是否合乎商标法的规定所进行的检查、资料检索、分析对比、调查研究并决定给予初步审定或驳回申请等一系列活动。
 			</div>
 			<p>&nbsp;</p>
 			<div>
　　				<strong>六、初审公告。（3个月左右）</strong><br/>
　　				商标的审定是指商标注册申请经审查后，对符合《商标法》有关规定的，允许其注册的决定。并在《商标公告》中予以公告。初步审定的商标自刊登初步审定公告之日起三个月没有人提出异议的，该商标予以注册，同时刊登注册公告。三个月内没有人提出异议或提出异议经裁定不成立的，该商标即注册生效，发放注册证。
 			</div>
 			<p>&nbsp;</p>
 			<div>
　　				<strong>七、领取商标注册证</strong><br/>
　　				通过商标注册网代理注册的由商标注册网向商标注册人发送《商标注册证》；<br/>
　　				直接办理商标注册的，商标注册人应在接到《领取商标注册证通知书》后三个月内到商标局领证。
 			</div>
 			<p>&nbsp;</p>
 			<div>
　　				<strong>关于商标注册网：</strong><br/>
　　				商标注册网是中国商标注册正规备案单位，由专业的执证律师团队服务，丰富的商标注册经验为您提供全面的注册方案，解决疑难问题。业务范围主要涉及国际商标注册、国内商标注册、续展、变更、许可、争议、驰名商标申请、著名商标申请、高新企业认证、双软认证、知识产权侵权、版权(软件登记)等。
			</div>
			<p>&nbsp;</p>
		</div>
			
	</div>
</div>

<!--footer-->
<%@ include file="footer.jsp" %>

</body>
</html>