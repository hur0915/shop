<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--slider menu-->
<div class="sidebar-menu">
	<div class="logo"> 
		<a href="#" class="sidebar-icon"> 
			<span class="fa fa-bars"></span> 
		</a> 
		<a href="#"> <span id="logo" ></span> 
		      <!--<img id="logo" src="" alt="Logo"/>--> 
		</a> 
	</div>		  
	<div class="menu">
	    <ul id="menu" >
	    	<li id="menu-home" >
	    		<a href="index.html">
	    			<i class="fa fa-tachometer"></i>
	    			<span>首页</span>
	    		</a>
	    	</li>
	        <li>
	        	<a href="#">
	        		<i class="fa fa-cogs"></i>
	        		<span>用户管理</span>
	        		<span class="fa fa-angle-right" style="float: right"></span>
	        	</a>
	          	<ul>
	            	<li><a href="${pageContext.request.contextPath}/userAdmin_findAll.action?page=1">用户</a></li>
	            	<li><a href="portlet.html">管理员</a></li>
	          	</ul>
	        </li>
	        <li id="menu-comunicacao" >
	        	<a href="${pageContext.request.contextPath}/adminCategory_findAll.action">
	        		<i class="fa fa-book nav_icon"></i>
	        		<span>一级分类管理</span>
	        		<span class="fa fa-angle-right" style="float: right"></span>
	        	</a>
	        </li>
	        <li>
	        	<a href="${pageContext.request.contextPath}/adminCategorySecond_findAll.action?page=1">
	        		<i class="fa fa-map-marker"></i>
	        		<span>二级分类管理</span>
	        	</a>
	        </li>
	        <li>
	        	<a href="${pageContext.request.contextPath}/adminProduct_findAll.action?page=1">
	        		<i class="fa fa-map-marker"></i>
	        		<span>商品管理</span>
	        	</a>
	        </li>
	        <li>
	        	<a href="${pageContext.request.contextPath}/adminOrder_findAll.action?page=1">
	        		<i class="fa fa-map-marker"></i>
	        		<span>订单管理</span>
	        	</a>
	        </li>
	        <li>
	        	<a href="${pageContext.request.contextPath}/adminCarousel_findAll.action">
	        		<i class="fa fa-map-marker"></i>
	        		<span>广告管理</span>
	        	</a>
	        </li>
	    </ul>
	</div>
</div>
<div class="clearfix"> </div>
<!--slide bar menu end here-->

<script>
var toggle = true;           
$(".sidebar-icon").click(function() {                
  if (toggle){
    $(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
    $("#menu span").css({"position":"absolute"});
  }
  else{
    $(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
    setTimeout(function() {
      $("#menu span").css({"position":"relative"});
    }, 400);
  }               
  toggle = !toggle;
  });
</script>