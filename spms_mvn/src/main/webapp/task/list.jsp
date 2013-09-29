<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>작업 목록</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.do"></jsp:include>

<div id="content">
<h1>프로젝트 세부 작업 리스트</h1>
<table>
<tr>
	<th>작업번호</th>
	<th>작업명</th>
	<th>UI프로토타입URL주소</th>
	<th>상태</th>
</tr>
<%int i=0; %>
<c:forEach var="task" items="${taskList}">
 <%i++;%>
<tr>
	<td><%=i%></td>
	<td><a href="view.do?no=${task.taskNo}">${task.title}</a></td>
	<td>${task.uiProtoUrl}</td>
	<td><c:choose>
			<c:when test="${task.status == 0}">미시작</c:when>
			<c:when test="${task.status == 1}">착수중</c:when>
			<c:when test="${task.status == 2}">완료</c:when>
	  	</c:choose></td>
</tr>	
</c:forEach>
</table>

<p>
<a href="../project/list.do">[이전]</a>
<a href="add.do?projectNo=${no}">[작업추가]</a>

</p>

</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









