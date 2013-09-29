<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 정보</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.do"></jsp:include>

<div id="content">
<div id="submenu">
<p>
<a href="../main.do">[메인]</a> |
<a href="../feed/list.do?projectNo=${task.projectNo}">[게시판]</a>
</p>
</div>
<h1>작업 정보</h1>
작업번호: ${task.taskNo}<br>
프로젝트번호: ${task.projectNo}<br>
작업명: ${task.title }<br>
ui프로토타입 :<br>
<img src="${rootPath}/file/${task.uiProtoUrl}"><br>
내용:<br> 
${task.content}<br>
시작일: ${task.startDate }<br>
종료일: ${task.endDate }<br>
상태:<c:choose>
			<c:when test="${task.status == 0}">생성</c:when>
			<c:when test="${task.status == 1}">착수중</c:when>
			<c:when test="${task.status == 2}">완료</c:when>
	  	</c:choose>
<br>

<p>
<a href="../task/list.do?projectNo=${task.projectNo}">[목록]</a>
<a href="update.do?projectNo=${task.projectNo}&taskNo=${task.taskNo}">[변경]</a>
<a href="delete.do?taskNo=${task.taskNo}&projectNo=${task.projectNo}">[삭제]</a>
</p>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









