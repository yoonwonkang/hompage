<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>암호변경</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.do"></jsp:include>

<div id="content">
<h1>암호변경</h1>
<form action="myInfopasswordControl.do" method="post">
이메일: <input type="text" name="email" value="${member.email}" readonly><br>
이전 암호: <input type="password" name="password" required><br>
새 암호: <input type="password" name="newPassword" required><br>
새 암호 확인: <input type="password" name="newPassword2" required><br>
<input type="submit" value="변경">

</form>
<p>
<a href="updateMyInfo.do">[이전]</a>
<a href="../main.do">[메인]</a></p>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









