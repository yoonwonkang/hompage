
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPMS by java41</title>
<link rel="stylesheet" href="<%=application.getContextPath()%>/css/base.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.do"></jsp:include>

<div id="content">
<h1>사용자정보</h1>
이름: ${member.name}<br>
이메일:${member.email }<br>
전화:${member.tel }<br>
</div>

<jsp:include page="/tail.jsp"></jsp:include>
</body>
</html>













