<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--header start here-->
<div class="header-main">
	<div class="header-left">
		<div class="logo-name">
			<a href="index.html"> <h1>Shoppy</h1></a>
		</div>
		<div class="clearfix"> </div>
	</div>
	<div class="header-right">
		<div class="profile_details">		
			<ul>
				<li>欢迎您，<s:property value="#session.existAdminUser.username"/></li>
				<li> <a href="#"><i class="fa fa-sign-out"></i>退出</a> </li>
			</ul>
		</div>
		<div class="clearfix"> </div>				
	</div>
    <div class="clearfix"> </div>	
</div>
<!--header end here-->

<!-- script-for sticky-nav -->
<script>
$(document).ready(function() {
	 var navoffeset=$(".header-main").offset().top;
	 $(window).scroll(function(){
		var scrollpos=$(window).scrollTop(); 
		if(scrollpos >=navoffeset){
			$(".header-main").addClass("fixed");
		}else{
			$(".header-main").removeClass("fixed");
		}
	 });
	 
});
</script>
<!-- /script-for sticky-nav -->