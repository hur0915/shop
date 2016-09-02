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
    <script>
	function checkForm(){
		// 校验用户名:
		// 获得用户名文本框的值:
		var username = document.getElementById("username").value;
		if(username == null || username == ''){
			alert("用户名不能为空!");
			return false;
		}
		// 校验密码:
		// 获得密码框的值:
		var password = document.getElementById("password").value;
		if(password == null || password == ''){
			alert("密码不能为空!");
			return false;
		}
		// 校验确认密码:
		var repassword = document.getElementById("repassword").value;
		if(repassword != password){
			alert("两次密码输入不一致!");
			return false;
		}
	}
	
	
	function checkUsername(){
		// 获得文件框值:
		var username = document.getElementById("username").value;
		// 1.创建异步交互对象
		var xhr = createXmlHttp();
		// 2.设置监听
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					document.getElementById("span1").innerHTML = xhr.responseText;
				}
			}
		}
		// 3.打开连接
		xhr.open("GET","${pageContext.request.contextPath}/user_findByName.action?time="+new Date().getTime()+"&username="+username,true);
		// 4.发送
		xhr.send(null);
	}
	
	function createXmlHttp(){
		   var xmlHttp;
		   try{ // Firefox, Opera 8.0+, Safari
		        xmlHttp=new XMLHttpRequest();
		    }
		    catch (e){
			   try{// Internet Explorer
			         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			      }
			    catch (e){
			      try{
			         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			      }
			      catch (e){}
			      }
		    }

			return xmlHttp;
		 }
	
	function change(){
		var img1 = document.getElementById("checkImg");
		img1.src="${pageContext.request.contextPath}/checkImg.action?"+new Date().getTime();
	}
	</script>     
</head>

<body>

<!--header-->
<%@ include file="header.jsp" %>

<section id="form"><!--form-->
	<div class="container">
		<div class="row">
			<div class="col-sm-5 col-sm-offset-1">
				<div class="login-form"><!--login form-->
					<h2>新用户注册</h2>
					<div>
						<s:actionerror />
					</div>
					<form class="form-horizontal" role="form" action="${ pageContext.request.contextPath }/user_regist.action"  method="post" novalidate="novalidate" onsubmit="return checkForm();">
						
						<div class="form-group">
      						<label class="col-sm-3 control-label">用户名</label>
      						<div class="col-sm-9">
      							<input type="text" class="form-control" name="username" placeholder="用户名" onblur="checkUsername()"/>
      						</div>
      						<span id="span1"></span>
   						</div>
   						
   						<div class="form-group">
      						<label class="col-sm-3 control-label">密码</label>
      						<div class="col-sm-9">
      							<input type="password" name="password" placeholder="密码"/>
      						</div>
      						<span><s:fielderror fieldName="password"/></span>
   						</div>
   						
   						<div class="form-group">
      						<label class="col-sm-3 control-label">确认密码</label>
      						<div class="col-sm-9">
      							<input type="password" name="repassword" placeholder="确认密码"/> 
      						</div>
   						</div>
   						
   						<div class="form-group">
      						<label class="col-sm-3 control-label">邮箱</label>
      						<div class="col-sm-9">
      							<input type="text" name="email" placeholder="邮箱"/>
      						</div>
      						<span><s:fielderror fieldName="email"/></span>
   						</div>
   						
   						<div class="form-group">
      						<label class="col-sm-3 control-label">姓名</label>
      						<div class="col-sm-9">
      							<input type="text" name="name" placeholder="姓名"/>
      						</div>
      						<span><s:fielderror fieldName="name"/></span>
   						</div>
   						
   						<div class="form-group">
      						<label class="col-sm-3 control-label">电话</label>
      						<div class="col-sm-9">
      							<input type="text" name="phone" placeholder="电话"/>
      						</div>
      						<span><s:fielderror fieldName="phone"/></span>
   						</div>
   						
   						<div class="form-group">
      						<label class="col-sm-3 control-label">地址</label>
      						<div class="col-sm-9">
      							<input type="text" name="addr" placeholder="地址"/>
      						</div>
      						<span><s:fielderror fieldName="addr"/></span>
   						</div>
   						
   						<div class="form-group">
      						<label class="col-sm-3 control-label">验证码</label>
      						<div class="col-sm-5">
      							<input type="text" id="checkcode" name="checkcode"/>
      						</div>
      						<div class="col-sm-4">
      							<img id="checkImg" class="captchaImage" src="${pageContext.request.contextPath}/checkImg.action" onclick="change()" title="点击更换验证码">
      						</div>
   						</div>
  						<div class="col-sm-offset-4">
							<button type="submit" class="btn btn-default">注册</button>
						</div>	
					</form>
				</div><!--/login form-->
			</div>
			<div class="col-sm-1">
				<h2 class="or">OR</h2>
			</div>
			<div class="col-sm-5">
				<h2>已注册？那就赶紧去<a href="${ pageContext.request.contextPath }/user_loginPage.action">登录</a>吧。</h2>
			</div>
		</div>
	</div>
</section><!--/form-->

</body>
</html>