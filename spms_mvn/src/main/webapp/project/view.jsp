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
<a href="view.do?no=${project.no}">[기본정보]</a> |
<a href="../task/list.do?projectNo=${project.no}">[작업들]</a> |
<a href="../feed/list.do?projectNo=${project.no}">[게시판]</a>
</p>
</div>
<h1>프로젝트 정보</h1>
번호: ${project.no}<br>
프로젝트명: ${project.title}<br>
내용:<br> 
${project.content }<br>
시작일: ${project.startDate }<br>
종료일: ${project.endDate }<br>
태그: ${project.tag }<br>
<br>
<table>
<tr>
	<th>이메일</th>
	<th>이름</th>
	<th>블로그</th>
	<th>전화번호</th>
	<th>상태</th>
</tr>
<c:forEach var="projectMember" items="${projectMember}">
<tr>
	<td>${projectMember.email}</td>
	<td>${projectMember.name}</td>
	<td>${projectMember.blog}</td>
	<td>${projectMember.tel}</td>
	<td><c:if test="${projectMember.memLevel == 0}">(PL)</c:if></td>
</tr>	
</c:forEach>
</table>

<p>
<a href="list.do">[목록]</a>
<c:choose>
	<c:when test="${projectLeader == 0}">
		<a href="update.do?no=${project.no}">[변경]</a>
		<a href="delete.do?no=${project.no}">[삭제]</a>
	</c:when>
	<c:when test="${member.memLevel == 1}">
		<a href="update.do?no=${project.no}">[변경]</a>
		<a href="delete.do?no=${project.no}">[삭제]</a>
	</c:when>
</c:choose>

</p>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









