<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Refresh" content="2;url=view.do?email=${email}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>암호변경</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.do"></jsp:include>

<div id="content">
<c:choose>
<c:when test="${status == 'NEW_PASSWORD_ERROR'}">신규 암호가 일치하지 않습니다.</c:when>
<c:when test="${status == 'OLD_PASSWORD_ERROR'}">이전 암호가 맞지 않습니다.</c:when>
<c:when test="${status == 'SUCCESS'}">암호가 변경되었습니다.</c:when>
<c:otherwise>손님</c:otherwise>
</c:choose><br>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









