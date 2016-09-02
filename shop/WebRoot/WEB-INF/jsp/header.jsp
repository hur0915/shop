<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header id="header"><!--header-->
	<div class="header_top hidden-xs hidden-sm"><!--header_top-->
		<div class="container">
			<div class="row">
				<div class="col-sm-6 ">
					<div class="contactinfo">
						<ul class="nav nav-pills">
							<li><a href=""><i class="fa fa-phone"></i> +132 47 70 3118</a></li>
							<li><a href=""><i class="fa fa-envelope"></i> 1531610082@qq.com</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="social-icons pull-right">
						<ul class="nav navbar-nav">
							<li><a href=""><i class="fa fa-facebook"></i></a></li>
							<li><a href=""><i class="fa fa-apple"></i></a></li>
							<li><a href=""><i class="fa fa-weibo"></i></a></li>
							<li><a href=""><i class="fa fa-weixin"></i></a></li>
							<li><a href=""><i class="fa fa-qq"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div><!--/header_top-->

	<div class="header-middle"><!--header-middle-->
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="logo pull-left">
						<a href="index.html"><img src="${ pageContext.request.contextPath }/images/logo.png" alt="" /></a>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="shop-menu pull-right">
						<ul class="nav navbar-nav">
						
						<s:if test="#session.existUser == null">
							<li><a href="${ pageContext.request.contextPath }/user_loginPage.action"><i class="fa fa-lock"></i> 登录</a></li>
							<li><a href="${ pageContext.request.contextPath }/user_registPage.action"><i class="fa fa-tag"></i> 注册</a></li>
						</s:if>
						<s:else>
							<li><a href=""><i class="fa fa-user"></i> <s:property value="#session.existUser.name"/></a></li>
							<li><a class="lock" href="${pageContext.request.contextPath }/order_findByUid.action?page=1">订单</a></li>
							<li><a href=""><i class="fa fa-star"></i> 心愿单</a></li>
							<li><a href="${ pageContext.request.contextPath }/user_quit.action"><i class="fa fa-crosshairs"></i> 退出</a></li>		
						</s:else>
							<li><a href="${ pageContext.request.contextPath }/cart_myCart.action"><i class="fa fa-shopping-cart"></i> 购物车<span>￥<s:property value="#session.cart.total"/></span></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div><!--/header-middle-->

	<div class="header-bottom"><!--header-bottom-->
		<div class="container">
			<div class="row">
				<div class="col-sm-9">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>
					<div class="mainmenu pull-left">
						<ul class="nav navbar-nav collapse navbar-collapse">
							<li><a href="${pageContext.request.contextPath }/index.action">首页</a></li>
							<li class="dropdown"><a href="${pageContext.request.contextPath }/product_shop.action" class="active">商店<i class="fa fa-angle-down"></i></a>
                                <ul role="menu" class="sub-menu">
                                <s:iterator var="c" value="#session.cList">
                                    <li><a href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1" class="active"><s:property value="#c.cname"/></a></li>
								</s:iterator> 
                                </ul>
                            </li> 
                            <li><a href="404.html">每日搭配</a></li>
							<li class="dropdown"><a href="http://www.divmb.com">分享<i class="fa fa-angle-down"></i></a>
                                <ul role="menu" class="sub-menu">
                                    <li><a href="blog.html">Blog List</a></li>
									<li><a href="blog-single.html">Blog Single</a></li>
                                </ul>
                            </li> 
							<li><a href="contact-us.html">联系我们</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="search_box pull-right">
						<form>
							<input type="text" placeholder="Search" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Search';}"/>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>		