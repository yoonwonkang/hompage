<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Refresh" content="2;url=updateMyInfoForm.do">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>암호변경</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.do"></jsp:include>

<div id="content">
<c:choose>
<c:when test="${status == 'PASSWORD_EQUALS_ERROR'}">입력하신 암호가 일치하지 않습니다.</c:when>
<c:when test="${status == 'PASSWORD_CONFIG_ERROR'}">입력하신 암호가 확인 암호와 일치하지 않습니다.</c:when>
<c:when test="${status == 'FAIL'}">변경 중 오류가 발생하였습니다</c:when>
</c:choose><br>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









