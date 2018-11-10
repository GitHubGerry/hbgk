<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<title>何不管库</title>
	<jsp:include page="toolbar.jsp"></jsp:include>
	
</head>
<body>
<%	
		/*if(request.getAttribute("info1")!=null){*/
		/*session.setAttribute("userid",request.getAttribute("info1"));
		session.setAttribute("nickname",request.getAttribute("info2"));}*/
%>

主页-----欢迎<%=session.getAttribute("userid")%>


</body>
</html>