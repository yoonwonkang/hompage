<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 등록</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<jsp:include page="/sidebar.do"></jsp:include>

<div id="content">
<h1>프로젝트 수정</h1>
<form action="update.do" method="post">
프로젝트번호: <input type="text" name="no" value="${project.no}" readonly><br>
프로젝트명: <input type="text" name="title" value="${project.title}" required><br>
내용:<br> 
<textarea name="content" rows="4" cols="50" required>${project.content}</textarea><br>
시작일: <input type="date" name="startDate" value="${project.startDate}" required><br>
종료일: <input type="date" name="endDate" value="${project.endDate}" required><br>
태그: <input type="text" name="tag" value="${project.tag}"><br>
<input type="submit" value="등록"><input type="reset" value="취소"><br>
</form>
<p><a href="list.do">[목록]</a></p>
</div>

<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









