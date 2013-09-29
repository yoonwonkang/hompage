<%@page import="net.bitacademy.java41.vo.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>작업 등록</title>
<link rel="stylesheet" href="${rootPath}/css/base.css">
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>

	<jsp:include page="/sidebar.do"></jsp:include>

	<div id="content">
		<h1>신규 작업</h1> 					
		<form action="add.do" method="post" enctype="multipart/form-data">
			해당프로젝트 번호 <input type="text" name="projectNo" value="${projectNo}" readonly><br>
			작업명: <input type="text" name="title" required><br> 
			내용:<br>
			<textarea name="content" rows="4" cols="50" required></textarea>
			<br>
			UI프로토 타입 <input type="file" name="URL" > <br>
			시작일: <input type="date" name="startDate" placeholder="예)2013-4-5" required><br>
			종료일: <input type="date" name="endDate" placeholder="예)2013-6-5" required><br>
			
			<label>상태</label> 
			<select name="status" required><br>
				<option value="0" selected>생성</option>
				<option value="1">작업중</option>
				<option value="2">완료</option>
			</select> <br>
			<input type="submit" value="등록"><input type="reset"	value="취소">
			<a href="list.do?projectNo=${projectNo}">[목록]</a>
		</form>

	
	</div>

	<jsp:include page="/tail.jsp"></jsp:include>

</body>
</html>









