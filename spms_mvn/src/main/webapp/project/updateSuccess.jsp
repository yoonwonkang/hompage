<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Refresh" content="2;url=list.do">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트변경</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.do"></jsp:include>

<div id="content">
입력정보가 변경되었습니다.
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









