<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
<head>
<title>category_list</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> 
	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<script src="${pageContext.request.contextPath }/js/jquery-2.1.1.min.js"></script> 
<link href="${pageContext.request.contextPath }/css/font-awesome.css" rel="stylesheet"> 

<script type="text/javascript">
	function addCategory(){
		window.location.href = "${pageContext.request.contextPath}/admin/category_add.jsp";
	}
</script>

</head>
<body>	
<div class="page-container">	
	<div class="left-content">
		<div class="mother-grid-inner">
	   	
		   	<!--header start here-->
		   	<%@ include file="top.jsp" %>
		   
		   	<!--inner block start here-->
			<div class="inner-block">
				<center>
					<strong>一级分类列表</strong>
					<button class="btn btn-primary" onclick="addCategory()">添加</button>
				</center>
				
				<p>&nbsp;</p>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>序号</th>
							<th>一级分类名称</th>
							<th>编辑</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator var="c" value="cList" status="status">
						<tr>
							<td>
								<s:property value="#status.count"/>
							</td>
							<td>
								<s:property value="#c.cname"/>
							</td>
							<td>
								<a href="${ pageContext.request.contextPath }/adminCategory_edit.action?cid=<s:property value="#c.cid"/>">
									编辑
								</a>
							</td>
							<td>
								<a href="${ pageContext.request.contextPath }/adminCategory_delete.action?cid=<s:property value="#c.cid"/>">
									删除
								</a>
							</td>
						</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>	
	   </div>
	</div>
	
	<!--slider menu-->
	<%@ include file="sidebar.jsp" %>
</div>

	<script src="${pageContext.request.contextPath }/js/jquery.nicescroll.js"></script>
	<script src="${pageContext.request.contextPath }/js/scripts.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.js"> </script>
	
</body>
</html>